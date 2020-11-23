package jp.ac.uryukyu.ie.e205701;

/**
 * 敵クラス。 30%の確率で麻痺毒攻撃。麻痺状態になると２ターンの間行動不能。
 */
public class Enemy extends Character {
    private double paralysisPrb = 0.3;

    public double getParalysisPrb() {
        return this.paralysisPrb;
    }

    public Enemy(String name, int maximumHP, int attack) {
        this.setName(name);
        this.setHitPoint(maximumHP);
        this.setAttack(attack);
        this.setDead(false);
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    public void attack(Character target) {
        if (!this.canAttack(target)) {
            return;
        }

        if (Math.random() <= paralysisPrb) {
            target.setParalyzed(true);
            System.out.printf("%sの麻痺毒！%sは麻痺状態になった！\n", this.getName(), target.getName());
            return;
        }

        int damage = (int) (Math.random() * this.getAttack());

        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.getName(), target.getName(), damage);
        target.wounded(damage);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * 
     * @param damage 受けたダメージ
     */

    public void wounded(int damage) {
        this.setHitPoint(this.getHitPoint() - damage);
        if (this.getHitPoint() < 0) {
            this.setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", this.getName());
        }
    }

}