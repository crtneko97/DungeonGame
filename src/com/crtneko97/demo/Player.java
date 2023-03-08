package com.crtneko97.demo;

import static com.crtneko97.demo.Colors.*;

import java.util.ArrayList;
import java.util.Random;

public class Player implements ICombat {

    Random random = new Random();

    public Player(String playerName,int strength,int intelligence,int agility,int maxHealth,int level,int baseDamage,int currency){
        this.playerName = playerName;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.maxHealth = maxHealth;
        this.level = level;
        this.baseDamage = baseDamage;
        this.currency = currency;
    }

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
        int tryingToDodge = random.nextInt(agility , 15-agility);
        boolean dodged;
        if(tryingToDodge == agility){
            dodged = true;
        }else{
            dodged = false;
        }
        return dodged;
    }

    boolean fled;
    @Override
    public boolean flee() {
        int tryingToFlee = random.nextInt(intelligence,15-intelligence);
        int fleD = random.nextInt(intelligence,15-intelligence);
        if(tryingToFlee == fleD){
            fled = true;
        }else{
            fled = false;
        }
        return fled;
    }

    @Override
    public boolean crit() {
        int playerCrit = random.nextInt(intelligence,5);
        boolean twoTimeDmg;
        if(playerCrit == intelligence){
            twoTimeDmg = true;
        }else{
            twoTimeDmg = false;
        }
        return twoTimeDmg;
    }
    public void getPlayerStats() {
        System.out.println(getPlayerName() + " Stats Menu\n" +
                YELLOW_BRIGHT+"\t\tStats Points: " +RESET+ getStatsPoints()+
                YELLOW+"\tCurrency: " + RESET+getCurrency() +
                YELLOW_BOLD+"\tLevel: " + RESET+getLevel() + "\n" +
                RED_BRIGHT+"\tHealth: " + RESET+getHealth() + "\n" +
                RED+"\tStrength: " + RESET+getStrength() + "\n" +
                GREEN+"\tAgility: " + RESET+getAgility() + "\n" +
                BLUE+"\tIntelligence: " + RESET+getIntelligence()+"\n" +
                "\tBaseDamage: " + RESET+getBaseDamage());

        System.out.println(RED_BRIGHT+"\n\nDungeon Counter" +RESET+BLUE+
                "\n\t Level1: " +RESET+dungeon.get(0)+BLUE+
                "\n\t Level2: " +RESET+dungeon.get(1)+BLUE+
                "\n\t Level3: " +RESET+dungeon.get(2)+BLUE+
                "\n\t Level4: " +RESET+dungeon.get(3)+BLUE+
                "\n\t Level5: " +RESET+dungeon.get(4));

    }


    private String playerName;
    private int currency;
    private int statsPoints;
    private int strength;
    private int intelligence;
    private int agility;
    private int health;
    private int maxHealth;
    private int experience;
    private int level;
    private int baseDamage;
    private int toLevelUP;

    public int getToLevelUP() {
        return toLevelUP;
    }

    public void setToLevelUP(int toLevelUP) {
        this.toLevelUP += toLevelUP;
    }


    public Player(int level, int experience, int toLevelUP){
        this.level = level;
        this.experience = experience;
        this.toLevelUP = toLevelUP;
    }


    public Player(String playerName,int strength,int baseDamage, int intelligence, int agility, int health,int maxHealth, int statsPoints, int currency) {
        this.playerName = playerName;
        this.strength = strength;
        this.baseDamage = baseDamage;
        this.intelligence = intelligence;
        this.agility = agility;
        this.health = health;
        this.maxHealth = maxHealth;
        this.statsPoints = statsPoints;
        this.currency = currency;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public void setMaxHealth(int maxHealth){
        this.maxHealth += maxHealth;
    }
    public int getCurrency(){
        return currency;
    }
    public void setCurrency(int currency){
        this.currency += currency;
    }
    public int getStatsPoints() {
        return statsPoints;
    }

    public void setStatsPoints(int statsPoints) {
        this.statsPoints += statsPoints;
    }

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength += strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence += intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility += agility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health += health;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience += experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level += level;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage += strength+baseDamage;
    }




    public ArrayList<Integer> dungeon = new ArrayList<Integer>();


}
