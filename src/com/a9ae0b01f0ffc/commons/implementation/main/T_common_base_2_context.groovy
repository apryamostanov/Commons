package com.a9ae0b01f0ffc.commons.implementation.main

import com.a9ae0b01f0ffc.commons.implementation.config.T_common_conf
import com.a9ae0b01f0ffc.commons.implementation.exceptions.E_application_exception
import com.a9ae0b01f0ffc.commons.implementation.ioc.T_class_loader

class T_common_base_2_context extends T_common_base_1_const{

    private static ThreadLocal<T_common_base_2_context> p_context_thread_local = new ThreadLocal<T_common_base_2_context>()
    private T_common_conf p_common_conf = GC_NULL_OBJ_REF as T_common_conf
    private T_class_loader p_ioc = GC_NULL_OBJ_REF as T_class_loader

    static void init_custom(String i_commons_conf_file_name) {
        check_init()
        p_context_thread_local.get().p_common_conf = new T_common_conf(i_commons_conf_file_name)
    }

    static T_common_conf c() {
        check_init()
        T_common_conf l_common_conf = ((T_common_base_2_context) p_context_thread_local.get()).p_common_conf
        if (l_common_conf == GC_NULL_OBJ_REF) {
            throw new E_application_exception(s.Unable_to_access_configuration_as_it_has_not_been_initialized)
        } else {
            return l_common_conf
        }
    }

    static T_common_base_2_context x() {
        check_init()
        return p_context_thread_local.get()
    }


    private static void check_init() {
        if (p_context_thread_local.get() == GC_NULL_OBJ_REF) {
            p_context_thread_local.set(new T_common_base_2_context())
        }
    }

    static T_class_loader get_ioc() {
        return x().p_ioc
    }

}
