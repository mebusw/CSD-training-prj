package valor.arena

import arena.Hero
import arena.HeroAngela
import arena.HeroXiangyu

class HeroTest extends spock.lang.Specification {

    Hero groupAHero

    Hero groupBHero

    def setup(){
        groupAHero = new HeroAngela()
        groupBHero = new HeroXiangyu()
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

}
