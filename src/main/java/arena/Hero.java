package arena;

public class Hero {

    private int hp;
    private int mp;
    private int ap;

    private int group;
    private int[] position ;

    public int getPositionX() {
        return position[0];
    }

    public int getPositionY() {
        return position[0];
    }

    public void setPositionX(int position) {
        this.position[0] = position;
    }

    public void setPositionY(int position) {
        this.position[1] = position;
    }

    public void setPosition(int x,int y){
        this.position[0] = x;
        this.position[1] = y;
    }

    protected Hero() {
        hp=150;
        mp=100;
        ap=12;
        group = -1;
    }

    protected Hero(int hp, int mp, int ap, int group){
        this.hp = hp;
        this.mp = mp;
        this.ap = ap;
        this.position=new int[]{(group + 1),(group + 1)* 100};
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
