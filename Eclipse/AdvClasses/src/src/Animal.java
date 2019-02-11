package src;
import static gameutil.text.Console.sConsole;
public class Animal {
	private String especie;
	private String nombre;
	private String sonido;
	public Animal(String especie, String nombre) {
		this.especie=especie;
		this.nombre=nombre;
		sonido="Grrr";
	}
	public Animal(String especie, String nombre,String sonido) {
		this.especie=especie;
		this.nombre=nombre;
		this.sonido=sonido;
	}
	public void hacerSonido() {
		sConsole.println(sonido);
	}
	public void imprimirNombre() {
		sConsole.println("[Me llamo"+nombre+"] **Traducido de la lengua de "+especie+"**");
	}
	public void ajustarSonido(String sonido) {
		
		if ((this.getClass().getGenericSuperclass()==Gato.class||this.getClass()==Gato.class)&&((Gato) this).tomarEnConstructor()) {
			Gato g=(Gato) this;
			this.sonido=sonido;
		} else {
			sConsole.println("ERROR: Llamando clase no tiene permisos para usar este función.");
		}
	}
}
