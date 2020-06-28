package com.fengfang.mybatis.io;

import java.io.InputStream;

/**
 * TODO
 *使用类加载器读取配置文件类
 * @author liuxh
 * @date 2020/6/28 22:56
 **/
public class Resources {
    /**
     * 根据传入的参数获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
