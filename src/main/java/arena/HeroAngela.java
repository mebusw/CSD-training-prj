package arena;

public class HeroAngela extends Hero {
    private int hp;
    private int mp;
    private int ap;

    public HeroAngela() {
        hp=150;
        mp=100;
        ap=12;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
