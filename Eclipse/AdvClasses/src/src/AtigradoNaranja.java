package src;
import static gameutil.text.Console.sConsole;
public class AtigradoNaranja extends Gato {

	public AtigradoNaranja(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	public void estarContento() {
		recostarseEnRegazo();
		sConsole.println("*hace un ciesta");
	}
	public void recostarseEnRegazo() {
		sConsole.println("*accuruca en el regazo de su dueño*");
	}
}
