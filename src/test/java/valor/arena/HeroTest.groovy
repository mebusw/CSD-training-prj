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

    def "英雄移动测试1"(){
        given:"原来2个英雄的距离"
        def orginDistance = groupAHero.distance(groupBHero)
        def orginDistance2 = groupBHero.distance(groupAHero)
        when:"往另外一个英雄方向移动一次"
        groupAHero.forward(groupBHero)
        then:"原来2人相互距离计算值一样,现在距离变短了"
        def distance = groupBHero.distance(groupAHero)
        distance < orginDistance
        orginDistance == orginDistance2
    }

}
