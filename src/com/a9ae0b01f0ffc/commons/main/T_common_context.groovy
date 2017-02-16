package com.a9ae0b01f0ffc.commons.main

final class T_common_context {

    private static ThreadLocal<T_common_context> p_context_thread_local = new ThreadLocal<T_common_context>()
    private T_common_commons p_commons = T_common_const.GC_NULL_OBJ_REF as T_common_commons


    void init_custom(String i_commons_conf_file_name) {
        check_init()
        p_context_thread_local.get().p_commons = new T_common_commons(i_commons_conf_file_name)
    }

    T_common_commons get_commons() {
        check_init()
        return ((T_common_context) p_context_thread_local.get()).p_commons
    }

    static T_common_context get_context() {
        check_init()
        return p_context_thread_local.get()
    }


    private static void check_init() {
        if (p_context_thread_local.get() == T_common_const.GC_NULL_OBJ_REF) {
            p_context_thread_local.set(new T_common_context())
        }
    }
}
