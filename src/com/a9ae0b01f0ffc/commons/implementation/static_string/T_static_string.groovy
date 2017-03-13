package com.a9ae0b01f0ffc.commons.implementation.static_string

import com.a9ae0b01f0ffc.commons.implementation.main.T_common_base_1_const

final class T_static_string {

    private String p_string = T_common_base_1_const.GC_EMPTY_STRING
    static T_static_string PC_EMPTY_STATIC_STRING = new T_static_string(T_common_base_1_const.GC_EMPTY_STRING)

    protected T_static_string(String i_string) {
        p_string = i_string
    }

    @Override
    final String toString() {
        return p_string
    }

}
