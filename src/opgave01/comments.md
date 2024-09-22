Pas på med copy/paste, RollTwoDice skal være 

    package opgave01;

ikke 

    package examples;

---
Denne linje siger IntelliJ har "no usages"

    private static int[] possibleDie = {1, 2, 3, 4, 5, 6};

Så den bruges ikke nogen steder. Det er ikke unormalt at man får skrevet noget kode man aligevel ikke har brug for, 
men sørg for at rydde op. 

---
Disse linjer 

```
            System.out.print("Du rullede: ");
            System.out.print(faces[0] + " ");
            System.out.print(faces[1]);
            System.out.println();

```
kan I reducerer til 

    System.out.println("Du rullede: " + faces[0] + " " + faces[1]);

---
Disse Linjer

```
            sumDice += (faces[0] + faces[1]);
            if (faces[0] + faces[1] > highestDice)
                highestDice = faces[0] + faces[1];
            if (faces[0] == faces[1]) {
                sameDice++;
            }
```

Skal flyttes ned i `updateStatistics` metoden, så kan I også bruge parameter variablen til nogen.

---
I `rollDice()` metoden har I

    int terning1 = rollDie();
    int terning2 = rollDie();
    //assign slagene til array elementerne
    slag[0] = terning1;
    slag[1] = terning2;

der er ingen grund til at introducere variablerne terning1 of terning2.

    slag[0] = rollDie();
    slag[1] = rollDie();

gør det samme.

---
Metodenavne skal starte med lille forbogstav, så `playTwoDice()` i stedet for `PlayTwoDice()`.

---

