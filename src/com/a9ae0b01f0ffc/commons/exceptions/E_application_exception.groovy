package com.a9ae0b01f0ffc.commons.exceptions

import com.a9ae0b01f0ffc.commons.main.T_common_const
import com.a9ae0b01f0ffc.commons.main.T_common_utils
import com.a9ae0b01f0ffc.commons.static_string.T_static_string
import org.codehaus.groovy.runtime.StackTraceUtils

class E_application_exception extends Exception {

    private static final String PC_MESSAGE_FORMAT_TOKEN_TRACE = "Z"
    private static final String PC_MESSAGE_FORMAT_TOKEN_SPACE = "_"
    private static Boolean p_is_tokenization_enabled = T_common_const.GC_TRUE
    private ArrayList<Object> p_traces = new ArrayList<Object>()

    static Boolean is_tokenization_enabled() {
        return p_is_tokenization_enabled
    }

    static void set_is_tokenization_enabled(Boolean i_is_tokenization_enabled) {
        p_is_tokenization_enabled = i_is_tokenization_enabled
    }

    E_application_exception(T_static_string i_msg_text, Object... i_traces = T_common_const.GC_SKIPPED_ARGS as Object[]) {
        super(is_tokenization_enabled() ? T_common_utils.tokenize(i_msg_text, PC_MESSAGE_FORMAT_TOKEN_SPACE, PC_MESSAGE_FORMAT_TOKEN_TRACE, i_traces) : i_msg_text.toString())
        if (T_common_utils.method_arguments_present(i_traces)) {
            p_traces = new ArrayList<Object>(Arrays.asList(i_traces))
        }
    }

    @Override
    String toString() {
        String l_exception_text = T_common_const.GC_EMPTY_STRING
        Throwable sanitizedThrowable
        sanitizedThrowable = new StackTraceUtils().sanitizeRootCause(this)
        l_exception_text += this.getClass().getName() + T_common_const.GC_COMMA + this.getMessage() + System.lineSeparator()
        l_exception_text += Arrays.toString(sanitizedThrowable.getStackTrace()).replace(T_common_const.GC_COMMA, System.lineSeparator() + T_common_const.GC_AT_CHAR)
        return l_exception_text
    }

    ArrayList<Object> get_traces() {
        return p_traces
    }

}
