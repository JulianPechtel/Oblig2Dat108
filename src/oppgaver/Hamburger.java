package oppgaver;

public class Hamburger {

	private static int count = 0;
	private final int id;
	
	public Hamburger() {
		this.id = ++count; //Setter unik ID for hver ny hamburger
	}
	
	@Override
	public String toString() {
		return "◖" + id + "◗"; //Vis hamburger-ID som et unikt nummer
	}

}
