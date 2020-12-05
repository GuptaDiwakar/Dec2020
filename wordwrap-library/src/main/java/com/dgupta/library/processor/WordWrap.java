package com.dgupta.library.processor;

public class WordWrap {
    /**
     * @param input       the input which needs to be wrapped
     * @param breakLength at what length the string needs to be wrapped
     * @param lineBreak   which character to be used for new liner
     * @return wrapped string
     */
    public String wrapString(String lineBreak, String input, int breakLength) {
        if (breakLength <= 0)
            throw new IllegalArgumentException("Break length should be more than zero.");
        if (input.length() < breakLength)
            return input;
        return wrapIndividualLines(lineBreak, input, breakLength);
    }

    private String wrapIndividualLines(String lineBreak, String input, int breakLength) {
        String[] individualWords = input.split(" ");
        StringBuilder lineBuilder = new StringBuilder();
        StringBuilder outputBuilder = new StringBuilder();

        for (String word : individualWords) {
            if (isLineExceedingBreakLength(breakLength, lineBuilder, word)) {
                outputBuilder.append(lineBuilder.toString().trim()).append(lineBreak);
                lineBuilder = new StringBuilder();
            }
            lineBuilder.append(word).append(" ");
        }
        outputBuilder.append(lineBuilder).append(lineBreak);

        return outputBuilder.toString().trim();
    }

    private boolean isLineExceedingBreakLength(int breakLength, StringBuilder lineBuilder, String word) {
        return word.length() + lineBuilder.length() + 1 > breakLength && lineBuilder.length() > 0;
    }
}
