package codewars;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: Muksia
 * Date: 05/09/15
 * Time: 19:09
 */
public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        String result = "";
        morseCode = morseCode.trim();
        String[] words = morseCode.split("   ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                result += "";//MorseCode.get(letter);
            }
            result += " ";
        }
        return result.trim();
    }

    @Test
    public void testExampleFromDescription() {
        assertThat(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."), is("HEY JUDE"));
    }
}
