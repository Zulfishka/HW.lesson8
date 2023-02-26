package kg.geecks.game.players;

import kg.geecks.game.general.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {

        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            Hero hero = heroes[i];
            int coefficient = RPG_Game.random.nextInt(2) + 1;
            int newDamage = hero.getDamage() * coefficient;
            hero.setDamage(newDamage);
        }
    }
}
