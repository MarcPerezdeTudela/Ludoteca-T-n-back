package com.ccsw.tutorial.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Already exist")
public class AlreadyExistException extends Exception {

}
