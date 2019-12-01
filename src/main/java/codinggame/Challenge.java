import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String line = in.next();
            if (!line.contains("0"))
                System.out.println("0");
            if (!line.contains("1"))
                System.out.println("1");
            if (!line.contains("2"))
                System.out.println("2");
            if (!line.contains("3"))
                System.out.println("3");
            if (!line.contains("4"))
                System.out.println("4");
            if (!line.contains("5"))
                System.out.println("5");
            if (!line.contains("6"))
                System.out.println("6");
            if (!line.contains("7"))
                System.out.println("7");
            if (!line.contains("8"))
                System.out.println("8");
            if (!line.contains("9"))
                System.out.println("9");
        }

    }
}