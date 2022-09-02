package com.employeepayroll.Bridgelabzproject.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/*
Exception model class
 */
@Data
@AllArgsConstructor
public class customException {
    private Date timestamp;
    private String message;
    private int statusCode;

}
