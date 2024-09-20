package examples;

import java.util.Scanner;
import java.util.Arrays;

public class RollOneDie {
    private static int rollCount = 0;

    public static void main(String[] args) {

        System.out.println("Velkommen til spillet, rul en terning.");
        printRules();
        System.out.println();

        playOneDie();

        System.out.println();
        System.out.println("Tak for at spille, rul en terning.");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for rul en terning");
        System.out.println("Spilleren ruller en terning, så længde man lyster.");
        System.out.println("=====================================================");
    }

    private static void playOneDie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul en terning? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int[] faces = rollDice();
            System.out.print("Du rullede: ");
            for (int j : faces) {
                while(j==0){
                    System.out.print(j+" ");
                }
                while (j==1);
                System.out.print(j+" ");
            }
            System.out.println();

            updateStatistics();

            System.out.print("Rul en terning? ('ja/nej') ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    private static void updateStatistics() {
        rollCount++;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Antal rul:", rollCount);
    }
    public static int[] rollDice(){
        int[] slag = new int[2];
        int terning1 = rollDie();
        int terning2 = rollDie();

        for (int i = 0; i < slag.length -1 ; i++) {
            slag[i] = terning1;
            slag[i+1] = terning2;
        }

        return slag;
    }

}
