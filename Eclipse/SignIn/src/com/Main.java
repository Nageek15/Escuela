package com;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	//declare class variables
	static Scanner s;
	static ArrayList<Usuario> usuarios;
	public static void main(String[] rainbowArgs) {
		//initialize variables
		s=new Scanner(System.in);
		usuarios=new ArrayList<Usuario>();
		//get user input until they have logged in
		boolean enBucle=true;
		while (enBucle) {
			enBucle=bucle();
		}
	}
	
	
	
	
	/**The function to run while in the loop
	 * 
	 * @return weather or not to continue running the loop
	 */
	
	public static boolean bucle() {
		System.out.println("Would you like to (login) or (bring a new account into existence)?");
		//get what the user wants to do
		String elección=s.nextLine();
		if (elección.equals("login")) {
			//get username and password of user
			System.out.println("Username:");
			String usuario=s.nextLine();
			System.out.println("Password:");
			String contraseña=s.nextLine();
			//check through all users to see if credentials match those of a user
			for (Usuario u:usuarios) {
				if(u.autenticar(usuario, contraseña)) {
					System.out.println("Welcome "+usuario);
					//user logged in so stop looping
					return false;
				}
			}
			System .out.println("Wrong username or password");
			//keep looping because user did not successfully log in
			return true;
		} else if (elección.equals("bring a new account into existence")) {
			//get the username and password of the new user
			System.out.println("Username:");
			String usuario=s.nextLine();
			System.out.println("Password:");
			String contraseña=s.nextLine();
			//make sure the user doesn't already exist so that people can't just give new passwords to any username allowing them to access any account
			for (Usuario u:usuarios) {
				if (u.tomarNombre().equals(usuario)) {
					System.out.println("User with that name already exists");
					return true;
				}
			}
			//add the new user
			usuarios.add(new Usuario(usuario,contraseña));
		}
		//keep looping
		return true;
	}
}
