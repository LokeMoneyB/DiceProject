Flyt

            int terning1 = (int) (Math.random() * 6 + 1);
            int terning2 = (int) (Math.random() * 6 + 1);

til en metode, som I kan genbruge.

---

Pas på med at bruge `break;` da det kan være svært at se hvad mab "bryder" ud af. 
Jeg vil hellere have en lokal variabel

    boolean continue = true;
    while (continue) {
        ...
    }

---
