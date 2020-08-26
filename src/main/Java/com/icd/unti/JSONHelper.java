package com.icd.unti;

import com.alibaba.fastjson.JSON;


/**
 * @author 李耀华
 * @since 2020年7月8日
 * Json序列化工具类
 */

public class JSONHelper {
	private static final String DEFAULT_CHARSET_NAME = "UTF-8";

	public static <T> String serialize(T object) {
		return JSON.toJSONString(object);
	}

	public static <T> T deserialize(String string, Class<T> clz) {
		return JSON.parseObject(string, clz);
	}
}
