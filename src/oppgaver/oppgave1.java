package oppgaver;

import javax.swing.JOptionPane;

public class oppgave1 {

    private static volatile boolean avslutt = false; // Flagg for å kontrollere programmet
    private static String melding = "Hallo verden!"; // Standardmelding

    public static void main(String[] args) {
        // Tråd for å skrive ut meldinger hvert 3. sekund
        Thread utskriftTråd = new Thread(() -> {
            while (!avslutt) {
                System.out.println(melding);
                try {
                    Thread.sleep(3000); // Pause på 3 sekunder
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Tråd for å hente brukerinput via JOptionPane
        Thread inputTråd = new Thread(() -> {
            while (!avslutt) {
                String input = JOptionPane.showInputDialog("Skriv inn en melding (skriv 'quit' for å avslutte):");
                if (input != null) {
                    if (input.trim().equalsIgnoreCase("quit")) {
                        avslutt = true; // Setter flagg for å avslutte programmet
                    } else if (!input.trim().isEmpty()) {
                        melding = input; // Oppdaterer melding til den nye teksten
                    }
                }
            }
        });

        // Starter trådene
        utskriftTråd.start();
        inputTråd.start();
    }
}
