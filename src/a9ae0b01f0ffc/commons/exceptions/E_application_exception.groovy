package a9ae0b01f0ffc.commons.exceptions

import a9ae0b01f0ffc.commons.static_string.T_static_string
import groovy.transform.CompileStatic
import org.codehaus.groovy.runtime.StackTraceUtils

@CompileStatic
class E_application_exception extends Exception {

    private static final String PC_MESSAGE_FORMAT_TOKEN_TRACE = "Z"
    private static final String PC_MESSAGE_FORMAT_TOKEN_SPACE = "_"
    private static Boolean p_is_tokenization_enabled = "true"
    ArrayList<Object> p_traces = null

    static Boolean is_tokenization_enabled() {
        return p_is_tokenization_enabled
    }

    static void set_is_tokenization_enabled(Boolean i_is_tokenization_enabled) {
        p_is_tokenization_enabled = i_is_tokenization_enabled
    }

    static String tokenize(T_static_string i_msg_text, Object... i_traces = null) {
        Integer l_trace_seqno = 0
        String l_exception_text = i_msg_text.toString()
        if (p_is_tokenization_enabled) {
            l_exception_text = l_exception_text.replace(PC_MESSAGE_FORMAT_TOKEN_SPACE, " ")
            for (Object l_runtime_trace in i_traces) {
                l_trace_seqno++
                l_exception_text = l_exception_text.replace(PC_MESSAGE_FORMAT_TOKEN_TRACE + l_trace_seqno.toString(), l_runtime_trace.toString())
            }
        }
        return l_exception_text
    }

    E_application_exception(T_static_string i_msg_text, Object... i_traces = null) {
        super(tokenize(i_msg_text, i_traces))
        if (i_traces != null) {
            p_traces = new ArrayList<Object>(Arrays.asList(i_traces))
        }
    }

    @Override
    String toString() {
        String l_exception_text = ""
        Throwable sanitizedThrowable
        sanitizedThrowable = new StackTraceUtils().sanitizeRootCause(this)
        l_exception_text += this.getClass().getName() + "," + this.getMessage() + System.lineSeparator()
        l_exception_text += Arrays.toString(sanitizedThrowable.getStackTrace()).replace(",", System.lineSeparator() + "at")
        return l_exception_text
    }

    ArrayList<Object> get_traces() {
        return p_traces
    }

}
