package com.dgupta.word_wrap.controller;

import com.dgupta.word_wrap.service.WordWrapServiceImpl;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
public class WordWrapController {
    final
    WordWrapServiceImpl wordWrapService;

    public WordWrapController(WordWrapServiceImpl wordWrapService) {
        this.wordWrapService = wordWrapService;
    }

    @PostMapping("/wordWrap")

    public ResponseEntity<String> wordWrap(@Valid @RequestBody Input input) {
        return new ResponseEntity<>(wordWrapService.wordWrap(input.getInput(), input.getBreakLength(), input.getBreakString()), HttpStatus.OK);
    }

    @Data
    static
    class Input {
        @NotNull(message = "Input string cannot be null.")
        @NotEmpty(message = "Input string cannot be empty.")
        private String input;
        @Min(value = 1, message = "The break length cannot be less than 1.")
        private int breakLength;
        private String breakString;
    }
}
