package com.a9ae0b01f0ffc.commons.implementation.main

import com.a9ae0b01f0ffc.commons.interfaces.I_object_with_uid

class T_common_base_0_uid implements I_object_with_uid {

    String p_guid = UUID.randomUUID()

    String get_guid() {
        return p_guid
    }

}
