package com.a9ae0b01f0ffc.commons.implementation.round_robin

import com.a9ae0b01f0ffc.commons.implementation.exceptions.E_application_exception
import com.a9ae0b01f0ffc.commons.implementation.main.T_common_base_3_utils

class T_round_robin<T_type> extends T_common_base_3_utils implements Iterable<T_type> {

    private List<T_type> p_list
    private Integer lp_index = GC_ZERO

    T_round_robin(List<T_type> i_list) {
        p_list = i_list
    }

    @Override
    Iterator<T_type> iterator() {
        return new Iterator<T_type>() {

            @Override
            boolean hasNext() {
                return GC_TRUE
            }

            @Override
            T_type next() {
                T_type l_result = p_list.get(lp_index)
                lp_index = ((lp_index + GC_ONE_ONLY) % p_list.size())
                return l_result
            }

            @Override
            void remove() {
                throw new E_application_exception(s.Unable_to_remove_from_Round_Robin)
            }

        }
    }

}