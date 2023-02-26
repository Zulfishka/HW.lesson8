package kg.geecks.game.players;

import kg.geecks.game.general.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coefficient = RPG_Game.random.nextInt(9) + 2;
        boss.setHealth(boss.getHealth() - coefficient * this.getDamage());
        System.out.println("Warrior hits critically: " + coefficient * this.getDamage());
    }
}
