//
// Created by zhangfl on 2016/11/21.
//

#ifndef CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_RESERVATION_H
#define CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_RESERVATION_H

#include "Duartion.h"

class Reservation
{
private:
  Duartion m_duartion;
public:
    void setDuartion(const Duartion & duartion);
    Reservation(){}
};
#endif //CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_RESERVATION_H
