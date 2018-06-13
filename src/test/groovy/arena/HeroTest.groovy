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

    def "英雄移动测试2"(){
        given:"原来2个英雄在相邻的格子"
        groupAHero.setPosition(10,12);
        groupBHero.setPosition(11,11)
        def orginDistance = groupBHero.distance(groupAHero);
        when:"往另外一个英雄方向移动一次"
        groupAHero.forward(groupBHero)
        then:"距离和原来一样"
        def distance = groupAHero.distance(groupBHero)
        distance == orginDistance
    }

    def "英雄移动测试3"(){
        given:"原来2个英雄在相邻的格子"
        groupAHero.setPosition(10,12);
        groupBHero.setPosition(10,11)
        def orginDistance = groupBHero.distance(groupAHero);
        when:"往另外一个英雄方向移动一次"
        groupAHero.forward(groupBHero)
        then:"距离和原来一样"
        def distance = groupAHero.distance(groupBHero)
        distance == orginDistance
    }

    def "英雄移动测试4"(){
        given:"原来2个英雄在相邻的格子"
        groupAHero.setPosition(10,12);
        groupBHero.setPosition(9,12)
        def orginDistance = groupBHero.distance(groupAHero);
        when:"往另外一个英雄方向移动一次"
        groupAHero.forward(groupBHero)
        then:"距离和原来一样"
        def distance = groupAHero.distance(groupBHero)
        distance == orginDistance
    }

    def "英雄移动测试5"(){
        given:"原来2个英雄在相邻的格子"
        groupAHero.setPosition(10,12);
        groupBHero.setPosition(13,11)
        def orginDistance = groupBHero.distance(groupAHero);
        when:"往另外一个英雄方向移动一次"
        groupAHero.forward(groupBHero)
        then:"距离缩短"
        def distance = groupAHero.distance(groupBHero)
        distance < orginDistance
        groupAHero.getPositionX() == 11
        groupAHero.getPositionY() == 12
    }

    def "英雄移动测试6"(){
        given:"原来2个英雄在相邻的格子"
        groupAHero.setPosition(10,12);
        groupBHero.setPosition(13,11)
        def orginDistance = groupBHero.distance(groupAHero);
        when:"往另外一个英雄方向移动一次"
        groupBHero.forward(groupAHero)
        then:"距离缩短"
        def distance = groupAHero.distance(groupBHero)
        distance < orginDistance
        groupBHero.getPositionX() == 12
        groupBHero.getPositionY() == 11
    }

}
