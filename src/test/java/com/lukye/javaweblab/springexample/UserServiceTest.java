package com.lukye.javaweblab.springexample;

import com.lukye.javaweblab.springexample.model.User;
import com.lukye.javaweblab.springexample.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.StringJoiner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml"})
public class UserServiceTest {
    @Autowired
    private UserService userService;

    private final String NAME = "root";
    private Long id;

    public UserServiceTest()
    {
    }

    @Before
    public void setUp()
    {
    }

    @Test
    public void testInsert()
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
    public void testSelect()
    {
        User user = userService.select(NAME);
    }

    @Test
    public void testDelete()
    {
        User user = userService.select(NAME);
        userService.delete(user.getName());
    }
}
