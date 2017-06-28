package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import util.Message;
import util.MessageFactory;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class ImportController {

	private final CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();

	@RequestMapping("/sse")
	public SseEmitter readMessage() {
		SseEmitter emitter = new SseEmitter(1800_000L);
		this.emitters.add(emitter);

		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(() -> {
			Message message;
			do {
				message = MessageFactory.read();
				try {
					emitter.send(message);
					Thread.sleep(200);
				} catch (Exception e) {
					e.printStackTrace();
					emitter.completeWithError(e);
					return;
				}
			} while (!message.getType().equals(Message.CLOSE));

			emitter.complete();
			this.emitters.remove(emitter);
		});

		return emitter;
	}

}
