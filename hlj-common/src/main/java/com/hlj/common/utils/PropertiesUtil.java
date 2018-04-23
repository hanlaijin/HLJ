package com.hlj.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by hanlaijin@xiaomi.com on 17-10-20.
 */
public class PropertiesUtil {
    public static String getValue(String fileName, String key){
        InputStream fileInputStream = null;
        try {
            fileInputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String value = properties.getProperty(key);
            return value.trim();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public static Map<String, String> getValues(String fileName){
        Map<String, String> map = new HashMap<>();
        InputStream fileInputStream = null;
        try {
            fileInputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            for (Object key : properties.keySet()) {
                String value = properties.getProperty(key.toString());
                map.put(key.toString(), value);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
