package oppgaver;

public class Kokk extends Thread {

	private final HamburgerBrett brett;
	private final String navn;
	
	
	public Kokk(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}
	
	@Override
	public void run() {
		try {
			while(true) { //Kokken jobber kontinuerlig
				Thread.sleep((int) (Math.random() * 4000) + 2000); // 2 til 6 sekunder
				
				//Oppretter en ny hamburger
				Hamburger hamburger = new Hamburger();
				//Legger hamburger på brettet, venter om brettet er fullt
				brett.LeggPåHamburger(hamburger, navn);
				
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace(); //Unntak om tråden blir brutt
		}
	}
	

}
