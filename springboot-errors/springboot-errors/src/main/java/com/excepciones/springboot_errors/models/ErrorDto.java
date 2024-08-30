package com.excepciones.springboot_errors.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ErrorDto {

    private String message;
    private String error;
    private int status;
    private Date date;
}
