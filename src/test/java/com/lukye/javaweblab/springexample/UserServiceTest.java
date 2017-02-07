package com.lukye.javaweblab.springexample;

import com.lukye.javaweblab.springexample.model.User;
import com.lukye.javaweblab.springexample.service.UserService;
import org.apache.ibatis.transaction.Transaction;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
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

    private User createUserInstance()
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
    @Transactional()
    public void D_testTransaction()
    {
        User user = createUserInstance();

        // This code is useless
        // Link: http://docs.spring.io/spring/docs/3.0.5.RELEASE/reference/testing.html#testing-tx
        // One common issue in tests that access a real database is their affect on the state of the persistence store.
        // Even when you're using a development database, changes to the state may affect future tests.
        // Also, many operations - such as inserting or modifying persistent data - cannot be performed (or verified) outside a transaction.
        // The TestContext framework addresses this issue. By default, the framework will create and roll back a transaction for each test.
        // You simply write code that can assume the existence of a transaction. If you call transactionally proxied objects in your tests, they will behave correctly, according to their transactional semantics. In addition, if test methods delete the contents of selected tables while running within a transaction, the transaction will roll back by default, and the database will return to its state prior to execution of the test. Transactional support is provided to your test class via a PlatformTransactionManager bean defined in the test's application context.
        user.setName("1");
        userService.insert(user);

        // Do real transaction failure test
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
