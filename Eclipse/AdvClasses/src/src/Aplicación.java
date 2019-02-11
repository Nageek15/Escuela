package src;

import static gameutil.text.Console.sConsole;

public class Aplicación {
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
		garfield.verLáser();
		r.imprimirNombre();
		r.hacerSonido();
		r.estarContento();
		r.verLáser();
		r.ajustarSonido("Miau");
		p.imprimirNombre();
		p.jugarALaPelota();
		p.hacerSonido();
		sConsole.println(String.valueOf(p.obtenerSecciónParcialDelCola()));
		spcP.imprimirNombre();
		spcP.ajustarSonido("Equivocada");
		spcP.hacerSonido();
		spcP.jugarALaPelota();
		sConsole.println(String.valueOf(spcP.obtenerSecciónParcialDelCola()));
		aN.imprimirNombre();
		aN.hacerSonido();
		aN.recostarseEnRegazo();
		aN.estarContento();
		aN.verLáser();
	}

}
