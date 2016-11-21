//
// Created by zhangfl on 2016/11/21.
//

#include "Player.h"

Reservation *Player::Reserve(Duartion const& duartion , Court const& court, int repeat) {
    //if (court.isAvilable(duartion))
    {
        m_reserve = new Reservation();
        m_reserve->setDuartion(duartion);
        if (!this->isVip() && repeat > 0)
        {
            return NULL;
        }
       // m_reserve->setCourt(court);

    }
    return m_reserve;
}

Player::~Player()
{
    delete m_reserve;
    m_reserve = NULL;
}

Court Player::find_nearest_court() {
    return Court();
}

bool Player::isVip() {
    return false;
}

