package a9ae0b01f0ffc.commons.config_helper

import a9ae0b01f0ffc.commons.exceptions.E_application_exception
import a9ae0b01f0ffc.commons.static_string.T_static_string_builder
import groovy.util.slurpersupport.GPathResult

class T_conf {

    private static final Boolean LC_REGISTER_NO = false
    private static final Boolean LC_ALLOW_CHANGES_AFTER_INIT_YES = true
    private ExpandoMetaClass p_expando_meta_class = new ExpandoMetaClass(T_conf, LC_REGISTER_NO, LC_ALLOW_CHANGES_AFTER_INIT_YES)
    private Boolean p_is_init = init()
    private GPathResult p_gpathresult = null
    private HashMap<String, String> p_values_by_name = new HashMap<String, String>()
    private HashMap<String, String> p_names_by_value = new HashMap<String, String>()

    Boolean init() {
        p_expando_meta_class.initialize()
        this.setMetaClass(p_expando_meta_class)
        return true
    }

    final String propertyMissing(String i_parameter_name) {
        return override(i_parameter_name, "")
    }

    String methodMissing(String i_method_name, args) {
        return override(i_method_name, args[0])
    }

    T_conf(String i_conf_file_name) {
        File l_conf_file_handle = new File(i_conf_file_name)
        try {
            p_gpathresult = (GPathResult) new XmlSlurper().parse(l_conf_file_handle)
        } catch (FileNotFoundException e_file_not_found) {
            throw new E_application_exception(T_static_string_builder.s().Configuration_file_not_found_for_relative_path_Z1, l_conf_file_handle.getAbsolutePath(), e_file_not_found)
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
            return ""
        }
    }

    String override(String i_parameter_name, String i_default_value) {
        String l_parameter_name = i_parameter_name.replace("GC_", "").toLowerCase()
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
            return ""
        }
    }

}
