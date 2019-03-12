package com;

public class Usuario {
	//declare class variables
	private String nombre;
	private String contraseña;
	public Usuario(String nombre, String contraseña) {
		//initialize class variables
		this.nombre=nombre;
		this.contraseña=contraseña;
	}
	/**
	 * 
	 * @param nombre username entered
	 * @param contraseña password entered
	 * @return weather the username and password match the name and password of this user
	 */
	public boolean autenticar(String nombre,String contraseña) {
		return this.contraseña.equals(contraseña)&&this.nombre.equals(nombre);
	}
	/**
	 * 
	 * @return the name of this user
	 */
	public String tomarNombre() {
		return nombre;
	}
}
