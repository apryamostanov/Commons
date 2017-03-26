package com.a9ae0b01f0ffc.commons.implementation.main

import com.a9ae0b01f0ffc.commons.implementation.static_string.T_static_string_builder

import java.lang.management.ManagementFactory

abstract class T_common_base_1_const extends T_common_base_0_uid{

    public static final T_static_string_builder s = new T_static_string_builder()
    public static final Object GC_NULL_OBJ_REF = null as Object
    public static final Collection<Object> GC_SKIPPED_ARGS = new ArrayList<Object>()
    public static final String GC_EMPTY_STRING = ""
    public static final String GC_AT_CHAR = "@"
    public static final String GC_COMMA = ","
    public static final String GC_COLON = ":"
    public static final Integer GC_EMPTY_SIZE = 0
    public static final Integer GC_FIRST_INDEX = 0
    public static final Integer GC_SECOND_INDEX = 1
    public static final Integer GC_FIRST_CHAR = 0
    public static final String GC_NEW_LINE = System.lineSeparator()
    public static final String GC_PATH_SEPARATOR = File.separator
    public static final String GC_POINT = "."
    public static final Integer GC_ONE_CHAR = 1
    public static final Integer GC_ONE_ONLY = 1
    public static final Integer GC_TWO_ONLY = 2
    public static final Integer GC_CHAR_INDEX_NOT_EXISTING = -1
    public static final Boolean GC_TRUE = true
    public static final Boolean GC_FALSE = false
    public static final Integer GC_ZERO = 0
    public static final Boolean GC_FILE_APPEND_YES = GC_TRUE
    public static final String GC_USERNAME = System.getProperty("user.name")
    public static final String GC_PROCESSID = ManagementFactory.getRuntimeMXBean().getName().substring(GC_FIRST_CHAR, ManagementFactory.getRuntimeMXBean().getName().indexOf(GC_AT_CHAR))//When Java 9 comes: ProcessHandle.current().getPid()
    public static final String GC_FALSE_STRING = "false"
    public static final String GC_TRUE_STRING = "true"
    public static final String GC_SPACE = " "
    public static final Integer GC_FULL_BYTE = 0x00FF
    public static final String GC_XML_LESS = "<"
    public static final String GC_XML_GREATER = ">"
    public static final String GC_XML_QUOTE = "'"
    public static final String GC_XML_DOUBLE_QUOTE = "\""
    public static final String GC_XML_AMP = "&"
    public static final String GC_XML_END = "/"
    public static final String GC_XML_CDATA_OPEN = "<![CDATA["
    public static final String GC_XML_CDATA_CLOSE = "]]>"
    public static final Integer GC_HTTP_RESP_CODE_OK = 200
    public static final String GC_UNDERSCORE = "_"
    public static final String GC_EQUALS = "="
    public static final Integer GC_TWO_BYTES = 2
    public static final String PC_YYYY = "yyyy"
    public static final String PC_YY = "yy"
    public static final String GC_BRACKET_OPEN = "("
    public static final String GC_BRACKET_CLOSE = ")"

}
