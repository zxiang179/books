package org.arch.estate;


/**
 * @Author: tianjin@pinduoduo.com
 * @Date: 2021/2/17 9:26 下午
 */
public enum DataSourceTypeEnum {


    HTTP_SOURCE("http"), FILE_SOURCE("file");

    DataSourceTypeEnum(String desc) {
        this.desc = desc;
    }

    public final String desc;

}