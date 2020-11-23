package jp.ac.uryukyu.ie.e205701;

public abstract class Character {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    private boolean isParalyzed = false;
    private int paralyzedTrun = 0;

    private static final int RECOVER_PARALYZED_TRUN = 2;

    public String getName() {
        return this.name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public int getHitPoint() {
        return this.hitPoint;
    }

    public void setHitPoint(int _hitPoint) {
        this.hitPoint = _hitPoint;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int _attack) {
        this.attack = _attack;
    }

    public boolean getDead() {
        return this.dead;
    }

    public void setDead(boolean _dead) {
        this.dead = _dead;
    }

    public boolean getParalyzed() {
        return this.isParalyzed;
    }

    public void setParalyzed(boolean _isParalyzed) {
        this.isParalyzed = _isParalyzed;
    }

    public abstract void wounded(int damage);

    public boolean canAttack(Character target) {
        if (this.dead) {
            return false;
        }
        if (this.isParalyzed) {
            System.out.printf("%sは麻痺して攻撃できない...\n", this.getName());
            this.paralyzedTrun += 1;
            if (this.paralyzedTrun >= RECOVER_PARALYZED_TRUN) {
                this.isParalyzed = false;
                this.paralyzedTrun = 0;
            }
            return false;
        }
        return true;
    }

    public void attack(Character target) {
        if (!this.canAttack(target)) {
            return;
        }

        int damage = (int) (Math.random() * this.getAttack());

        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.getName(), target.getName(), damage);
        target.wounded(damage);
    }

}
