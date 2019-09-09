/*
 * Created by Ada.Sarca
 * Date: 9/9/2019
 */
package com.example.spring.model.exception;

public class DatabaseException extends Exception {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
