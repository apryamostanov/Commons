package com.a9ae0b01f0ffc.commons.implementation.static_string

class T_static_string_builder {

    private static final Boolean LC_REGISTER_NO = false
    private static final Boolean LC_ALLOW_CHANGES_AFTER_INIT_YES = true
    private ExpandoMetaClass p_expando_meta_class = new ExpandoMetaClass(T_static_string_builder, LC_REGISTER_NO, LC_ALLOW_CHANGES_AFTER_INIT_YES)
    private Boolean p_is_init = init()
    private static T_static_string_builder p_static_string_builder = new T_static_string_builder()

    static T_static_string_builder s() {
        return p_static_string_builder
    }

    Boolean init() {
        p_expando_meta_class.initialize()
        this.setMetaClass(p_expando_meta_class)
        return true
    }

    final T_static_string propertyMissing(String name) {
        T_static_string l_static_string = new T_static_string(name)
        return l_static_string
    }

}
