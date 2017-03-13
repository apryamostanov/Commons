package com.a9ae0b01f0ffc.commons.tests

import com.a9ae0b01f0ffc.commons.implementation.config.T_conf_accessor
import com.a9ae0b01f0ffc.commons.implementation.exceptions.E_application_exception
import com.a9ae0b01f0ffc.commons.implementation.ioc.T_class_loader
import com.a9ae0b01f0ffc.commons.implementation.main.T_common_base_1_const
import com.a9ae0b01f0ffc.commons.implementation.main.T_common_base_3_utils
import com.a9ae0b01f0ffc.commons.implementation.static_string.T_static_string_builder
import com.a9ae0b01f0ffc.commons.tests.data.I_sample
import org.junit.Test

/**/

class T_tests_commons {

    private static final String PC_WORKING_DIR = "./src/com/a9ae0b01f0ffc/commons/tests/data/"

    @Test
    void application_exception_001() {
        E_application_exception e_application_exception = new E_application_exception(new T_static_string_builder().THIS_IS_ERROR_TEXT)
        try {
            throw e_application_exception
        } catch (E_application_exception e) {
            assert e.toString().contains("THIS IS ERROR TEXT")
        }
    }

    @Test
    void static_string_002() {
        assert new T_static_string_builder().THIS_IS_SOME_RANDOM_TEXT.toString() == "THIS_IS_SOME_RANDOM_TEXT"
    }

    @Test
    void static_string_003() {
        assert new T_static_string_builder().THIS_IS_NEGATIVE_TEST.toString() != "THIS_IS_SOME_RANDOM_TEXT"
    }

    @Test
    void static_string_004() {
        assert T_static_string_builder.s().THIS_IS_NEGATIVE_TEST2.toString() != "THIS_IS_SOME_RANDOM_TEXT2"
    }

    @Test
    void conf_001() {
        assert new T_conf_accessor(PC_WORKING_DIR + "sample_config_with_any_name.conf").test_parameter321 == "test_val123"
    }

    @Test
    void conf_002() {
        assert new T_conf_accessor(PC_WORKING_DIR + "sample_config_with_any_name.conf").GC_TEST_PARAMETER321 == "test_val123"
    }

    @Test
    void conf_003() {
        assert new T_conf_accessor(PC_WORKING_DIR + "sample_config_with_any_name.conf").override("test_parameter321", "1234") == "test_val123"
    }

    @Test
    void conf_004() {
        assert new T_conf_accessor(PC_WORKING_DIR + "sample_config_with_any_name.conf").override("test_parameter3210", "1234") == "1234"
    }

    @Test
    void conf_005() {
        assert new T_conf_accessor(PC_WORKING_DIR + "sample_config_with_any_name.conf").test_parameter321("1234") == "test_val123"
    }

    @Test
    void conf_006() {
        assert new T_conf_accessor(PC_WORKING_DIR + "sample_config_with_any_name.conf").test_parameter3210("1234") == "1234"
    }

    @Test
    void ioc_001() {
        T_class_loader l_class_loader = new T_class_loader(PC_WORKING_DIR + "sample_class.conf")
        I_sample l_sample = l_class_loader.instantiate("I_sample")
        assert l_sample.do_something() == "zz"
    }

    @Test
    void static_string_005() {
        assert "qqqqVVV n nnYY" == T_common_base_3_utils.tokenize(T_common_base_1_const.s.qqqqZ1_n_nnZ2, "_", "Z", Arrays.asList("VVV", "YY"))
    }

    @Test
    void util_01() {
        assert !T_common_base_3_utils.method_arguments_present(new ArrayList<Object>())
    }

    @Test
    void util_02() {
        ArrayList<Object> l_array = new ArrayList<Object>()
        l_array.add("z")
        assert T_common_base_3_utils.method_arguments_present(l_array)
    }

    @Test
    void util_03() {
        Object[] l_array = new Object[1]
        l_array[0] = "q"
        assert T_common_base_3_utils.method_arguments_present(l_array)
    }

}