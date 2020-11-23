package jp.ac.uryukyu.ie.e205701;

public class Sword {
    private String name;
    private int attack;

    public Sword(String _name, int _attack) {
        this.name = _name;
        this.attack = _attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

}
