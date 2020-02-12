package com.arnold.febs.common.utils;

//import com.arnold.febs.common.exception.CheckException;
import com.arnold.febs.common.exception.FebsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * 校验工具类
 * 
 * @author 肖文杰 https://xwjie.github.io/PLMCodeTemplate/
 *
 */
@Component
public class CheckUtil {
	private static MessageSource resources;

	@Autowired
	public void setResources(@Qualifier("messageSource") MessageSource resources) {
		CheckUtil.resources = resources;
	}

	public static void check(boolean condition, String msgKey, Object... args) {
		if (!condition) {
			fail(msgKey, args);
		}
	}

	public static void notEmpty(String str, String msgKey, Object... args) {
		if (str == null || str.isEmpty()) {
			fail(msgKey, args);
		}
	}

	public static void notNull(Object obj, String msgKey, Object... args) {
		if (obj == null) {
			fail(msgKey, args);
		}
	}

	private static void fail(String msgKey, Object... args) {
		throw new FebsException(resources.getMessage(msgKey, args, LocaleContextHolder.getLocale()));
	}
}