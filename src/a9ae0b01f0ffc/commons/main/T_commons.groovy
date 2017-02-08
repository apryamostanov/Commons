package a9ae0b01f0ffc.commons.main

import a9ae0b01f0ffc.commons.config_helper.T_conf
import groovy.transform.PackageScope

@PackageScope
class T_commons {

    static T_conf GC_CONST_CONF = T_const.GC_NULL_OBJ_REF as T_conf
    static String GC_DATETIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss:SSS"
    static String GC_FILENAME_DATE_FORMAT = "yyyyMMdd"
    static String GC_FILENAME_TIME_FORMAT = "HHmmssSSS"
    static String GC_CLASS_LOADER_CONF_FILE_NAME = T_const.GC_EMPTY_STRING
    static String GC_MESSAGE_FORMAT_TOKEN_SEPARATOR_BEFORE = "_"
    static String GC_MESSAGE_FORMAT_TOKEN_SEPARATOR_AFTER = " "
    static String GC_MESSAGE_FORMAT_TOKEN_TRACE = "Z"
    static String GC_SUBST_USERNAME = "%USERNAME%"
    static String GC_SUBST_DATE = "%DATE%"
    static String GC_SUBST_TIME = "%TIME%"
    static String GC_SUBST_THREADID = "%THREADID%"
    static String GC_SUBST_PROCESSID = "%PROCESSID%"

    static void init_custom(String i_conf_file_name) {
        GC_CONST_CONF = new T_conf(i_conf_file_name)
        GC_DATETIMESTAMP_FORMAT = GC_CONST_CONF.GC_LOG_DATETIMESTAMP_FORMAT(GC_DATETIMESTAMP_FORMAT)
        GC_FILENAME_DATE_FORMAT = GC_CONST_CONF.GC_LOG_FILENAME_DATE_FORMAT(GC_FILENAME_DATE_FORMAT)
        GC_FILENAME_TIME_FORMAT = GC_CONST_CONF.GC_LOG_FILENAME_TIME_FORMAT(GC_FILENAME_TIME_FORMAT)
        GC_CLASS_LOADER_CONF_FILE_NAME = GC_CONST_CONF.GC_CLASS_LOADER_CONF_FILE_NAME(GC_CLASS_LOADER_CONF_FILE_NAME)
        GC_MESSAGE_FORMAT_TOKEN_SEPARATOR_BEFORE = GC_CONST_CONF.GC_MESSAGE_FORMAT_TOKEN_SEPARATOR_BEFORE(GC_MESSAGE_FORMAT_TOKEN_SEPARATOR_BEFORE)
        GC_MESSAGE_FORMAT_TOKEN_SEPARATOR_AFTER = GC_CONST_CONF.GC_MESSAGE_FORMAT_TOKEN_SEPARATOR_AFTER(GC_MESSAGE_FORMAT_TOKEN_SEPARATOR_AFTER)
        GC_MESSAGE_FORMAT_TOKEN_TRACE = GC_CONST_CONF.GC_MESSAGE_FORMAT_TOKEN_TRACE(GC_MESSAGE_FORMAT_TOKEN_TRACE)
        GC_SUBST_USERNAME = GC_CONST_CONF.GC_SUBST_USERNAME(GC_SUBST_USERNAME)
        GC_SUBST_DATE = GC_CONST_CONF.GC_SUBST_DATE(GC_SUBST_DATE)
        GC_SUBST_TIME = GC_CONST_CONF.GC_SUBST_TIME(GC_SUBST_TIME)
        GC_SUBST_THREADID = GC_CONST_CONF.GC_SUBST_THREADID(GC_SUBST_THREADID)
        GC_SUBST_PROCESSID = GC_CONST_CONF.GC_SUBST_PROCESSID(GC_SUBST_PROCESSID)
    }
}
