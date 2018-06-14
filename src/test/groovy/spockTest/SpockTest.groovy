package groovy.spockTest

import spock.lang.Specification

import java.util.function.Consumer


class SpockTest extends Specification {
    def "误区1:用for循环里面进行断言"() {
        given: ""
        List<String> ones = Arrays.asList("one1", "one", "one")

        when: "用for循环形式断言"
        then:

        for (String item : ones) {
            "one" == item   //应该失败然而通过了
        }
        for (String item : ones) {
            "one" != item   //应该失败然而通过了
        }

        when: "直接取出其中一条断言"
        then:
        ones.get(0) == "one1" //正确通过了

        when: "用for i 遍历 用get(i)方式取元素断言"
        then:
        for (int i = 0; i < ones.size(); i++) {
            def one = ones.get(i)
            "one" == one    //应该失败然而通过了
        }
    }

    def "误区2:用java 8 的Iterable forEach循环断言"() {
        given: ""
        List<String> ones = Arrays.asList("one1", "one", "one", "one")
        expect: "结果无效，断言应该失败却通过了测试 ,在判断前增加assert即可"
        ones.forEach(new Consumer<String>() {
            @Override
            void accept(String item) {
                 "one" == item
            }
        })
    }

    def "循环体中断言正确用法"() {
        given: ""
        List<String> ones = Arrays.asList("one", "one", "one")

        when: "用for循环形式断言"
        then:

        ones.each {
            assert it == "one"
        }

        ones.every() {
            it == "one"
        }
    }


    def "循环体中断言正确用法Expect"() {
        expect:
        Arrays.asList("one1", "one", "one").each {
            assert it.contains("one")
        }

        Arrays.asList("one1", "one", "one").every() {
            x -> x.contains("one")
        }
    }


    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c
        where:
        a | b || c
        3 | 5 || 5
        7 | 0 || 7
        0 | 0 || 0
    }

    def "maximum of two numbers another where"() {
        expect:
        Math.max(a, b) == c
        where:
        a | _
        3 | _
        7 | _
        0 | _

        b << [5, 0, 0]

        c = a > b ? a : b
    }
}
