package valor.arena

import arena.Hero
import arena.HeroAngela
import arena.HeroXiangyu

class HeroTest extends spock.lang.Specification {

    Hero groupAHero

    Hero groupBHero

    def setup(){
        groupAHero = new HeroAngela(1)
        groupBHero = new HeroXiangyu(2)
    }

    def "可以创建2个种类的英雄"(){

        expect:"有生命值,有法力,有攻击力"
        groupAHero.hp > 0
        groupBHero.hp > 0
        groupAHero.mp > 0
        groupBHero.mp > 0
        groupAHero.ap > 0
        groupBHero.ap > 0
    }

    def "英雄站位测试"(){

        expect:"groupA和groupB的英雄初始站位不同"
        groupAHero.positionX != groupBHero.positionX || groupAHero.positionY != groupBHero.positionY

    }

}
