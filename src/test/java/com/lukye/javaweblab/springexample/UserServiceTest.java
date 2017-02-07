package com.lukye.javaweblab.springexample;

import com.lukye.javaweblab.springexample.model.User;
import com.lukye.javaweblab.springexample.service.UserService;
import org.apache.ibatis.transaction.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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

    User createUserInstance()
    {
        User user = new User();
        user.setName(NAME);
        user.setPassword(NAME);
        user.setBirthday(new Date());
        user.setCreated(new Date());
        user.setUpdated(new Date());
        user.setUsername(NAME);
        return user;
    }

    @Test
    public void A_testInsert()
    {
        userService.insert(createUserInstance());

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

    @Test
    @Transactional
    public void D_testTransaction()
    {
        User user = createUserInstance();
        user.setName("1");
        userService.insert(user);

        try
        {
            user.setName("2");
            userService.insert(user);

            user.setName("3");
            userService.insert(user);

            user.setName(null);
            userService.insert(user);
        }
        catch (Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
}
