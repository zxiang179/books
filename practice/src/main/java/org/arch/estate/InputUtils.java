package org.arch.estate;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author: tianjin@pinduoduo.com
 * @Date: 2021/2/11 10:18 上午
 */
public class InputUtils {

    public static String getFileFromResource() {
        File file = new File("src/main/resources/1.txt");
        String content = null;
        try {
            content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            //
        }
        System.out.println(content);
        return content;
    }

}