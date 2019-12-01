package codinggame;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int speed = in.nextInt();
        int lightCount = in.nextInt();
        int[] duration = new int[lightCount];
        int[] distance = new int[lightCount];
        for (int i = 0; i < lightCount; i++) {
            distance[i] = in.nextInt();
            duration[i] = in.nextInt();
        }
        int result = 0;
        for (int i=speed;i>0;i--){
            if (i%18 == 0){
                int meters = (i/18)*5;
                if (checkLights(distance, duration, meters, lightCount)){
                    result = i;
                    break;
                }
            } else {
                double mps = kmph_to_mps(i);

                if (checkLights(distance, duration, mps, lightCount)) {
                    result = i;
                    break;
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result);
    }

    static double kmph_to_mps(int kmph) {
        return (0.277777778 * kmph);
    }

    static boolean checkLights(int[] distance, int[] duration, double speed, int count){
        for (int i=0; i<count;i++){
            if (!check(distance[i]/speed, duration[i])){
                return false;
            }
        }
        return true;
    }

    static boolean check(double time, int duration){
        if (time < duration || Math.abs(time-duration) < 0.0001)
            return true;
        if (time > duration && time < duration*2 && Math.abs(time-2*duration) > 0.0001)
            return false;
        return check(time -2*duration, duration);
    }

    static boolean checkLights(int[] distance, int[] duration, int speed, int count){
        for (int i=0; i<count;i++){
            if (!check(distance[i]/speed, duration[i])){
                return false;
            }
        }
        return true;
    }


}