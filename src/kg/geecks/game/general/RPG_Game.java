package kg.geecks.game.general;

import kg.geecks.game.players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random ();
    private static int roundNumber;
    public static void startGame () {
        Boss boss = new Boss (1000, 50, "Rashan");
        Warrior warrior = new Warrior(280, 10, "Axe");
        Medic doc = new Medic(250,5,15, "Duzzle");
        Magic magic = new Magic(270,20, "Hendolf");
        Berserk berserk = new Berserk(290, 10, "Trol");
        Medic assistant = new Medic(300,5,5, "Mini");
        Hero[] heroes = { warrior, doc, magic, berserk, assistant };

        printStatistics(boss,heroes);
        playRound(boss, heroes);
    }

    private static void playRound (Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes [i].getAbility() != boss.getDefence() && heroes[i].getHealth()>0) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        };
        printStatistics(boss,heroes);

        while (!isGameFinished(boss,heroes)){
            playRound(boss,heroes);
        }
    }
    private static  void  printStatistics (Boss boss, Hero [] heroes) {
        System.out.printf("ROUND " + roundNumber + "-------------" );
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }
    private static boolean isGameFinished (Boss boss, Hero [] heroes) {
        if (boss.getHealth()<=0) {
            System.out.printf("Heroes won!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead){
            System.out.printf("Boss won!");
        }
        return allHeroesDead;
    }
}
