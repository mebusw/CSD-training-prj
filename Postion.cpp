//
// Created by zhangfl on 2016/11/21.
//

#include "Postion.h"

bool Postion::isValid() {
    return m_gpsX>=0.0 && m_gpsY>=0.0;
}
