package com.acme.statusmgr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A class for a custom exception to be called when a
 * user inputs a non-valid detail item
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ForbiddenDetailsException extends RuntimeException {

    /**
     * @param message message describing which detail caused the error
     */
    public ForbiddenDetailsException(String message){
        super(message);
    }

}
