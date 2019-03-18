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
 *         Define exception in case of unexpected JSON returned by Spotify's
 *         public API
 */
@ControllerAdvice
public class FetchSpotifyExceptionController {

	@ExceptionHandler(value = FetchSpotifyProcessJSONResponseException.class)
	public ResponseEntity<String> exception(FetchSpotifyProcessJSONResponseException exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("{\"error\" : \"Could not process Spotify JSON response\"}");
	}

}
