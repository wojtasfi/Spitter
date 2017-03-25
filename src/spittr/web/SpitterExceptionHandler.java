package spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SpitterExceptionHandler {

	@ExceptionHandler(DuplicateSpittleException.class)
	public String handleDuplicateSpitter() {
		return "error/duplicate";
	}

	@ExceptionHandler(SpittleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error spittleNotFound(SpittleNotFoundException e) {

		long spittleId = e.getSpittleId();

		return new Error(4, "Spittle " + spittleId + " not found");
	}
}
