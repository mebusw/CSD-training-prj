//
// Created by zhangfl on 2016/11/21.
//

#include "Court.h"

bool Court::isValid() {
    return this->m_position.isValid();
}

bool Court::isAvilable(Duartion const &duartion) {
    return false;
}
