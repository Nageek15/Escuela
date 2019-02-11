package src;

import static gameutil.text.Console.sConsole;

public class AzulRuso extends Gato {

	public AzulRuso(String nombre) {
		super(nombre,"Hisss");
	}
	public void estarContento() {
		sConsole.println("ronronea");
		verLáser();
	}
	
}
