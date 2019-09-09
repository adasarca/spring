/*
 * Created by Ada.Sarca
 * Date: 9/9/2019
 */
package com.example.spring.model.response;

public class ErrorResponse {

    private Integer code;
    private String message;

    public ErrorResponse() { }

    public ErrorResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
