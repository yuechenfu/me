/**********************************************************************************************
 * Copyright (c) 2018 Hiveel.com
 * All rights reserved
 **********************************************************************************************/

package com.pib.admin.util;

/**
* 檢查Cached Key格式.
* @author weiceng1sheng
*/
public class CacheKeyUtil {
	
    private CacheKeyUtil() {
    }

    /**
     * 檢查Cached Key格式
     * @param key Cached Key
	 * @return 返回Cached Key，即便Key是空值或長度等於0；如果長度超過或等於250則只取249長度
     */    
    public static String checkKey(String key) {
        if (key == null || key.trim().length() <= 0) {
            return key;
        }

        key = key.trim();
        if (key.length() >= 250) {
            return key.substring(0, 249);
        }
        return key;
    }
}
