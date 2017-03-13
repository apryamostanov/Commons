package com.a9ae0b01f0ffc.commons.implementation.config

import com.a9ae0b01f0ffc.commons.implementation.exceptions.E_application_exception
import com.a9ae0b01f0ffc.commons.implementation.main.T_common_base_1_const
import com.a9ae0b01f0ffc.commons.implementation.static_string.T_static_string_builder
import groovy.util.slurpersupport.GPathResult

class T_conf_accessor extends T_common_base_1_const{

    private static final Boolean LC_REGISTER_NO = GC_FALSE
    private static final Boolean LC_ALLOW_CHANGES_AFTER_INIT_YES = GC_TRUE
    private ExpandoMetaClass p_expando_meta_class = new ExpandoMetaClass(T_conf_accessor, LC_REGISTER_NO, LC_ALLOW_CHANGES_AFTER_INIT_YES)
    private Boolean p_is_init = init()
    protected GPathResult p_gpathresult = GC_NULL_OBJ_REF as GPathResult
    protected HashMap<String, String> p_values_by_name = new HashMap<String, String>()
    protected HashMap<String, String> p_names_by_value = new HashMap<String, String>()

    Boolean init() {
        p_expando_meta_class.initialize()
        this.setMetaClass(p_expando_meta_class)
        return GC_TRUE
    }

    T_conf_accessor(GPathResult i_conf) {
        p_gpathresult = i_conf
        for (l_child_node in i_conf.children()) {
            p_values_by_name.put(l_child_node.name(), l_child_node.@value.text())
            p_names_by_value.put(l_child_node.@value.text(), l_child_node.name())
        }
    }

    T_conf_accessor() {

    }

    final String propertyMissing(String i_parameter_name) {
        return override(i_parameter_name, GC_EMPTY_STRING)
    }

    String methodMissing(String i_method_name, args) {
        return override(i_method_name, args[GC_FIRST_INDEX])
    }

    T_conf_accessor(String i_conf_file_name) {
        File l_conf_file_handle = new File(i_conf_file_name)
        try {
            p_gpathresult = (GPathResult) new XmlSlurper().parse(l_conf_file_handle)
        } catch (FileNotFoundException e_file_not_found) {
            throw new E_application_exception(s.Configuration_file_not_found_for_path_Z1, l_conf_file_handle.getAbsolutePath(), e_file_not_found)
        }
        for (l_child_node in p_gpathresult.children()) {
            p_values_by_name.put(l_child_node.name(), l_child_node.@value.text())
            p_names_by_value.put(l_child_node.@value.text(), l_child_node.name())
        }
    }

    String get_value_by_name(String i_parameter_name) {
        if (p_values_by_name.containsKey(i_parameter_name)) {
            p_values_by_name.get(i_parameter_name)
        } else {
            return GC_EMPTY_STRING
        }
    }

    String override(String i_parameter_name, String i_default_value) {
        final String LC_CONSTANT_PREFIX = "GC_"
        String l_parameter_name
        if (i_parameter_name.contains(LC_CONSTANT_PREFIX)) {
            l_parameter_name = i_parameter_name.replace(LC_CONSTANT_PREFIX, GC_EMPTY_STRING).toLowerCase()
        } else {
            l_parameter_name = i_parameter_name
        }
        if (p_values_by_name.containsKey(l_parameter_name)) {
            return get_value_by_name(l_parameter_name)
        } else {
            return i_default_value
        }
    }

    String get_name_by_value(String i_parameter_value) {
        if (p_names_by_value.containsKey(i_parameter_value)) {
            p_names_by_value.get(i_parameter_value)
        } else {
            return GC_EMPTY_STRING
        }
    }

}
