package com.crtneko97.demo;

import static com.crtneko97.demo.Colors.*;

import java.util.Random;

public class Monster implements ICombat {

    Random random = new Random();

    @Override
    public int fight() {
        return calculateDamage();
    }

    @Override
    public int calculateDamage() {
        int damage = (strength + baseDamage);
        return damage;
    }

    @Override
    public boolean dodge() {
        int tryingToDodge = random.nextInt(agility + (agility+15));
        boolean dodged;
        if(tryingToDodge == agility){
            dodged = true;
        }
        else{
            dodged = false;
        }
        return dodged;
    }

    @Override
    public boolean flee() {
        return true;
    }

    @Override
    public boolean crit() {
        int monsterCrit = random.nextInt(intellect,10);
        boolean twoTimeDmg;
        if(monsterCrit == intellect){
            twoTimeDmg = true;
        }else{
            twoTimeDmg = false;
        }
        return twoTimeDmg;
    }

    public void showMonster(){
        System.out.println("\n\tTarget Monster: " + getName()+
                "\tHP: " + RED+getHealth()+RESET + "\tLvl: " +YELLOW+getLevel()+RESET);
    }

    public Monster(String name,int health, int strength, int agility, int level, int baseDamage,int intellect, int expGiven, int currencyDrop) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.level = level;
        this.baseDamage = baseDamage;
        this.intellect = intellect;
        this.expGiven = expGiven;
        this.currencyDrop = currencyDrop;
    }
    String name;

    int currencyDrop;
    int health;
    int strength;
    int agility;
    int level;

    int baseDamage;

    int expGiven;

    int intellect;


    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }
    public int getCurrencyDrop(){
        return random.nextInt(currencyDrop,currencyDrop*2);
    }
    public void setCurrencyDrop(int currencyDrop){
        this.currencyDrop = currencyDrop;
    }
    public int getExpGiven() {
        return random.nextInt(expGiven,expGiven*2);
    }

    public void setExpGiven(int expGiven) {

        this.expGiven = expGiven;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health += health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


}
