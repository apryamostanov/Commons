package a9ae0b01f0ffc.commons.ioc

import a9ae0b01f0ffc.commons.config_helper.T_conf
import a9ae0b01f0ffc.commons.exceptions.E_application_exception
import a9ae0b01f0ffc.commons.static_string.T_static_string_builder

class T_class_loader {

    String p_class_loader_conf_file_name = ""
    T_conf p_conf = null

    T_class_loader(String i_class_loader_conf_file_name) {
        p_class_loader_conf_file_name = i_class_loader_conf_file_name
        p_conf = new T_conf(i_class_loader_conf_file_name)
    }

    Object instantiate(String i_interface_name) {
        if (get_class_name(i_interface_name) == i_interface_name) {
            throw new E_application_exception(T_static_string_builder.s().CLASS_SHORT_NAME_Z1_NOT_CONFIGURED_IN_Z2, i_interface_name, p_class_loader_conf_file_name)
        }
        try {
            return Class.forName(get_class_name(i_interface_name)).newInstance()
        } catch (ClassNotFoundException e_class_not_found) {
            throw new E_application_exception(T_static_string_builder.s().UNABLE_TO_LOAD_CLASS_Z1_CONFIGURED_IN_Z2, get_class_name(i_interface_name), p_class_loader_conf_file_name, e_class_not_found)
        }
    }

    String get_class_name(String i_interface_name) {
        String l_class_name = p_conf.get_value_by_name(i_interface_name)
        if (l_class_name == "") {
            l_class_name = i_interface_name
        }
        return l_class_name
    }

}