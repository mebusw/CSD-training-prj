package com.simon.test

import com.simon.institution.Institution
import spock.lang.Specification

class ReservationTest extends Specification {

    def institution

    def setup() {
        institution = new Institution("Uperform")
    }

    def "填写账号和密码能够注册"() {
        given:
        def userId = "abc"
        def password = "123"

        when:
        def result = institution.register(userId, password)

        then:
        result == true
    }

    def "重复的账号不能注册"() {
        given:
        def userId = "abc"
        def password = "123"

        when:
        institution.register(userId, password)
        def result = institution.register(userId, "234")

        then:
        result == false
    }

    def "未输入账号不能注册"() {
        given:
        def userId = ""
        def password = "123"

        when:
        def result = institution.register(userId, password)

        then:
        result == false
    }

    def "未输入密码不能注册"() {
        given:
        def userId = "abc"
        def password = ""

        when:
        def result = institution.register(userId, password)

        then:
        result == false
    }

    def "账号和密码都未输入不能注册"() {
        given:
        def userId = ""
        def password = ""

        when:
        def result = institution.register(userId, password)

        then:
        result == false
    }



}