package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.UserModelApplication;
import com.lambdaschool.usermodel.models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplUnitTest
{
    @Autowired
    UserService userService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void findUserById()
    {
        assertEquals("admin", userService.findUserById(4).getUsername());
    }

    @Test
    public void findByNameContaining()
    {
        assertEquals(1, userService.findByNameContaining("ad").size());
    }

    @Test
    public void findAll()
    {
        assertEquals(5, userService.findAll().size());
    }

    @Test
    public void z_delete()
    {
        userService.delete(4);
        assertEquals(5, userService.findAll().size());
    }

    @Test
    public void findByName()
    {
        assertEquals("admin", userService.findByName("admin").getUsername());
    }

    @Test
    public void save()
    {
        String u6Name = "brandon";
        User u6 = new User("brandon",
            "password",
            "brandon@lambdaschool.com");

        User addUser = userService.save(u6);
        assertNotNull(addUser);
        assertEquals(u6Name, addUser.getUsername());
    }

    @Test
    public void update()
    {
        String u7Name = "randi";
        User u7 = new User("randi",
            "password",
            "randi@lambdaschool.com");

        User editUser = userService.update(u7, 11);
        assertNotNull(editUser);
        assertEquals(u7Name, editUser.getUsername());
    }

    @Test
    public void zz_deleteAll()
    {
        userService.deleteAll();
        assertEquals(0, userService.findAll().size());
    }
}