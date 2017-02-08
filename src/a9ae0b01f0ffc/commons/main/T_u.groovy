package a9ae0b01f0ffc.commons.main

import a9ae0b01f0ffc.commons.exceptions.E_application_exception

import java.text.SimpleDateFormat

class T_u {

    static String d2s(Date i_date, String i_format) {
        String l_result_string = T_const.GC_EMPTY_STRING
        if (i_date != T_const.GC_NULL_OBJ_REF) {
            SimpleDateFormat l_simple_date_format = new SimpleDateFormat(i_format)
            l_result_string = l_simple_date_format.format(i_date)
        }
        l_result_string = l_result_string.padRight(Math.max(i_format.length(), l_result_string.length()), T_const.GC_SPACE)
        return l_result_string
    }

    static Date s2d(String i_date, String i_format) {
        final Integer LC_NOT_EXISTS = -1
        String l_format = i_format
        String l_date = T_s.nvl(i_date, new Date())
        Date l_result_date
        if (l_format.toLowerCase().indexOf("yyyy") == LC_NOT_EXISTS) {
            l_format += "yyyy"
            l_date += d2s(new Date(), "yyyy")
        } else if (l_format.toLowerCase().indexOf("yy") == LC_NOT_EXISTS) {
            l_format += "yy"
            l_date += d2s(new Date(), "yy")
        }
        if (l_date != T_const.GC_NULL_OBJ_REF) {
            SimpleDateFormat l_simple_date_format = new SimpleDateFormat(l_format)
            l_result_date = l_simple_date_format.parse(l_date)
        } else {
            throw new E_application_exception(T_s.s().UNABLE_TO_CONVERT_TEXT_Z1_TO_DATE_Z2, i_date, i_format)
        }
        return l_result_date
    }

    static String process_location(String i_location) {
        Date l_current_date = new Date()
        String l_location = i_location
        l_location = l_location.replaceAll(T_s.commons().GC_SUBST_USERNAME, T_s.constants().GC_USERNAME)
        l_location = l_location.replaceAll(T_s.commons().GC_SUBST_DATE, l_current_date.format(T_s.commons().GC_FILENAME_DATE_FORMAT))
        l_location = l_location.replaceAll(T_s.commons().GC_SUBST_TIME, l_current_date.format(T_s.commons().GC_FILENAME_TIME_FORMAT))
        l_location = l_location.replaceAll(T_s.commons().GC_SUBST_THREADID, T_s.constants().GC_THREADID)
        l_location = l_location.replaceAll(T_s.commons().GC_SUBST_PROCESSID, T_s.constants().GC_PROCESSID)
        return l_location
    }

    static FileWriter init_file(String i_location) {
        File l_file = T_s.constants().GC_NULL_OBJ_REF as File
        FileWriter l_file_writer = T_s.constants().GC_NULL_OBJ_REF as FileWriter
        String l_location = process_location(i_location)
        l_file = new File(l_location)
        l_file.getParentFile().mkdirs()
        l_file_writer = new FileWriter(l_file, T_s.constants().GC_FILE_APPEND_YES)
        return l_file_writer
    }

}
