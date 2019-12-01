package codesignal;

import org.junit.Test;

import java.util.Arrays;

public class Addend {

    boolean signFlag = false;

    String[] additionTrick(int addend) {

        if (addend < 0) {
            signFlag = true;
            addend = -addend;
        }

        int[] digits = getArray(addend);
        String[] temp = new String[digits.length + 5];
        int previous = 0;
        int j = 0;

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 5 || (digits[i] == 5 && exists(digits, i))) {
                int value = mathPow(10, digits.length - i);
                if (String.valueOf(previous).replace("-","").length() == String.valueOf(value).length()) {
                    value = value + previous;
                    j--;
                }
                temp[j] = String.valueOf(value);
                j++;
                int prevVal = (10 - digits[i]) * mathPow(10, digits.length - i - 1);
                temp[j] = "-" + prevVal;
                j++;
                previous = -prevVal;
            } else {
                int value = digits[i] * mathPow(10, digits.length - i - 1);
                if (String.valueOf(previous).length() == String.valueOf(value).length()) {
                    value = value + previous;
                    j--;
                }
                temp[j] = String.valueOf(value);
                j++;
                previous = value;
            }
        }

        return transformResult(Arrays.stream(temp).filter(p-> (p!= null && !p.equals("0"))).toArray(String[]::new));
    }

    boolean exists(int[] digits, int i) {
        for (int j = i+1; j < digits.length; j++){
            if (digits[j] > 0){
                return true;
            }
        }
        return false;
    }

    int[] getArray(int number) {
        String temp = Integer.toString(number);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            newGuess[i] = temp.charAt(i) - '0';
        }
        return newGuess;
    }

    int mathPow(int x, int pow) {
        return (int) Math.pow(x, pow);
    }

    String[] transformResult(String[] numbers) {
        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].contains("-")) {
                if (signFlag) {
                    result[i] = "add " + numbers[i].replace("-", "");
                } else {
                    result[i] = "subtract " + numbers[i].replace("-", "");
                }

            } else {
                if (signFlag) {
                    result[i] = "subtract " + numbers[i].replace("-", "");
                } else {
                    result[i] = "add " + numbers[i].replace("-", "");
                }

            }

        }
        return result;
    }

    @Test
    public void doTest() {
        String[] result = additionTrick(256067409);
        for (String s : result) {
            System.out.println(s);
        }

    }
}
