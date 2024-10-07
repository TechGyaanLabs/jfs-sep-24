package com.careerit.cj.day15;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AppUtil {
    public static String maskStr(String data) {
        if (StringUtils.isNoneEmpty(data)) {
            if (data.length() > 4) {
                return "********" + data.substring(data.length() - 4);
            } else {
                return data;
            }
        }
        return "";
    }

    public static String properName(String name) {
        if (StringUtils.isNotEmpty(name)) {
            return name.trim().toUpperCase();
        }
        return name;
    }

    public static List<String> convertProperNames(List<String> names) {
        List<String> list = new ArrayList<>();
        for (String name : names) {
            list.add(properName(name));
        }
        return list;
    }

    public static List<String> combineNames(List<String> nameList1, List<String> nameList2) {
        List<String> pList1 = convertProperNames(nameList1);
        List<String> pList2 = convertProperNames(nameList2);

        List<String> tempList = new ArrayList<>();
        tempList.addAll(pList1);
        tempList.addAll(pList2);
        return tempList;
    }
}
