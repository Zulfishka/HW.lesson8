package kg.geecks.game.players;

import kg.geecks.game.general.RPG_Game;

public class Berserk extends Hero {
    private int blockedDamage;
    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.BLOCK_DAMAGE_AND_REVERT,name);
    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        double bossAttack = (double)boss.getDamage();
        double coefficient = 0.5;

        int health = boss.getHealth() - (int)(bossAttack * coefficient);
        boss.setHealth(health);
        System.out.println("Trol hits: " + (int)(bossAttack * coefficient));
    }
}
