package arena;

public class Hero {

/*    经验值：EXP（Experience）
    战斗力：CE（Combat Effectiveness)
    血量：HP(Health Point）
    魔力值：MP(Magic Point)
    级别/级数：LV(Level)
    普通金钱：Cash/Money/Game Point(常用图标代替)
    黄金：Gold(常用图标代替)
    钻石：Diamond(常用图标代替)
    武器：Weapon
    主武器：Primary Weapon
    副武器：Secondary Weapon
    伤害：Damage
    杀敌：Kill
    弹药：AMMO/Ammunition
    爆头：Head Shot*/

    private int hp;
    private int mp;
    private int ce;

    private int group;
    private int[] position ;

    public int getPositionX() {
        return position[0];
    }

    public int getPositionY() {
        return position[1];
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
        ce =12;
        group = -1;
    }

    protected Hero(int hp, int mp, int ce, int group){
        this.hp = hp;
        this.mp = mp;
        this.ce = ce;
        this.position=new int[]{(group + 1),(group + 1)* 100};
    }

    public int getCe() {
        return ce;
    }

    public void setCe(int ce) {
        this.ce = ce;
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

    public double distance(Hero anotherHero){
        return Math.sqrt(Math.pow(this.getPositionX()-anotherHero.getPositionX(),2)+Math.pow(this.getPositionY()-anotherHero.getPositionY(),2));
    }

    public Hero forward(Hero anotherHero){
        if(Math.abs(anotherHero.getPositionX() - this.getPositionX()) <=1 && Math.abs(anotherHero.getPositionY() - this.getPositionY()) <=1){
            return this;
        }
        int factorX,factorY;
        factorX = anotherHero.getPositionX()-this.getPositionX();
        if(factorX == 0){
            setPositionY(this.getPositionY() + (anotherHero.getPositionY()-this.getPositionY()>0?1:-1));
            return this;
        }
        factorY = anotherHero.getPositionY()-this.getPositionY();
        //factorY = factorY ==0 ? 0:(factorY>0?1:-1);
        if(factorY == 0){
            setPositionX(this.getPositionX() + (anotherHero.getPositionX()-this.getPositionX()>0?1:-1));
            return this;
        }

        int rate = Math.abs(factorY / factorX);
        if(rate <=0.5){
            setPositionX(getPositionX() + (factorX>0?1:-1));
        }else if(rate <= 2){
            setPosition(getPositionX() + (factorX>0?1:-1),getPositionY() + (factorY>0?1:-1));
        }else {
            setPositionY(getPositionY()+ (factorY>0?1:-1));
        }
        return this;
    }
}
