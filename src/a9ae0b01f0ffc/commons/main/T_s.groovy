package a9ae0b01f0ffc.commons.main

import a9ae0b01f0ffc.commons.ioc.T_class_loader
import a9ae0b01f0ffc.commons.static_string.T_static_string_builder

abstract class T_s {

    static T_commons commons() {
        return T_context.getInstance().p_commons_thread_local.get()
    }

    static T_class_loader ioc() {
        return T_context.getInstance().get_ioc_thread_local().get()
    }

    static T_static_string_builder s() {
        return T_const.GC_STATIC_STRING_BUILDER
    }

    static Object nvl(Object i_primary_object, Object i_backup_object) {
        Object l_result_object
        if (i_primary_object == T_const.GC_NULL_OBJ_REF || i_primary_object == T_const.GC_EMPTY_STRING) {
            l_result_object = i_backup_object
        } else {
            l_result_object = i_primary_object
        }
        return l_result_object
    }

    static T_const constants() {
        return T_const.GC_CONST
    }

}
