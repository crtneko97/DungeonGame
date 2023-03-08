package com.crtneko97.demo;

import static com.crtneko97.demo.Colors.*;

public class GameText  {
    public static void fighting(){
        System.out.println(RED_BACKGROUND+"\tBATTLE-MODE\t"+RESET);
    }
    public static void leavingCom(){
        System.out.println(PURPLE+"Leaving combat..."+RESET);
    }
    public static void noHp(){
        System.out.println(RED_BACKGROUND+"YOU ARE DEAD YOU CANNOT DO DUNGEONS"+RESET);
    }
    public static void youDied(){
        for(int i = 0; i < 5; i++){
            System.out.println(RED_BACKGROUND+"YOU DIED GAME OVER"+RESET);
        }
    }


    public static void toLowLevel(){
        System.out.println(RED_UNDERLINED+"You are to low level for this dungeon."+RESET);
    }
    public static void combatMenuText(){
        System.out.println(RED+"\nCombat Menu\n" +RESET+
                GREEN+"1: Fight\n" +RESET+
                BLUE+"2: Get Stats\n" + RESET+
                PURPLE+"3: Use Items\n" + RESET+
                YELLOW+"4: Flee"+RESET);
    }
    public static void startMenuText(){
        System.out.print("\n\n"+GREEN_BACKGROUND+"Start Menu."+RESET +
                GREEN_UNDERLINED+"\n1: Enter Dungeon" +RESET+
                RED_UNDERLINED+"\n2: See Player Stat & Progression"+RESET +
                YELLOW_UNDERLINED+"\n3: Level Up Stats"+RESET +
                PURPLE_UNDERLINED+"\n4: Save Score"+RESET +"\n"+
                RED_BRIGHT+"5: Help"+RESET + "\n"+
                RED_BOLD+"6: Quit"+RESET) ;
    }
    public static void levelUpError(){
        System.out.println(RED_BRIGHT+"U picked none of the options.. Keep in mind that using ur stat points on attributes will make you stronger."+RESET);
    }
}
