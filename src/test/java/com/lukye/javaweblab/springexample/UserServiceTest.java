package com.lukye.javaweblab.springexample;

import com.lukye.javaweblab.springexample.model.User;
import com.lukye.javaweblab.springexample.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    private final String NAME = "root";

    public UserServiceTest()
    {
    }

    @Before
    public void setUp()
    {
    }

    @Test
    public void A_testInsert()
    {
        User user = new User();
        user.setName("root");
        user.setPassword("root");
        user.setBirthday(new Date());
        user.setCreated(new Date());
        user.setUpdated(new Date());
        user.setUsername("Test Insert");
        userService.insert(user);

        Assert.assertNotNull(userService.select(NAME));
    }

    @Test
    public void B_testSelect()
    {
        User user = userService.select(NAME);

        Assert.assertNotNull(user);
    }

    @Test
    public void C_testDelete()
    {
        User user = userService.select(NAME);
        userService.delete(user.getName());

        Assert.assertNull(userService.select(NAME));
    }
}
