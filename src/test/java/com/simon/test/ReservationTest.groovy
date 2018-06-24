package com.simon.test

import com.simon.institution.Institution
import spock.lang.Specification

class ReservationTest extends Specification {

    def institution

    def setup() {
        institution = new Institution("Uperform")
    }

    def "填写账号和密码能够注册"() {
        expect:
        institution.register(userId, password) == true

        where:
        userId | password
        "abc" | "123"
    }

    def "错误账号和密码注册验证"() {
        given:

        when:
        institution.register("test", "1111")

        then:
        institution.register("test", "2222") >> false

        then:
        institution.register("", "1111") >> false

        then:
        institution.register("abc", "") >> false

        then:
        institution.register("", "") >> false
    }

    def "登陆功能验证"(){
        given:

        when:
        institution.register("abc", "1111")

        then:
        institution.login("abcd", "dddd") >> false

        then:
        institution.login("abc", "dddd") >> false

        then:
        institution.login("abc", "1111") >> true
    }


}