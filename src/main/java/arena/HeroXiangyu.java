package arena;

public class HeroXiangyu extends Hero {
    private int hp;
    private int mp;
    private int ap;

    public HeroXiangyu() {
        hp=180;
        mp=80;
        ap=10;
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
