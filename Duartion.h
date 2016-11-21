//
// Created by zhangfl on 2016/11/21.
//

#ifndef CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_DUARTION_H
#define CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_DUARTION_H
#include <string>

class Duartion {
public:
    Duartion();
    Duartion(std::string const& start, std::string const& end);
private:
    std::string m_start;
    std::string m_end;
};


#endif //CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_DUARTION_H
