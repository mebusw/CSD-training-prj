//
// Created by zhangfl on 2016/11/21.
//

#ifndef CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_COURT_H
#define CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_COURT_H


#include "Postion.h"
#include "Duartion.h"
#include "Schedule.h"

class Court {
public:
    bool isValid();
    bool isAvilable(Duartion const& duartion);
private:
    Postion m_position;
    Schedule m_unreseved;
};


#endif //CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_COURT_H
