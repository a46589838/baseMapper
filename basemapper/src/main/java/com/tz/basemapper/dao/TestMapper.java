package com.tz.basemapper.dao;

import com.tz.basemapper.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: TestMapper
 * @description:
 * @author: Mr.Lin
 * @create: 2019-05-03 15:45
 * @version: 1.0
 **/
@Mapper
public interface TestMapper extends BaseMapper<User> {
}
