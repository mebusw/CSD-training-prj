package groovy.mock

import mock.IUserService
import mock.User

class UserServiceSpec extends spock.lang.Specification {

    def "Mock UserService doQuery"() {
        given: "mock userService"
        IUserService userService = Mock(IUserService)
        User user = new User("Owen", 36)
        when: "query"
        userService.queryUser("Owen") >> user
        User user1 = userService.queryUser("Owen")
        then: "断言"
        println(user1)
        user1.getName() == "Owen"
    }

    def "Mock UserService doQuery verify call times"() {
        given: "mock userService"
        IUserService userService = Mock(IUserService)
        User user = new User("Owen", 36)
        when: "query"
        userService.queryUser("Owen") >> user
        User user1 = userService.queryUser("Owen")
        User user2 = userService.queryUser("Owen1")
        then: "断言"
        println(user1)
        println(user2)
        1 * userService.queryUser("Owen")
        1 * userService.queryUser("Owen1")
    }
    def "Mock UserService doQuery verify call times using parameters "() {
        given: "mock userService"
        IUserService userService = Mock(IUserService)
        User user = new User("Owen", 36)
        when: "query"
        userService.queryUser(name) >> user
        userService.queryUser(name)
        then: "断言"
        times * userService.queryUser(name)
        where:
        name | times
        "Owen1" | 1

    }
}