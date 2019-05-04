package com.tz.basemapper.controller;

import com.tz.basemapper.dao.TestMapper;
import com.tz.basemapper.model.User;
import com.tz.basemapper.service.TestService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: TestController
 * @description:
 * @author: Mr.Lin
 * @create: 2019-05-03 15:12
 * @version: 1.0
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "用户详情", notes = "根据用户id查询用户详情")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/user/{id:^\\d+$}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return testService.getUser(id);
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(Long id) {
        return "success";
    }
}
