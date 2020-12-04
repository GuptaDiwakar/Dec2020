package com.dgupta.word_wrap.service;

import com.dgupta.library.processor.WordWrap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WordWrapServiceImpl {
    private static final WordWrap wordWrap = new WordWrap();

    @Value("${wordwrap.default.length}")
    private int defaultBreakLength;
    @Value("${wordwrap.default.character}")
    private String breakCharacter;

    public String wordWrap(String input, int breakLength, String breakCharacter) {
        if (breakLength < 0)
            throw new IllegalArgumentException("Break length should be more than zero.");
        if (breakLength == 0)
            breakLength = defaultBreakLength;
        if (breakCharacter == null || breakCharacter.isEmpty())
            breakCharacter = this.breakCharacter;
        StringBuilder sb = new StringBuilder();
        return wordWrap.wrapString(breakCharacter, input, breakLength);

    }


}
