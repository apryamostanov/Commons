package com.a9ae0b01f0ffc.commons.main

import com.a9ae0b01f0ffc.commons.static_string.T_static_string_builder

import java.lang.management.ManagementFactory

abstract class T_common_const {

    static final Object GC_NULL_OBJ_REF = null as Object
    static final Collection<Object> GC_SKIPPED_ARGS = new ArrayList<Object>()
    static final String GC_EMPTY_STRING = ""
    static final String GC_AT_CHAR = "@"
    static final String GC_COMMA = ","
    static final String GC_COLON = ":"
    static final Integer GC_EMPTY_SIZE = 0
    static final Integer GC_FIRST_INDEX = 0
    static final Integer GC_FIRST_CHAR = 0
    static final String GC_NEW_LINE = System.lineSeparator()
    static final String GC_PATH_SEPARATOR = File.separator
    static final String GC_POINT = "."
    static final Integer GC_ONE_CHAR = 1
    static final Integer GC_ONE_ONLY = 1
    static final Boolean GC_TRUE = true
    static final Boolean GC_FALSE = false
    static final Integer GC_ZERO = 0
    static final Boolean GC_FILE_APPEND_YES = GC_TRUE
    static final String GC_USERNAME = System.getProperty("user.name")
    static final String GC_PROCESSID = ManagementFactory.getRuntimeMXBean().getName().substring(GC_FIRST_CHAR, ManagementFactory.getRuntimeMXBean().getName().indexOf(GC_AT_CHAR))//When Java 9 comes: ProcessHandle.current().getPid()
    static final T_static_string_builder GC_STATIC_STRING_BUILDER = new T_static_string_builder()
    static final String GC_FALSE_STRING = "false"
    static final String GC_TRUE_STRING = "true"
    static final String GC_SPACE = " "
    static final Integer GC_FULL_BYTE = 0x00FF
    static final String GC_XML_LESS = "<"
    static final String GC_XML_GREATER = ">"
    static final String GC_XML_QUOTE = "'"
    static final String GC_XML_DOUBLE_QUOTE = "\""
    static final String GC_XML_AMP = "&"
    static final String GC_XML_CDATA_OPEN = "<![CDATA["
    static final String GC_XML_CDATA_CLOSE = "]]>"
    static final Integer GC_HTTP_RESP_CODE_OK = 200
    static final String GC_UNDERSCORE = "_"

}
