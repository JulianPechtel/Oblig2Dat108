package oppgaver;

public class oppgave2 {

	public static void main(String[] args) {
		final String[] kokker = {"Anne", "Erik", "Knut"};
		final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4; // Kapasiteten til brettet

        //Oppretter brettet som kokker og servitører deler
        HamburgerBrett brett = new HamburgerBrett(KAPASITET);
        
        //Start kokkene
        for (String navn: kokker) {
        	new Kokk(brett, navn).start();
        }
        
        //Start servitørene
        for(String navn : servitorer) {
        	new Servitor(brett, navn).start();
        }
        
	}

}