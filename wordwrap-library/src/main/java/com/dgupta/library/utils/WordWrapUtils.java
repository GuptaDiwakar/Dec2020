
public class WordWrapUtils {
	
	  public static void checkArgument(boolean b) {
	        if (!b)
	            throw new IllegalArgumentException();
	    }
	  
	  static String wrapIndividualLines(String lineBreak, String input, int breakLength) {
	        String[] individualWords = input.split(Constants.SPACE);
	        StringBuilder lineBuilder = new StringBuilder();
	        StringBuilder outputBuilder = new StringBuilder();

	        for (String word : individualWords) {
	            if (isLineExceedingBreakLength(breakLength, lineBuilder, word)) {
	                outputBuilder.append(lineBuilder.toString().trim()).append(lineBreak);
	                lineBuilder = new StringBuilder();
	            }
	            lineBuilder.append(word).append(Constants.SPACE);
	        }
	        outputBuilder.append(lineBuilder).append(lineBreak);

	        return outputBuilder.toString().trim();
	    }

	    static boolean isLineExceedingBreakLength(int breakLength, StringBuilder lineBuilder, String word) {
	        return word.length() + lineBuilder.length() + 1 > breakLength && lineBuilder.length() > 0;
	    }

}
