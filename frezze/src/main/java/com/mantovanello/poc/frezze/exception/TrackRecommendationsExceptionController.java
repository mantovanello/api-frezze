/**
 * 
 */
package com.mantovanello.poc.frezze.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Mantovanello
 * 
 *         Define exception in case of no data found in database
 */
@ControllerAdvice
public class TrackRecommendationsExceptionController {

	@ExceptionHandler(value = TrackRecommendationsNoContentException.class)
	public ResponseEntity<Object> exception(TrackRecommendationsNoContentException exception) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
