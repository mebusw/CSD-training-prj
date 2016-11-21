//
// Created by zhangfl on 2016/11/21.
//

#ifndef CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_PLAYER_H
#define CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_PLAYER_H

#include <string>
#include "Reservation.h"
#include "Duartion.h"
#include "Court.h"

class Player
{
public:
    //0 not repeat
    //1 daily repeat
    //2 weekly repeat
    Reservation* Reserve(Duartion const& duartion, Court const& court, int repeatly = 0 );
    ~Player();

    Court find_nearest_court();

private:
    Reservation* m_reserve;

    bool isVip();
};
#endif //CSD_TRAINING_PRJ_CPLUSPLUS_2016NOV_PLAYER_H
