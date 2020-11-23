package jp.ac.uryukyu.ie.e205701;

/**
 * ヒーロークラス。 攻撃すると50%の確率でクリティカルになる。クリティカルダメージは自身の攻撃力の２倍。
 */
public class Hero extends Character {
    private double critical = 0.5;
    private Sword sword;

    public void setSword(Sword _sword) {
        this.sword = _sword;
    }

    public String getSwordName() {
        return this.sword.getName();
    }

    public int getSwordAttack() {
        return this.sword.getAttack();
    }

    public double getCritical() {
        return this.critical;
    }

    public Hero(String name, int maximumHP, int attack) {
        this.setName(name);
        this.setHitPoint(maximumHP);
        this.setAttack(attack);
        this.setDead(false);
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
        System.out.println("装備：なし");
    }

    public Hero(String name, int maximumHP, int attack, Sword _sword) {
        int sumAttack = attack + _sword.getAttack();
        this.setName(name);
        this.setHitPoint(maximumHP);
        this.setAttack(sumAttack);
        this.setDead(false);
        this.setSword(_sword);
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, sumAttack);
        System.out.printf("装備：%s 攻撃力%d→%d\n", _sword.getName(), attack, sumAttack);
    }

    public void attack(Character target) {
        if (!this.canAttack(target)) {
            return;
        }

        int damage = (int) (Math.random() * this.getAttack());

        if (Math.random() <= this.getCritical()) {
            damage *= 2;
            System.out.printf("%sの攻撃！%sに%dのクリティカルダメージを与えた！！\n", this.getName(), target.getName(), damage);
        } else {
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.getName(), target.getName(), damage);
        }
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
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", this.getName());
        }
    }
}