package controller;

import model.Season;
import nbadatautils.DataImportUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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


	@RequestMapping(value = "/import", method = RequestMethod.POST)
	public ResponseEntity importData(@RequestParam("season") String seasonTitle, @RequestParam("seasonType") String seasonType) {
		Season season = new Season();
		season.setTitle(seasonTitle);
		season.setType(seasonType);

		DataImportUtil importUtil = new DataImportUtil();

		MessageFactory.clearMessage();

		importUtil.importData(season);

		MessageFactory.write(new Message(Message.CLOSE));

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
