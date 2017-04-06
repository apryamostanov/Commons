package com.a9ae0b01f0ffc.commons.implementation.thread_local

import com.a9ae0b01f0ffc.commons.implementation.main.T_common_base_3_utils

import java.util.concurrent.ConcurrentHashMap

/*Apache tomcat interferes with normal Thread locals.*/
class T_thread_local<T_type> extends T_common_base_3_utils{

    static ConcurrentHashMap<Thread, ConcurrentHashMap<Class, T_type>> p_objects_by_thread_by_class = new ConcurrentHashMap<Thread, ConcurrentHashMap<Class, T_type>>()

    static void remove(Class i_class){
        if (p_objects_by_thread_by_class.get(Thread.currentThread()) != GC_NULL_OBJ_REF) {
            p_objects_by_thread_by_class.get(Thread.currentThread()).remove(i_class)
            if (p_objects_by_thread_by_class.get(Thread.currentThread()).size() == GC_EMPTY_SIZE) {
                p_objects_by_thread_by_class.remove(Thread.currentThread())
            }
        }
    }

    static void set(T_type p_object){
        if (p_objects_by_thread_by_class.get(Thread.currentThread()) != GC_NULL_OBJ_REF) {
            p_objects_by_thread_by_class.get(Thread.currentThread()).put(p_object.getClass(), p_object)
        } else {
            p_objects_by_thread_by_class.put(Thread.currentThread(), new ConcurrentHashMap<Class, T_type>())
            p_objects_by_thread_by_class.get(Thread.currentThread()).put(p_object.getClass(), p_object)
        }
    }

    static T_type get(Class i_class){
        p_objects_by_thread_by_class.get(Thread.currentThread())?.get(i_class)
    }

}