package co.edu.itm.clinicaldata.mapper;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.edu.itm.clinicaldata.exception.ValidateException;

@ControllerAdvice
public class Mapper extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = Logger.getLogger(Mapper.class.getName());

	@ExceptionHandler(ValidateException.class)
	protected ResponseEntity<Object> handleEntityNotFound(ValidateException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex);
		LOGGER.error(ex.getMessage(), ex);
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
