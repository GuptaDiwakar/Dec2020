package com.dgupta.word_wrap.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMessage {

    private LocalDate timestamp;
    private String message;

}
