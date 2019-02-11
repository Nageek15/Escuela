package src;
import static gameutil.text.Console.sConsole;
public class Gato extends Animal {
	private boolean enConstructor;
	public Gato(String nombre) {
		super("Gato", nombre,"Miau");
	}
	public Gato(String nombre,String sonido) {
		super("Gato",nombre,sonido);
		enConstructor=true;
		if (this.getClass().getGenericSuperclass()==Gato.class) {
			enConstructor=false;
			return;
		}
		ajustarSonido("Miau");
		sConsole.println("ERROR: Llamando clase no tiene permisos para usar este funci�n. Sonido ajustado al defecto.");
		enConstructor=false;
	}
	public void estarContento() {
		sConsole.println("ronronea");
		hacerSonido();
		verL�ser();
	}
	public void verL�ser() {
		sConsole.println("*gato salta*");
	}
	/**
	 * Devuelve si esta clase est� construyendo
	 * @return
	 */
	protected boolean tomarEnConstructor() {
		return enConstructor;
	}
}
