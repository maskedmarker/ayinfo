package org.cjh.ayinfo.test;

import java.util.HashMap;
import java.util.Map;

import org.cjh.ayinfo.model.ui.UIEmployeePaginationQuery;
import org.springframework.beans.BeanUtils;

public class BeanPropertyCopyUtilTest {

    public static void main(String[] args) {
        UIEmployeePaginationQuery src = new UIEmployeePaginationQuery();
        src.setPage(1);
        src.setRows(10);
        src.setEmployeeName("zhansan");
        src.setExpectedPayMin(4000.0);
        src.setExpectedPayMax(9000.0);
        Map<String, Object> target = new HashMap<>();
        BeanUtils.copyProperties(src, target);
        System.out.println(target);
    }
}
