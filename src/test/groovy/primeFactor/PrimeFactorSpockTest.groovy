package groovy.primeFactor

import primeFactor.PrimeFactor
import spock.lang.Specification

class PrimeFactorSpockTest extends Specification {
    def "使用expect-where测试质因数分解"(){
        expect:"魔法 定义表达式"
        PrimeFactor.factor(number as int) == result as List
        where:""
        number | result
        2 | [2]
        3 | [3]
        4 | [2,2]
        5 | [5]
        6 | [2,3]
        7 | [7]
        8 | [2,2,2]
        9 | [3,3]
        2*5*11 | [2,5,11]
    }
}
