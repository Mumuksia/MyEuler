package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StripComments {

  public static String stripComments(String text, String[] commentSymbols) {
    StringBuilder result = new StringBuilder();
    String[] splittedText = text.split("\n");
    for (String line : splittedText){
      for (char c: line.toCharArray()){
        //if ()
      }
    }

    return "";
  }


  @Test
  public void stripComments() throws Exception {
    assertEquals(
      "apples, pears\ngrapes\nbananas",
      StripComments.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
    );

    assertEquals(
      "a\nc\nd",
      StripComments.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
    );
  }

  private boolean checkIfComment(String c, String[] commentSymbols){
    for (String comment : commentSymbols){
      if (comment.equals(c))
        return true;
    }
    return false;
  }
}
