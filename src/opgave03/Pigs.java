package opgave03;

import java.util.Scanner;

public class Pigs {
    private static int spiller1point = 0;
    private static int spiller2point = 0;
    private static int hvisTur = 0;
    private static int VinderScore = 100;
    private static int tempScore = 0;

    public static void main(String[] args) {
        System.out.println("Velkommen til Pigs!");
        System.out.println();

        printRules();
        playPigs();

        System.out.println();
        System.out.println("Tak for nu, vi ses!");
    }

    private static void playPigs() {


        Scanner scanner = new Scanner(System.in);
        while (spiller1point < VinderScore && spiller2point < VinderScore) {
            if (hvisTur == 0) {
                System.out.print("Spiller 1's tur nu! Rul terninger?('ja/nej') ");
                String answer = scanner.nextLine();

                while (!answer.equals("nej")) {
                    int[] faces = rolltheDice();
                    System.out.print("Du rullede: ");

                    System.out.print(faces[0] + " ");

                    System.out.print(faces[1]);

                    System.out.println();

                    tempScore += (faces[0] + faces[1]);

                    if (tempScore >= VinderScore) {
                        spiller1point = tempScore;
                        System.out.println("Din score er nu " + spiller1point);
                        checkVinder(spiller1point, spiller2point);
                        break;
                    }

                    if (faces[0] == 1 && faces[1] == 1) {
                        System.out.println("Åh nej, du tabte alle dine point!");
                        spiller1point = 0;
                        tempScore = 0;
                        hvisTur();
                        break;
                    }
                    checkVinder(spiller1point, spiller2point);
                    System.out.print("Vil du rulle videre eller add til dine point? nej for point!('ja/nej') ");
                    answer = scanner.nextLine();

                }
                spiller1point += tempScore;
                System.out.println("Din samlede sum fra alle slag var: " + spiller1point);
                tempScore = 0;
                if (spiller1point < VinderScore) {
                    hvisTur();
                }
            }


            if (hvisTur == 1) {
                System.out.print("Spiller 2's tur nu! Rul terninger?('ja/nej') ");
                String answer = scanner.nextLine();

                while (!answer.equals("nej")) {
                    int[] faces = rolltheDice();
                    System.out.print("Du rullede: ");

                    System.out.print(faces[0] + " ");

                    System.out.print(faces[1]);

                    System.out.println();

                    tempScore += (faces[0] + faces[1]);


                    if (tempScore >= VinderScore && spiller1point >= VinderScore) {
                        spiller1point = tempScore;
                        System.out.println("Din sum er nu " + spiller2point);
                        checkVinder(spiller1point, spiller2point);
                        break;
                    }

                    System.out.print("Vil du rulle videre eller add til dine point? nej for point!('ja/nej') ");
                    answer = scanner.nextLine();

                    if (faces[0] == 1 && faces[1] == 1) {
                        System.out.println("Åh nej, du tabte alle dine point!");
                        spiller2point = 0;
                        tempScore = 0;
                        hvisTur();
                        break;
                    }
                }
                spiller2point += tempScore;
                System.out.println("Din samlede sum af alle slag er: " + spiller2point);
                tempScore = 0;
                if (spiller2point < VinderScore) {
                    hvisTur();
                }
            }
        }
    }

    public static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for Pigs!");
        System.out.println();
        System.out.println("Første spiller kaster en terning, indtil han enten kaster 1, eller beslutter sig for at stoppe. ");
        System.out.println("Hvis han slår en 1’er, får han ingen point i denne runde.");
        System.out.println("Hvis han beslutter sig for at stoppe, inden har slår\n" +
                "en 1’er, lægges summen af alle hans kast i denne runde sammen med hans samlede antal point,\n" +
                "og turen går videre til næste spiller. ");
        System.out.println();
        System.out.println("Derefter skiftes spillerne til at kaste. Den første spiller, der\n" +
                "samlet når 100 point, har vundet.");
        System.out.println("=====================================================");
    }

    public static int[] rolltheDice() {
        int[] slag = new int[2];

//assign slagene til array elementerne
        slag[0] = (int) (Math.random() * 6 + 1);
        slag[1] = (int) (Math.random() * 6 + 1);

        return slag;
    }

    public static void hvisTur() {
        hvisTur++;
        hvisTur = hvisTur % 2;
    }

    public static void checkVinder(int check1, int check2) {

        int checker1 = check1;
        int checker2 = check2;

        if (checker1 >= VinderScore && spiller2point != VinderScore) {
            System.out.println("Spiller 1 har vundet ved at nå over 100 point!");
        } else if (checker2 >= VinderScore && spiller1point != VinderScore) {
            System.out.println("Spiller 2 har vundet ved at nå over 100 point!");
        }
    }
}
