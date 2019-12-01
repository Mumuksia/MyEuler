package codinggame;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            X0 = getX(X0, W, bombDir);
            Y0 = getY(Y0, H, bombDir);


            // the location of the next window Batman should jump to.
            System.out.println("" + X0 + " " + Y0);
        }
    }

    public static int getX(int X0, int W, String bomb){
        if (bomb.contains("R")){
            return X0 + (int) Math.ceil((double)(W-X0) / 2);
        }

        if (bomb.contains("L")){
            return X0 - (int) Math.ceil((double)(X0) / 2);
        }

        return X0;

    }

    public static int getY(int Y0, int H, String bomb){
        if (bomb.contains("D")){
            return Y0 + (int) Math.ceil((double)(H-Y0) / 2);
        }

        if (bomb.contains("U")){
            return Y0 - (int) Math.ceil((double)(Y0) / 2);
        }

        return Y0;

    }
}

