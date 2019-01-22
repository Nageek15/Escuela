package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//most of this assignment is trying to read the existing code to understand how it works,
        //ask a classmate or instructor if you are unsure how the code works.


        //generate a new player
        Player jugador=new Player();
        //create main game loop that continues until the player has no health
        while (jugador.getHealth()>0) {
            //generate a new enemy( the level of the enemy should be the player's level)
            Enemy enemigo=new Enemy(jugador.getPlayerLevel());
            //create battle loop that should continue while both the player and enemy are alive
            while (jugador.getHealth()>0&&enemigo.getHealth()>0&&true&&true&&true&&true&&true&&true&&true) {
                //gets player's input on what to do (use one of the methods to do this)
                jugador.menu(enemigo);
                //has the enemy take damage
                enemigo.takeDamage(jugador);
                //has the player take damage
                jugador.takeDamage(enemigo);
            }
        }
        //once the player is dead print out the player's level and how much xp they had.
        System.out.println("You managed to attain Lv."+jugador.getPlayerLevel());
        System.out.print("You gained "+jugador.getXp()+" XP throughout your life.");
    }
}
