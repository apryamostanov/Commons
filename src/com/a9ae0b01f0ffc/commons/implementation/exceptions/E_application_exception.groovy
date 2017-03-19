package com.a9ae0b01f0ffc.commons.implementation.exceptions

import com.a9ae0b01f0ffc.commons.implementation.main.T_common_base_1_const
import com.a9ae0b01f0ffc.commons.implementation.main.T_common_base_3_utils
import com.a9ae0b01f0ffc.commons.implementation.static_string.T_static_string
import org.codehaus.groovy.runtime.StackTraceUtils

class E_application_exception extends Exception {

    private static final String PC_MESSAGE_FORMAT_TOKEN_TRACE = "Z"
    private static final String PC_MESSAGE_FORMAT_TOKEN_SPACE = "_"
    private ArrayList<Object> p_traces = new ArrayList<Object>()
    String p_guid = UUID.randomUUID()

    String get_guid() {
        return p_guid
    }

    E_application_exception(T_static_string i_msg_text, Object... i_traces = T_common_base_1_const.GC_SKIPPED_ARGS as Object[]) {
        super(T_common_base_3_utils.tokenize(i_msg_text, PC_MESSAGE_FORMAT_TOKEN_SPACE, PC_MESSAGE_FORMAT_TOKEN_TRACE, Arrays.asList(i_traces)))
        if (T_common_base_3_utils.method_arguments_present(i_traces)) {
            p_traces = new ArrayList<Object>(Arrays.asList(i_traces))
        }
    }

    @Override
    String toString() {
        String l_exception_text = T_common_base_1_const.GC_EMPTY_STRING
        Throwable sanitizedThrowable
        sanitizedThrowable = new StackTraceUtils().sanitizeRootCause(this)
        l_exception_text += this.getClass().getName() + T_common_base_1_const.GC_COMMA + this.getMessage() + System.lineSeparator()
        l_exception_text += Arrays.toString(sanitizedThrowable.getStackTrace()).replace(T_common_base_1_const.GC_COMMA, System.lineSeparator() + T_common_base_1_const.GC_AT_CHAR)
        return l_exception_text
    }

    ArrayList<Object> get_traces() {
        return p_traces
    }

}
