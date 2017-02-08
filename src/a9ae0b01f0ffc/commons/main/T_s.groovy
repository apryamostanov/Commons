package a9ae0b01f0ffc.commons.main

import a9ae0b01f0ffc.commons.ioc.T_class_loader
import a9ae0b01f0ffc.commons.static_string.T_static_string_builder

abstract class T_s {

    static final T_commons commons() {
        return T_context.getInstance().p_commons_thread_local.get()
    }

    static final T_class_loader ioc() {
        return T_context.getInstance().get_ioc_thread_local().get()
    }

    static final T_static_string_builder s() {
        return T_const.GC_STATIC_STRING_BUILDER
    }

}
