//
// Created by zhangfl on 2016/11/21.
//

#ifndef CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_SCHEDULE_H
#define CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_SCHEDULE_H
//#include <set>
#include "Duartion.h"


class Schedule {
public:
    Schedule();
    bool reserve(Duartion const& duartion);

private:
   // std::set<int>  m_duartionList;
};


#endif //CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_SCHEDULE_H
