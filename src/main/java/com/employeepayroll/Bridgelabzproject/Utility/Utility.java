package com.employeepayroll.Bridgelabzproject.Utility;


import com.employeepayroll.Bridgelabzproject.model.Employee;

import java.security.PublicKey;
import java.util.List;

public class Utility {
    /*
    Method to get response
     */
    public static Response getResponse(String message, Object data) {
        return new Response(message, data);
    }

}
