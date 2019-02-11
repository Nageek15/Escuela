package src;
import static gameutil.text.Console.sConsole;
public class Garfield extends AtigradoNaranja {

	public Garfield() {
		super("Garfield");
	}
	public void hacerSonido() {
		sConsole.println("Mmmmm lasaña...");
	}
	public void verLáser() {
		estarContento();
	}
}
