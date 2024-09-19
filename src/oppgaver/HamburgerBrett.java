package oppgaver;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {
	
	private final int kapasitet; //Maks antall hamburgere på brettet
	private final Queue<Hamburger> brett; //Køen som holder hamburgere
	
	public HamburgerBrett(int capacity) {
		this.kapasitet = capacity;	//Setter kapasiteten til brettet
		this.brett = new LinkedList<>(); //Oppretter en tom kø for hamburgere
	}
	
	public synchronized void LeggPåHamburger(Hamburger hamburger, String kokkNavn) throws InterruptedException {
		while (brett.size() == kapasitet) { //Om brett fullt, vent
			System.out.println(kokkNavn + " (kokk) klar med hamburger, men brett fullt. Venter");
			wait(); //Kokken venter til det er plass
		}
		brett.add(hamburger); //legger hamburgeren på brettet
		System.out.println(kokkNavn + " (kokk) legger på hamburger " + hamburger + ". Brett: " + brett);
		notifyAll(); //varsler servitører om at det er en hamburger tilgjengelig
	}
	
	public synchronized Hamburger taAvHamburger(String servitorNavn) throws InterruptedException {
		while (brett.isEmpty()) { //om brett er tomt, vent
			System.out.println(servitorNavn + " (servitor) ønsker å ta hamburger, men brett tomt. Venter");
			wait(); //servitører venter til det er tilgjengelig hamburger
		}
		Hamburger hamburger = brett.poll();
		System.out.println(servitorNavn + " (servitor) tar av hamburger " + hamburger + ". Brett: " + brett);
		notifyAll(); //varsler kokker om det er plass til hamburgere
		return hamburger;
	}

}
