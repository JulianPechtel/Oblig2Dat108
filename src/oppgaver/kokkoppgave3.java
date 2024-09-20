package oppgaver;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

class kokkoppgave3 extends Thread {
    private BlockingQueue<Integer> brett;
    private String navn;
    private static int hamburgerTeller = 1;

    public kokkoppgave3(BlockingQueue<Integer> brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((int) (Math.random() * 4000) + 2000);  // 2-6 sek å lage hamburger
                int hamburger = lagHamburger();
                brett.put(hamburger);  // Legger på brettet, venter hvis fullt
                System.out.println(navn + " (kokk) legger på hamburger ◖" + hamburger + "◗. Brett: " + brett);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized int lagHamburger() {
        return hamburgerTeller++;
    }
}
