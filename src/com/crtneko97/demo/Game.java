package com.crtneko97.demo;

import static com.crtneko97.demo.Colors.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Game extends Player {
    public static void clearSC(){
        for(int i = 0; i < 20; i++){
            System.out.println("\n");
        }
    }

    Scanner scanner = new Scanner(System.in);


    public Game(String playerName) {
        super(playerName);
    }

    public void userInput() {
        boolean isPLaying = true;
        do {
            startMenu();
            inputStream();
            switch (scanner.next()) {
                case "1":
                    clearSC();
                    enterDungeon();
                    break;

                case "2":
                    clearSC();
                    getPlayerStats();
                    backToMenu();
                    break;
                case "3":
                    clearSC();
                    levelUpStats();
                    backToMenu();
                    break;
                case "6":
                    System.out.println("Quiting...");
                    isPLaying = false;
                    break;
            }
        } while (isPLaying == true);
    }

    public void backToMenu() {
        boolean equalKey = true;
        do {
            System.out.println("\n" + WHITE_UNDERLINED + "To go back type b (LOWERCASE) > Then Enter."
                    + RESET);
            inputStream();
            switch (scanner.next()) {
                case "b":
                    equalKey = false;
                    break;

                default:
                    System.out.println("Enter b (lowecase) to go back..");
            }

        } while (equalKey == true);
    }

    public void startMenu() {
        GameText.startMenuText();
    }

    public void inputStream() {
        if (getExperience() >= getToLevelUP()) {
            setBaseDamage(2);
            setLevel(1);
            setStatsPoints(1);
            setExperience(-getExperience());
            setToLevelUP(getToLevelUP()+100);
            System.out.println(GREEN_BRIGHT + "DING DING DING DING!" + RESET + "\nYou get +1 Stat Point! Head back to the main menu and +1 any of your stats!:)");
        }
        if (getStatsPoints() >= 1) {

            System.out.print("\n\nName: " + getPlayerName() + "\tLVL: " + GREEN + getLevel() + RESET + "\tCurrency: " + YELLOW + getCurrency() + "c" + RESET + "\nCurrent XP: " + PURPLE + getExperience() + " > "+getToLevelUP() + RESET +
                    "\nHP: " + RED + getHealth() + " | " + getMaxHealth() + RESET + BLUE_BRIGHT + "\nYou have +" + getStatsPoints() + " Use it on a stat u wish to become stronger in!" + RESET
                    + "\nInput: ");
        } else {
            System.out.print("\n\nName: " + getPlayerName() + "\tLVL: " + GREEN + getLevel() + RESET + "\tCurrency: " + YELLOW + getCurrency() + "c" + RESET + "\tCurrent XP: " + PURPLE + getExperience() + " > "+getToLevelUP() + RESET + "\nHP: " + RED + getHealth() + " | " + getMaxHealth() + RESET +
                    "\nInput: ");
        }
    }


    public Player createHero() {

        boolean validName;

        do {
            validName = false;
            System.out.print("Input Name: ");
            String inputName = scanner.next();
            if (inputName.length() >= 5 && inputName.length() <= 10) {
                setPlayerName(inputName);
                System.out.println(getPlayerName() + " Was Created.");
                validName = true;
            } else {
                System.out.println(RED_BACKGROUND + "invalid name ".toUpperCase() + RESET + inputName +
                        RED + "\nplease enter a name between 5 > 10 letters.".toUpperCase() + RESET);
                validName = false;
            }

        } while (validName == false);

        return new Player(getPlayerName());

    }

    public Player setLevelExp() {
        setLevel(1);
        setExperience(0);
        setToLevelUP(100);

        return new Player(getLevel(), getExperience(), getToLevelUP());
    }


    //Just a test
    public Player setStats() {
        setPlayerName(getPlayerName());
        setMaxHealth(100);
        setHealth(getMaxHealth());
        setAgility(1);
        setStrength(1);
        setBaseDamage(1);
        setIntelligence(1);
        setStatsPoints(1);
        setCurrency(1);

        dungeon.add(0,0);
        dungeon.add(1,0);
        dungeon.add(2,0);
        dungeon.add(3,0);
        dungeon.add(4,0);

        return new Player(getPlayerName(),getMaxHealth(), getHealth(), getAgility(), getStrength(), getBaseDamage(), getIntelligence(), getStatsPoints(), getCurrency());
    }

    //Just a test

    public Player levelUpStats() {
        boolean levelUp;
        if (getStatsPoints() >= 1) {
            System.out.println(getPlayerName() + " Level Up Stats\n" +
                    "\tStats Points: " + getStatsPoints() + "\n" +
                    "1: Health: (+10) \tCurrent Hp: " + getMaxHealth() + "\n" +
                    "2: Strength: (+1) \tCurrent Str: " + getStrength() + "\n" +
                    "3: Agility: (+1) \tCurrent Agi: " + getAgility() + "\n" +
                    "4: Intelligence: (+1) \tCurrent int: " + getIntelligence());
            switch (scanner.next()) {
                case "1":
                    if(getMaxHealth() < 150) {
                        setMaxHealth(10);
                        setHealth(getMaxHealth() - getHealth());
                        System.out.println(RED_UNDERLINED + "You +10 Health with that you restored your health to max also! > Current HP: " + getMaxHealth() + RESET);
                        setStatsPoints(-1);
                    }else{
                        System.out.println(RED_BOLD+"You have reached the highest amount of Health!"+RESET);
                    }
                    break;
                case "2":
                    if(getStrength() < 5) {
                        setStrength(1);
                        System.out.println(YELLOW_UNDERLINED + "You +1 Strength > Current Strength: " + getStrength() + RESET);
                        setStatsPoints(-1);
                    }else{
                        System.out.println(RED_BOLD+"You have reached the highest amount of Strength!"+RESET);

                    }
                    break;
                case "3":
                    if(getAgility() < 5) {
                        setAgility(1);
                        System.out.println(GREEN_UNDERLINED + "You +1 Agility > Current Agility: " + getAgility() + RESET);
                        setStatsPoints(-1);
                    }else{
                        System.out.println(RED_BOLD+"You have reached the highest amount of Agility!"+RESET);
                    }
                    break;
                case "4":
                    if(getIntelligence() < 5) {
                        setIntelligence(1);
                        System.out.println(BLUE_UNDERLINED + "You +1 Intelligence > Current Intelligence: " + getIntelligence() + RESET);
                        setStatsPoints(-1);
                    }else{
                        System.out.println(RED_BOLD+"You have reached the highest amount of Intelligence!"+RESET);
                    }
                    break;

                default:
                    GameText.levelUpError();

            }
        } else {
            System.out.println(RED + "You have no Stat Points to spend. Level up to earn more." + RESET);
        }
        return new Player(getPlayerName(),getMaxHealth(), getHealth(), getStrength(),getBaseDamage(), getAgility(), getIntelligence(), getStatsPoints(), getCurrency());
    }


    Monster monster;

    public void enterDungeon() {
        clearSC();
        boolean inDungeon = true;
        do {
            dungMenu();
            inputStream();

            switch (scanner.next()) {
                case "1":
                    System.out.println("Entering Dungeon Level (1)");
                    Monster rat = new Monster("Rat", 20, 1, 1, 1, 1, 1, 6, 2);
                    combatMenu(rat);
                    dungeon.set(0,dungeon.get(0)+1);
                    break;


                case "2":
                    if (getLevel() >= 2) {
                        //fix the level
                        Monster goblin = new Monster("Goblin", 30, 2, 1, 2, 2, 2, 10, 8);
                        combatMenu(goblin);
                        dungeon.set(1,dungeon.get(1)+1);
                    } else {
                        GameText.toLowLevel();
                    }
                    break;
                case "3":
                    if (getLevel() >= 3) {
                        //fix the level
                        Monster rogue = new Monster("Stefan(Rogue from the village)", 40, 4, 2, 3, 3, 2, 20, 25);
                        combatMenu(rogue);
                        dungeon.set(2,dungeon.get(2)+1);
                    } else {
                        GameText.toLowLevel();

                    }
                    break;
                case "4":
                    if (getLevel() >= 4) {
                        //fix the level
                        Monster corruptPriest = new Monster("Holy Priest Chad", 60, 6, 1, 4, 5, 5, 40, 50);
                        combatMenu(corruptPriest);
                        dungeon.set(3,dungeon.get(3)+1);
                    } else {
                        GameText.toLowLevel();
                    }
                    break;
                case "5":
                    if (getLevel() >= 5) {
                        Monster hippie = new Monster("Hippie Mike", 100, 10, 5, 5, 10, 1, 100, 100);
                        combatMenu(hippie);
                        dungeon.set(4,dungeon.get(4)+1);
                        //fix the level
                    } else {
                        GameText.toLowLevel();
                    }
                    break;

                case "6":
                    inDungeon = false;
                    break;
                default:
                    System.out.println("Input error.");
            }
        } while (inDungeon);


    }

    public void combatMenu(Monster monster) {
        //Change to if statement? While is hard.
        boolean fledFromFight = false;
        clearSC();
        if (getHealth() > 0) {
            do {
                monster.showMonster();
                GameText.combatMenuText();
                inputStream();

                switch (scanner.next()) {
                    case "1":



                        GameText.fighting();


                        if (!monster.dodge()) {


                            System.out.println("Swinging your weapon..");
                            if (crit() == true) {

                                System.out.println(YELLOW_BRIGHT + "You landed a critical strike +" + fight()*2 + RESET);
                                monster.setHealth(-fight()*2);
                            } else {
                                System.out.println(GREEN_BRIGHT + "You hit the target for +" + fight() + RESET);
                                monster.setHealth(-fight());
                            }



                        } else {
                            System.out.println("You missed your attack!");
                        }



                        if (!dodge()) {


                            System.out.println("Monster attacks");
                            if (monster.crit() == true) {
                                System.out.println(YELLOW_BACKGROUND + "You take a critical strike " + monster.fight()*2 + " damage! " + RESET);
                                setHealth(-monster.fight()*2);
                            } else {
                                System.out.println(RED_BRIGHT + "\tYou take " + monster.fight() + " damage!" + RESET + "\n\n");
                                setHealth(-monster.fight());

                            }



                        } else {
                            System.out.println(GREEN + "You dodged " + RESET + monster.getName() + GREEN + " Attack" + RESET);
                        }



                        break;




                    case "2":
                        getPlayerStats();
                        break;

                    case "3":
                        System.out.println("Can't use items yet.");
                        break;

                    case "4":
                        if (flee() == true) {
                            System.out.println(GREEN + "you fled from " + RESET + monster.getName());
                            fledFromFight = true;
                        } else {
                            System.out.println(RED_BACKGROUND + "You failed fleeing from " + RESET + monster.getName());
                            System.out.println(RED_BRIGHT + "\tYou take " + monster.getBaseDamage() + " damage!" + RESET + "\n\n");
                            setHealth(-monster.fight());
                        }
                        break;
                    default:
                        System.out.println("Please use one of the following options.");
                }
            } while (monster.getHealth() > 0 && getHealth() > 0 && !fledFromFight);


            if (monster.getHealth() <= 0) {
                int xp = monster.getExpGiven();
                int cr = monster.getCurrencyDrop();
                System.out.println(GREEN + "You have slayed " + RESET + monster.getName() + "\n" +
                        YELLOW + "Your reward is +" + xp + "XP & +" + cr + "c" + RESET);
                setExperience(xp);
                setCurrency(cr);
            } else {
                GameText.leavingCom();
            }
            if (getHealth() <= 0) {
                GameText.youDied();
            }
        } else {
            GameText.noHp();
        }

    }
    public void dungMenu() {
        if (getLevel() >= 1) {
            System.out.println(GREEN + "1: LEVEL1" + RESET);
        }
        if (getLevel() >= 2) {System.out.println(GREEN + "2: LEVEL2" + RESET);} else {System.out.println(RED + "2: LEVEL2" + RESET);}
        if (getLevel() >= 3) {System.out.println(GREEN + "3: LEVEL3" + RESET);} else {System.out.println(RED + "3: LEVEL3" + RESET);}
        if (getLevel() >= 4) {System.out.println(GREEN + "4: LEVEL4" + RESET);} else {System.out.println(RED + "4: LEVEL4" + RESET);}
        if (getLevel() >= 5) {System.out.println(GREEN + "5: LEVEL2" + RESET);} else {System.out.println(RED + "5: LEVEL5" + RESET);}
        System.out.println(RED_BOLD+"6: Leave Dungeon Menu"+ RESET);


    }
}


    //Dung MENU!

