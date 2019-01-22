package com.company;

import java.util.Random;

/**
 * Created by dbaker on 1/22/2019.
 */
public class Enemy {
    private int  health;
    private int defense;
    private int attack;
    private int enemeyLevel;
    Random rand;

    //constructor that will initialize the instance variables (properties)
    //the "this" key word refers to the object's variable instead of the function's input
    //in the case that they have the same name.
    public Enemy(int enemeyLevel){
        rand = new Random();
        this.enemeyLevel = enemeyLevel;
        health = 20 * this.enemeyLevel;
        defense = (rand.nextInt(10)+1) * this.enemeyLevel;
        attack = (rand.nextInt(10)+1) * this.enemeyLevel;
    }

    //getters (allow the programmers to see the values of the instance variables
    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    public int getEnemeyLevel() {
        return enemeyLevel;
    }

    //this is the function that allows the enemy to take damage, returns true if enemy is Alive
    //gives player XP if enemy died.
    public boolean takeDamage(Player player){
        int damage = (rand.nextInt(player.getAttack())+player.getAttack()) - defense;
        if (damage<1){
            damage = 1;
        }
        health = health -damage;
        System.out.println("you attacked the enemy and they took: " + damage + " damage!");
        if(!isAlive()){
            System.out.println("you killed the enemy!");
            player.gainXP();
            return false;
        }
        return true;
    }

    //returns true if the enemy health>0
    private boolean isAlive(){
        return (health>0);
    }

}
