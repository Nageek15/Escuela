package src;
import static gameutil.text.Console.sConsole;
public class Perro extends Animal {
	private boolean secci�nParcialDelCola;
	public Perro(String nombre, boolean secci�nParcialDelCola) {
		super("perro", nombre,"Guau");
		this.secci�nParcialDelCola=secci�nParcialDelCola;
	}
	public void jugarALaPelota() {
		sConsole.println("*Persigue la pelota cinco vezes y luego dejalo*");
	}
	public boolean obtenerSecci�nParcialDelCola() {
		return secci�nParcialDelCola;
	}
}
