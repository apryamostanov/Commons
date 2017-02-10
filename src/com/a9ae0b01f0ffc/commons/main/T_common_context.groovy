package com.a9ae0b01f0ffc.commons.main

final class T_common_context {

    private static ThreadLocal<T_common_context> p_context_thread_local = new ThreadLocal<T_common_context>()
    private T_common_commons p_commons = T_common_const.GC_NULL_OBJ_REF as T_common_commons

    static {
        p_context_thread_local.set(new T_common_context())
    }

    T_common_commons get_commons() {
        return ((T_common_context) p_context_thread_local.get()).p_commons
    }

    static T_common_context get_context() {
        return p_context_thread_local.get()
    }

}
