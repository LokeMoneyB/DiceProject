package opgave02;

import java.util.Scanner;

public class Craps {
    private static int point = 0;

    public static void main(String[] args) {

        System.out.println("Velkommen til Craps!");
        printRules();
        System.out.println();

        playCraps();

        System.out.println();
        System.out.println("På gensyn ;-)");

    }

    public static void playCraps() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul nu! eller afslut tidligt ('ja/nej') ");
        String answer = scanner.nextLine();

        while (!answer.equals("nej")) {
            int terning1 = (int) (Math.random() * 6 + 1);
            int terning2 = (int) (Math.random() * 6 + 1);

// Mulige slag og outcomes
            int slag = (terning1 + terning2);

            if (point == 0) { // Initial roll
                if (slag == 7 || slag == 11) {
                    System.out.println(" Du rullede " + slag + ", derfor har du vundet!");
                    System.out.println("Tak for at spille!");
                    break;
                } else if (slag == 2 || slag == 3 || slag == 12) {
                    System.out.println("Du rullede " + slag + ", derfor har du desværre tabt!");
                    System.out.println("Tak for at spille!");
                    break;
                } else {
                    // Set point and continue the game
                    point = slag;
                    System.out.println("Du rullede " + slag + " og det er nu dit point.");
                    System.out.println("Prøv at matche dine point for at vinde, men undgå at rulle 7.");
                    rollforPoint(point);
                }
            }
        }
        scanner.close();
    }

    public static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for Craps!");
        System.out.println("Spilleren ruller en terning, første hedder Come out Roll");
        System.out.println("Hvis dit første kast er 11 eller 7, så har du vundet med det samme!");
        System.out.println("Er dit første kast derimod 2, 3 eller 12 så taber du med det samme! ");
        System.out.println("4, 5, 6, 8, 9 eller 10, går det til dine ‘point’");
        System.out.println("Du bliver ved med at kaste, indtil du enten kaster dine ‘point’ igen eller kaster 7");
        System.out.println("Kaster du 7, har du tabt. Kaster du dine point igen, vinder du!");
        System.out.println("=====================================================");
    }

    public static boolean rollforPoint(int point) {

        //Boolean til at loop slag igen
        boolean match;

        //Loopet til slagene
        while (true) {
            int nytrul1 = (int) (Math.random() * 6 + 1);
            int nytrul2 = (int) (Math.random() * 6 + 1);
            int slag = nytrul1 + nytrul2;
            System.out.println("Dit næste rul blev " + slag);

            if (slag == point) {
                System.out.println("Du har matchet dine point og vundet!");
                match = true;
                break;
            } else if (slag == 7) {
                System.out.println("Øv, du tabte!");
                match = false;
                break;
            } else {
                System.out.println("Hverken match eller 7, ruller igen!");
            }
        }
        return match;
    }
}