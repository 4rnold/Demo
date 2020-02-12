package com.arnold.febs.common.utils;

import com.arnold.febs.common.consts.FebsConstant;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FebsUtil {

    public static String view(String viewName) {
        return FebsConstant.VIEW_PREFIX + viewName;
    }
}
