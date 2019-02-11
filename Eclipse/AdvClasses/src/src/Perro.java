package src;
import static gameutil.text.Console.sConsole;
public class Perro extends Animal {
	private boolean secciónParcialDelCola;
	public Perro(String nombre, boolean secciónParcialDelCola) {
		super("perro", nombre,"Guau");
		this.secciónParcialDelCola=secciónParcialDelCola;
	}
	public void jugarALaPelota() {
		sConsole.println("*Persigue la pelota cinco vezes y luego dejalo*");
	}
	public boolean obtenerSecciónParcialDelCola() {
		return secciónParcialDelCola;
	}
}
