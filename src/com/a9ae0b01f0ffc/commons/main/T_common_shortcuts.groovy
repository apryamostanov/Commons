package com.a9ae0b01f0ffc.commons.main

import com.a9ae0b01f0ffc.commons.ioc.T_class_loader
import com.a9ae0b01f0ffc.commons.static_string.T_static_string_builder

final class T_common_shortcuts {

    static final T_common_commons commons() {
        return T_common_context.get_context().get_commons()
    }

    static final T_static_string_builder s() {
        return T_common_const.GC_STATIC_STRING_BUILDER
    }

}
