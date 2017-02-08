package a9ae0b01f0ffc.commons.static_string

import a9ae0b01f0ffc.commons.main.T_const

final class T_static_string {

    private String p_string = T_const.GC_EMPTY_STRING

    protected T_static_string(String i_string) {
        p_string = i_string
    }

    @Override
    final String toString() {
        return p_string
    }

}
