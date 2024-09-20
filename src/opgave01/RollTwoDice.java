package examples;

import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int sumDice = 0;
    private static int sameDice = 0;
    private static int highestDice = 0;
    private static int[] possibleDie = {1, 2, 3, 4, 5, 6};
    private static int[] dieCount = new int[6];

    public static void main(String[] args) {

        System.out.println("Velkommen til spillet, rul en terning.");
        printRules();
        System.out.println();

        PlayTwoDice();

        System.out.println();
        System.out.println("Tak for at spille, rul en terning.");

    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for rul en terning");
        System.out.println("Spilleren ruller en terning, så længde man lyster.");
        System.out.println("=====================================================");
    }

    private static void PlayTwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul en terning? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int[] faces = rollDice();
            System.out.print("Du rullede: ");


            System.out.print(faces[0] + " ");


            System.out.print(faces[1]);

            System.out.println();

            updateStatistics(faces);

            System.out.print("Rul en terning? ('ja/nej') ");
            answer = scanner.nextLine();

            //Alle counters
            sumDice += (faces[0] + faces[1]);

            if (faces[0] + faces[1] > highestDice)
                highestDice = faces[0] + faces[1];

            if (faces[0] == faces[1]) {
                sameDice++;
            }

        }

        printStatistics();
        scanner.close();
    }

    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    private static void updateStatistics(int[] faces) {
        rollCount++;

    }


    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Antal rul:", rollCount);
        System.out.printf("%17s %4d\n", "Total sum:", sumDice);
        System.out.printf("%17s %4d\n", "Ens dice", sameDice);
        System.out.printf("%17s %4d\n", "Højeste slag", highestDice);
    }

    public static int[] rollDice() {
        int[] slag = new int[2];
        int terning1 = rollDie();
        int terning2 = rollDie();

//assign slagene til array elementerne
        slag[0] = terning1;
        slag[1] = terning2;


        return slag;
    }
}

