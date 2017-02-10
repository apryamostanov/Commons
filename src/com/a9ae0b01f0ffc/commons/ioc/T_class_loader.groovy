package com.a9ae0b01f0ffc.commons.ioc

import com.a9ae0b01f0ffc.commons.config_helper.T_conf
import com.a9ae0b01f0ffc.commons.exceptions.E_application_exception
import com.a9ae0b01f0ffc.commons.main.T_common_const
import com.a9ae0b01f0ffc.commons.static_string.T_static_string_builder

final class T_class_loader {

    private String p_class_loader_conf_file_name = T_common_const.GC_EMPTY_STRING
    private T_conf p_conf = T_common_const.GC_NULL_OBJ_REF as T_conf

    T_class_loader(String i_class_loader_conf_file_name) {
        p_class_loader_conf_file_name = i_class_loader_conf_file_name
        p_conf = new T_conf(i_class_loader_conf_file_name)
    }

    Object instantiate(String i_interface_name) {
        if (get_class_name(i_interface_name) == i_interface_name) {
            throw new E_application_exception(T_static_string_builder.s().Class_short_name_Z1_not_configured_in_Z2, i_interface_name, p_class_loader_conf_file_name)
        }
        try {
            return Class.forName(get_class_name(i_interface_name)).newInstance()
        } catch (ClassNotFoundException e_class_not_found) {
            throw new E_application_exception(T_static_string_builder.s().Unable_to_load_class_Z1_configured_in_Z2, get_class_name(i_interface_name), p_class_loader_conf_file_name, e_class_not_found)
        }
    }

    String get_class_name(String i_interface_name) {
        String l_class_name = p_conf.get_value_by_name(i_interface_name)
        if (l_class_name == T_common_const.GC_EMPTY_STRING) {
            l_class_name = i_interface_name
        }
        return l_class_name
    }

    String get_class_loader_conf_file_name() {
        return p_class_loader_conf_file_name
    }

    void set_class_loader_conf_file_name(String i_class_loader_conf_file_name) {
        this.p_class_loader_conf_file_name = i_class_loader_conf_file_name
    }

    T_conf get_conf() {
        return p_conf
    }

    void set_conf(T_conf i_conf) {
        this.p_conf = i_conf
    }
}