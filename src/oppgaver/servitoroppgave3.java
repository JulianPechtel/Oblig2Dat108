package oppgaver;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

class servitoroppgave3 extends Thread {
    private BlockingQueue<Integer> brett;
    private String navn;

    public servitoroppgave3(BlockingQueue<Integer> brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((int) (Math.random() * 4000) + 2000);  // 2-6 sek mellom bestillinger
                int hamburger = brett.take();  // Tar av brettet, venter hvis tomt
                System.out.println(navn + " (servitør) tar av hamburger ◖" + hamburger + "◗. Brett: " + brett);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

