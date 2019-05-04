package com.tz.basemapper.dao;


import com.tz.basemapper.config.provider.BaseSqlProvider;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @className: BaseMapper
 * @description:
 * @author: Mr.Lin
 * @create: 2019-05-03 15:25
 * @version: 1.0
 **/
public interface BaseMapper<T> {

//    @SelectProvider(method = "count", type = BaseSqlProvider.class)
//    Long count(T t);

    @SelectProvider(method = "get", type = BaseSqlProvider.class)
    T get(T t);
}
