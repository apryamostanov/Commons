package com.a9ae0b01f0ffc.commons.implementation.ioc

import com.a9ae0b01f0ffc.commons.implementation.config.T_conf_accessor
import com.a9ae0b01f0ffc.commons.implementation.exceptions.E_application_exception
import com.a9ae0b01f0ffc.commons.implementation.main.T_common_base_1_const
import com.a9ae0b01f0ffc.commons.implementation.main.T_common_base_3_utils
import com.a9ae0b01f0ffc.commons.implementation.static_string.T_static_string_builder
import groovy.util.slurpersupport.GPathResult

final class T_class_loader extends T_common_base_3_utils {

    private static String PC_ZERO_CONF_NAME = "zero_configuration"
    private String p_class_loader_conf_file_name = GC_EMPTY_STRING
    private T_conf_accessor p_conf = GC_NULL_OBJ_REF as T_conf_accessor

    T_class_loader(T_conf_accessor i_conf) {
        p_class_loader_conf_file_name = PC_ZERO_CONF_NAME
        p_conf = i_conf
    }

    T_class_loader(GPathResult i_conf) {
        p_class_loader_conf_file_name = PC_ZERO_CONF_NAME
        p_conf = new T_conf_accessor(i_conf)
    }

    T_class_loader(String i_class_loader_conf_file_name) {
        p_class_loader_conf_file_name = i_class_loader_conf_file_name
        p_conf = new T_conf_accessor(i_class_loader_conf_file_name)
    }

    Object instantiate(String i_interface_name) {
        if (get_class_name(i_interface_name) == i_interface_name) {
            throw new E_application_exception(s.Class_short_name_Z1_not_configured_in_Z2, i_interface_name, p_class_loader_conf_file_name)
        }
        try {
            return Class.forName(get_class_name(i_interface_name)).newInstance()
        } catch (ClassNotFoundException e_class_not_found) {
            throw new E_application_exception(s.Unable_to_load_class_Z1_configured_in_Z2, get_class_name(i_interface_name), p_class_loader_conf_file_name, e_class_not_found)
        }
    }

    String get_class_name(String i_interface_name) {
        String l_class_name = p_conf.get_value_by_name(i_interface_name)
        if (l_class_name == GC_EMPTY_STRING) {
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

    T_conf_accessor get_conf() {
        return p_conf
    }

    void set_conf(T_conf_accessor i_conf) {
        this.p_conf = i_conf
    }
}