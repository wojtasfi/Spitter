package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SpitterExceptionHandler {

	@ExceptionHandler(DuplicateSpittleException.class)
	public String handleDuplicateSpitter() {
		return "error/duplicate";
	}

}
