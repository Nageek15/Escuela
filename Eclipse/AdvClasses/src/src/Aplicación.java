package src;

import static gameutil.text.Console.sConsole;

public class Aplicaci�n {
	public static void main(String[] args) {
		Gato g=new Gato("Mow","");
		AzulRuso r=new AzulRuso("Lloro");
		Perro p=new Perro("Tristeza",false);
		Perro spcP=new Perro("Burro", true);
		AtigradoNaranja aN=new AtigradoNaranja("Emilla");
		Garfield garfield=new Garfield();
		garfield.imprimirNombre();
		garfield.ajustarSonido("Algo diferente");
		garfield.hacerSonido();
		garfield.estarContento();
		garfield.recostarseEnRegazo();
		garfield.verL�ser();
		r.imprimirNombre();
		r.hacerSonido();
		r.estarContento();
		r.verL�ser();
		r.ajustarSonido("Miau");
		p.imprimirNombre();
		p.jugarALaPelota();
		p.hacerSonido();
		sConsole.println(String.valueOf(p.obtenerSecci�nParcialDelCola()));
		spcP.imprimirNombre();
		spcP.ajustarSonido("Equivocada");
		spcP.hacerSonido();
		spcP.jugarALaPelota();
		sConsole.println(String.valueOf(spcP.obtenerSecci�nParcialDelCola()));
		aN.imprimirNombre();
		aN.hacerSonido();
		aN.recostarseEnRegazo();
		aN.estarContento();
		aN.verL�ser();
	}

}
