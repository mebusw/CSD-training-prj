package groovy.fizzBuzz

import fizzBuzz.FizzBuzz

class FizzBuzzSpockTest extends spock.lang.Specification{
    def "测试数字1"(){
        expect:""
        FizzBuzz.answer(1)=="1"
    }

    def "测试数字3"(){
        expect:""
        FizzBuzz.answer(3)=="Fizz"
    }

    def "测试数字5"(){
        expect:""
        FizzBuzz.answer(5)=="Buzz"
    }

    def "测试数字15"(){
        expect:""
        FizzBuzz.answer(15)=="FizzBuzz"
    }

    def "测试数字75"(){
        expect:""
        FizzBuzz.answer(15)=="FizzBuzz"
    }
    def "测试数字1到3"(){
        expect:""
        FizzBuzz.showOutput(1,3)=="1\n2\nFizz\n"
    }
    def "测试数字1到5"(){
        expect:""
        FizzBuzz.showOutput(1,5)=="1\n2\nFizz\n4\nBuzz\n"
    }

    def "测试数字1到10"(){
        expect:""
        FizzBuzz.showOutput(1,10)=="1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n"
    }

    def "测试数字1到15"(){
        expect:""
        FizzBuzz.showOutput(1,15)=="1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n11\nFizz\n13\n14\nFizzBuzz\n"
    }

}
