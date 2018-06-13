package valor.arena

import arena.Hero
import arena.HeroMagician
import arena.HeroWarrior

class HeroTest extends spock.lang.Specification {

    Hero heroAngela

    Hero heroXiangyu

    def setup(){
        heroAngela = new HeroMagician(1)
        heroXiangyu = new HeroWarrior(2)
    }

    def "可以创建2个种类的英雄"(){

        expect:"有生命值,有法力,有攻击力"
        heroAngela.hp > 0
        heroXiangyu.hp > 0
        heroAngela.mp > 0
        heroXiangyu.mp > 0
        heroAngela.ce > 0
        heroXiangyu.ce > 0
    }

    def "英雄站位测试"(){

        expect:"groupA和groupB的英雄初始站位不同"
        heroAngela.positionX != heroXiangyu.positionX || heroAngela.positionY != heroXiangyu.positionY

    }

    def "英雄移动测试1"(){
        given:"原来2个英雄的距离"
        def orginDistance = heroAngela.distance(heroXiangyu)
        def orginDistance2 = heroXiangyu.distance(heroAngela)
        when:"往另外一个英雄方向移动一次"
        heroAngela.forward(heroXiangyu)
        then:"原来2人相互距离计算值一样,现在距离变短了"
        def distance = heroXiangyu.distance(heroAngela)
        distance < orginDistance
        orginDistance == orginDistance2
    }

    def "英雄移动测试2"(){
        given:"原来2个英雄在相邻的格子"
        heroAngela.setPosition(10,12);
        heroXiangyu.setPosition(11,11)
        def orginDistance = heroXiangyu.distance(heroAngela);
        when:"往另外一个英雄方向移动一次"
        heroAngela.forward(heroXiangyu)
        then:"距离和原来一样"
        def distance = heroAngela.distance(heroXiangyu)
        distance == orginDistance
    }

    def "英雄移动测试3"(){
        given:"原来2个英雄在相邻的格子"
        heroAngela.setPosition(10,12);
        heroXiangyu.setPosition(10,11)
        def orginDistance = heroXiangyu.distance(heroAngela);
        when:"往另外一个英雄方向移动一次"
        heroAngela.forward(heroXiangyu)
        then:"距离和原来一样"
        def distance = heroAngela.distance(heroXiangyu)
        distance == orginDistance
    }

    def "英雄移动测试4"(){
        given:"原来2个英雄在相邻的格子"
        heroAngela.setPosition(10,12);
        heroXiangyu.setPosition(9,12)
        def orginDistance = heroXiangyu.distance(heroAngela);
        when:"往另外一个英雄方向移动一次"
        heroAngela.forward(heroXiangyu)
        then:"距离和原来一样"
        def distance = heroAngela.distance(heroXiangyu)
        distance == orginDistance
    }

    def "英雄移动测试5"(){
        given:"原来2个英雄在相邻的格子"
        heroAngela.setPosition(10,12);
        heroXiangyu.setPosition(13,11)
        def orginDistance = heroXiangyu.distance(heroAngela);
        when:"往另外一个英雄方向移动一次"
        heroAngela.forward(heroXiangyu)
        then:"距离缩短"
        def distance = heroAngela.distance(heroXiangyu)
        distance < orginDistance
        heroAngela.getPositionX() == 11
        heroAngela.getPositionY() == 12
    }

    def "英雄移动测试6"(){
        given:"原来2个英雄在相邻的格子"
        heroAngela.setPosition(10,12)
        heroXiangyu.setPosition(13,11)
        def orginDistance = heroXiangyu.distance(heroAngela)
        when:"往另外一个英雄方向移动一次"
        heroXiangyu.forward(heroAngela)
        then:"距离缩短"
        def distance = heroAngela.distance(heroXiangyu)
        distance < orginDistance
        heroXiangyu.getPositionX() == 12
        heroXiangyu.getPositionY() == 11
    }

    def "angela升级到15级测试"(){
        given:"angela是初始是一级的英雄"
        def originalHP = heroAngela.hp
        def originalMP = heroAngela.mp
        def originalCE = heroAngela.ce
        when:"设定angela的成长属性，并且升级到15级"
        heroAngela.setGrowthAttribute(100,120,23);
        heroAngela.levelUp(15)
        then:"angela的各项属性都有增加"
        heroAngela.hp > originalHP
        heroAngela.mp > originalMP
        heroAngela.ce > originalCE
    }


}
