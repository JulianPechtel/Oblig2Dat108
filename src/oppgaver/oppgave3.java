package oppgaver;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class oppgave3 {

    public static void main(String[] args) {
        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;

        // Skriver ut en overskrift som viser initial informasjon
        skrivUtHeader(kokker, servitorer, KAPASITET);

        // Opprett et BlockingQueue (hamburgerbrett) med kapasitet
        BlockingQueue<Integer> brett = new ArrayBlockingQueue<>(KAPASITET);

        // Start kokk-tråder
        for (String navn : kokker) {
            new kokkoppgave3(brett, navn).start();
        }

        // Start servitør-tråder
        for (String navn : servitorer) {
            new servitoroppgave3(brett, navn).start();
        }
    }

    // Skriv ut headeren med informasjon om kokker, servitører og brettkapasitet
    private static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {
        System.out.println("I denne simuleringen har vi");
        System.out.println(kokker.length + " kokker " + java.util.Arrays.toString(kokker));
        System.out.println(servitorer.length + " servitører " + java.util.Arrays.toString(servitorer));
        System.out.println("Kapasiteten til brettet er " + kapasitet + " hamburgere.");
        System.out.println("Vi starter ...");
    }
}

