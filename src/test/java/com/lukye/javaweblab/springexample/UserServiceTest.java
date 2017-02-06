package com.lukye.javaweblab.springexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/context.xml"})
public class UserServiceTest {
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

    }
}
