package com.employeepayroll.Bridgelabzproject.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


/*
methods to handle exceptions
 */
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ExceptionMessage.class)
    public ResponseEntity<customException> handleresourcenotfounf(ExceptionMessage msg, WebRequest request) {
        customException cs = new customException(
                new Date(),
                msg.getMessage(),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<customException>(cs, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlePayrollNotFoundException(Exception e) {
        customException exception = new customException(new Date(), e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
