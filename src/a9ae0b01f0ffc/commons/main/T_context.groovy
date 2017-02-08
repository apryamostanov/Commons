package a9ae0b01f0ffc.commons.main

import a9ae0b01f0ffc.commons.ioc.T_class_loader

@Singleton
class T_context {

    ThreadLocal<T_commons> p_commons_thread_local = new ThreadLocal<T_commons>()
    ThreadLocal<T_class_loader> p_ioc_thread_local = new ThreadLocal<T_class_loader>()

    void init_custom(String i_commons_conf_file_name) {
        p_commons_thread_local.set(new T_commons())
        p_commons_thread_local.get().init_custom(i_commons_conf_file_name)
        p_ioc_thread_local.set(new T_class_loader(p_commons_thread_local.get().GC_CLASS_LOADER_CONF_FILE_NAME))
    }

    ThreadLocal<T_commons> get_commons_thread_local() {
        return p_commons_thread_local
    }

    void set_commons_thread_local(ThreadLocal<T_commons> i_commons_thread_local) {
        this.p_commons_thread_local = i_commons_thread_local
    }

    ThreadLocal<T_class_loader> get_ioc_thread_local() {
        return p_ioc_thread_local
    }

    void setP_ioc_thread_local(ThreadLocal<T_class_loader> i_ioc_thread_local) {
        this.p_ioc_thread_local = i_ioc_thread_local
    }
}
