package com.a9ae0b01f0ffc.commons.implementation.main

import com.a9ae0b01f0ffc.commons.implementation.config.T_common_conf
import com.a9ae0b01f0ffc.commons.implementation.exceptions.E_application_exception
import com.a9ae0b01f0ffc.commons.implementation.static_string.T_static_string

import java.text.SimpleDateFormat

abstract class T_common_base_3_utils extends T_common_base_2_context {

    static final Boolean method_arguments_present(Object i_args) {
        if (i_args != GC_SKIPPED_ARGS && i_args != GC_NULL_OBJ_REF) {
            if (i_args instanceof Collection) {
                if (i_args.size() > GC_EMPTY_SIZE) {
                    return GC_TRUE
                } else {
                    return GC_FALSE
                }
            } else if (i_args instanceof Object[]) {
                if (i_args.length > GC_EMPTY_SIZE) {
                    return GC_TRUE
                } else {
                    return GC_FALSE
                }
            } else {
                return GC_FALSE
            }
        } else {
            return GC_FALSE
        }
    }

    static
    final String tokenize(T_static_string i_msg_text, String i_token_space, String i_token_trace, List<Object> i_traces = GC_SKIPPED_ARGS) {
        if (method_arguments_present(i_traces)) {
            Integer l_trace_seqno = GC_ZERO
            String l_text = i_msg_text.toString()
            l_text = l_text.replace(i_token_space, GC_SPACE)
            for (Object l_runtime_trace in i_traces) {
                l_trace_seqno++
                l_text = l_text.replace(i_token_trace + l_trace_seqno.toString(), l_runtime_trace.toString())
            }
            return l_text
        } else {
            return i_msg_text.toString()
        }
    }

    static final String d2s(Date i_date, String i_format) {
        String l_result_string = GC_EMPTY_STRING
        if (i_date != GC_NULL_OBJ_REF) {
            SimpleDateFormat l_simple_date_format = new SimpleDateFormat(i_format)
            l_result_string = l_simple_date_format.format(i_date)
        }
        l_result_string = l_result_string.padRight(Math.max(i_format.length(), l_result_string.length()), GC_SPACE)
        return l_result_string
    }

    static final Date s2d(String i_date, String i_format) {
        final Integer LC_NOT_EXISTS = -1
        String l_format = i_format
        String l_date = nvl(i_date, new Date())
        Date l_result_date
        if (l_format.toLowerCase().indexOf(PC_YYYY) == LC_NOT_EXISTS) {
            l_format += PC_YYYY
            l_date += d2s(new Date(), PC_YYYY)
        } else if (l_format.toLowerCase().indexOf(PC_YY) == LC_NOT_EXISTS) {
            l_format += PC_YY
            l_date += d2s(new Date(), PC_YY)
        }
        if (l_date != GC_NULL_OBJ_REF) {
            SimpleDateFormat l_simple_date_format = new SimpleDateFormat(l_format)
            l_result_date = l_simple_date_format.parse(l_date)
        } else {
            throw new E_application_exception(s.UNABLE_TO_CONVERT_TEXT_Z1_TO_DATE_Z2, i_date, i_format)
        }
        return l_result_date
    }

    static final String process_location(String i_location, T_common_conf i_commons) {
        Date l_current_date = new Date()
        String l_location = i_location
        l_location = l_location.replaceAll(i_commons.GC_SUBST_USERNAME, GC_USERNAME)
        l_location = l_location.replaceAll(i_commons.GC_SUBST_DATE, l_current_date.format(i_commons.GC_FILENAME_DATE_FORMAT))
        l_location = l_location.replaceAll(i_commons.GC_SUBST_TIME, l_current_date.format(i_commons.GC_FILENAME_TIME_FORMAT))
        l_location = l_location.replaceAll(i_commons.GC_SUBST_THREADID, i_commons.GC_THREADID)
        l_location = l_location.replaceAll(i_commons.GC_SUBST_THREADNAME, i_commons.GC_THREADNAME)
        l_location = l_location.replaceAll(i_commons.GC_SUBST_PROCESSID, GC_PROCESSID)
        return l_location
    }

    static final FileWriter init_file(String i_location) {
        File l_file = GC_NULL_OBJ_REF as File
        FileWriter l_file_writer = GC_NULL_OBJ_REF as FileWriter
        String l_location = process_location(i_location, c())
        l_file = new File(l_location)
        l_file.getParentFile().mkdirs()
        l_file_writer = new FileWriter(l_file, GC_FILE_APPEND_YES)
        return l_file_writer
    }

    static Boolean like(String i_str, String i_expr) {
        return (i_str.contains(i_expr) || i_str.startsWith(i_expr) || i_str.endsWith(i_expr))
    }

    static final String bytes_to_string(byte[] i_bytes) {
        //ANDing with 0x00FF retains only the last 8 significant bits and zeros others bits
        StringBuilder l_result_string = new StringBuilder()
        String l_hex_string = GC_EMPTY_STRING
        for (byte l_byte : i_bytes) {
            l_hex_string = Integer.toHexString(GC_FULL_BYTE & l_byte)
            l_result_string.append(l_hex_string.length() == GC_ONE_CHAR ? GC_ZERO + l_hex_string : l_hex_string)
        }
        return l_result_string.toString()
    }

    static final Object coalesce(Object... i_objects = GC_SKIPPED_ARGS) {
        Object l_last_object = GC_NULL_OBJ_REF
        if (method_arguments_present(i_objects)) {
            for (Object l_object : i_objects) {
                if (is_not_null(l_object)) {
                    return l_object
                } else {
                    l_last_object = l_object
                }
            }
            return l_last_object
        } else {
            return GC_NULL_OBJ_REF
        }
    }

    static final Object nvl(Object i_primary_object, Object i_backup_object) {
        Object l_result_object
        if (is_null(i_primary_object)) {
            l_result_object = i_backup_object
        } else {
            l_result_object = i_primary_object
        }
        return l_result_object
    }

    static final String get_short_name(String i_class_name) {
        String l_short_name = GC_EMPTY_STRING
        if (i_class_name.contains(GC_POINT)) {
            l_short_name = i_class_name.substring(i_class_name.lastIndexOf(GC_POINT) + GC_ONE_CHAR)
        } else {
            l_short_name = i_class_name
        }
        return l_short_name
    }

    static Boolean is_null(Object i_object) {
        if (i_object == GC_NULL_OBJ_REF || i_object == GC_EMPTY_STRING) {
            return GC_TRUE
        } else {
            return GC_FALSE
        }
    }

    static Boolean is_not_null(Object i_object) {
        return !is_null(i_object)
    }

}
