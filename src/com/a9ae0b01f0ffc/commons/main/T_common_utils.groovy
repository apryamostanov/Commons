package com.a9ae0b01f0ffc.commons.main

import com.a9ae0b01f0ffc.commons.exceptions.E_application_exception
import com.a9ae0b01f0ffc.commons.static_string.T_static_string

import java.text.SimpleDateFormat

abstract class T_common_utils {

    static final Boolean method_arguments_present(Object[] i_args) {
        return (i_args != T_common_const.GC_SKIPPED_ARGS && i_args != T_common_const.GC_NULL_OBJ_REF && i_args.size() > T_common_const.GC_EMPTY_SIZE)
    }

    static
    final String tokenize(T_static_string i_msg_text, String i_token_space, String i_token_trace, Object... i_traces = T_common_const.GC_SKIPPED_ARGS as Object[]) {
        Integer l_trace_seqno = 0
        String l_exception_text = i_msg_text.toString()
        l_exception_text = l_exception_text.replace(i_token_space, T_common_const.GC_SPACE)
        for (Object l_runtime_trace in i_traces) {
            l_trace_seqno++
            l_exception_text = l_exception_text.replace(i_token_trace + l_trace_seqno.toString(), l_runtime_trace.toString())
        }
        return l_exception_text
    }

    static final String d2s(Date i_date, String i_format) {
        String l_result_string = T_common_const.GC_EMPTY_STRING
        if (i_date != T_common_const.GC_NULL_OBJ_REF) {
            SimpleDateFormat l_simple_date_format = new SimpleDateFormat(i_format)
            l_result_string = l_simple_date_format.format(i_date)
        }
        l_result_string = l_result_string.padRight(Math.max(i_format.length(), l_result_string.length()), T_common_const.GC_SPACE)
        return l_result_string
    }

    static final Date s2d(String i_date, String i_format) {
        final Integer LC_NOT_EXISTS = -1
        final String LC_YYYY = "yyyy"
        final String LC_YY = "yy"
        String l_format = i_format
        String l_date = T_common_shortcuts.nvl(i_date, new Date())
        Date l_result_date
        if (l_format.toLowerCase().indexOf(LC_YYYY) == LC_NOT_EXISTS) {
            l_format += LC_YYYY
            l_date += d2s(new Date(), LC_YYYY)
        } else if (l_format.toLowerCase().indexOf(LC_YY) == LC_NOT_EXISTS) {
            l_format += LC_YY
            l_date += d2s(new Date(), LC_YY)
        }
        if (l_date != T_common_const.GC_NULL_OBJ_REF) {
            SimpleDateFormat l_simple_date_format = new SimpleDateFormat(l_format)
            l_result_date = l_simple_date_format.parse(l_date)
        } else {
            throw new E_application_exception(T_common_shortcuts.s().UNABLE_TO_CONVERT_TEXT_Z1_TO_DATE_Z2, i_date, i_format)
        }
        return l_result_date
    }

    static final String process_location(String i_location) {
        Date l_current_date = new Date()
        String l_location = i_location
        l_location = l_location.replaceAll(T_common_shortcuts.commons().GC_SUBST_USERNAME, T_common_const.GC_USERNAME)
        l_location = l_location.replaceAll(T_common_shortcuts.commons().GC_SUBST_DATE, l_current_date.format(T_common_shortcuts.commons().GC_FILENAME_DATE_FORMAT))
        l_location = l_location.replaceAll(T_common_shortcuts.commons().GC_SUBST_TIME, l_current_date.format(T_common_shortcuts.commons().GC_FILENAME_TIME_FORMAT))
        l_location = l_location.replaceAll(T_common_shortcuts.commons().GC_SUBST_THREADID, T_common_const.GC_THREADID)
        l_location = l_location.replaceAll(T_common_shortcuts.commons().GC_SUBST_PROCESSID, T_common_const.GC_PROCESSID)
        return l_location
    }

    static final FileWriter init_file(String i_location) {
        File l_file = T_common_const.GC_NULL_OBJ_REF as File
        FileWriter l_file_writer = T_common_const.GC_NULL_OBJ_REF as FileWriter
        String l_location = process_location(i_location)
        l_file = new File(l_location)
        l_file.getParentFile().mkdirs()
        l_file_writer = new FileWriter(l_file, T_common_const.GC_FILE_APPEND_YES)
        return l_file_writer
    }

    static Boolean like(String i_str, String i_expr) {
        return (i_str.contains(i_expr) || i_str.startsWith(i_expr) || i_str.endsWith(i_expr))
    }

    static final String bytes_to_string(byte[] i_bytes) {
        //ANDing with 0x00FF retains only the last 8 significant bits and zeros others bits
        StringBuilder l_result_string = new StringBuilder()
        String l_hex_string = T_common_const.GC_EMPTY_STRING
        for (byte l_byte : i_bytes) {
            l_hex_string = Integer.toHexString(T_common_const.GC_FULL_BYTE & l_byte)
            l_result_string.append(l_hex_string.length() == T_common_const.GC_ONE_CHAR ? T_common_const.GC_ZERO + l_hex_string : l_hex_string)
        }
        return l_result_string.toString()
    }

    static final Object coalesce(Object... i_objects = T_common_const.GC_SKIPPED_ARGS) {
        if (method_arguments_present(i_objects)) {
            for (Object l_object : i_objects) {
                if (l_object != T_common_const.GC_NULL_OBJ_REF && l_object != T_common_const.GC_EMPTY_STRING) {
                    return l_object
                }
            }
            return T_common_const.GC_NULL_OBJ_REF
        } else {
            return T_common_const.GC_NULL_OBJ_REF
        }
    }

    static final Object nvl(Object i_primary_object, Object i_backup_object) {
        Object l_result_object
        if (i_primary_object == T_common_const.GC_NULL_OBJ_REF || i_primary_object == T_common_const.GC_EMPTY_STRING) {
            l_result_object = i_backup_object
        } else {
            l_result_object = i_primary_object
        }
        return l_result_object
    }


}
