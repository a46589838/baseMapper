package com.tz.basemapper.service.impl;

import com.tz.basemapper.dao.TestMapper;
import com.tz.basemapper.model.User;
import com.tz.basemapper.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: TestServiceImpl
 * @description:
 * @author: Mr.Lin
 * @create: 2019-05-03 15:55
 * @version: 1.0
 **/
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public User getUser(Long id) {
        User u = new User();
        u.setId(id);
        return testMapper.get(u);
    }
}
