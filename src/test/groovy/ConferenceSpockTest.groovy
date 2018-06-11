package groovy

import conference.ConferenceSearch
import conference.Room

class ConferenceSpockTest extends spock.lang.Specification {
    def "按地点搜索会议室"(){
        given:"初始化搜索类"
            ConferenceSearch conferenceSearch = new ConferenceSearch()
        when:"进行搜索"
            List<Room> result =  conferenceSearch.search("杭州")
        then:"判断搜索结果"
            assert result.size() == 5
            result.every{
                it.getAddr() == "杭州"
            }
            result.each{
                assert it.getAddr() == "杭州"
            }
    }
}
