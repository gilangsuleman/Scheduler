/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.dao;

import com.firmansyah.gilang.jadwal.App;
import com.firmansyah.gilang.jadwal.entity.User;
import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author gilang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional
@Sql(scripts = {"/mysql/delete-data.sql", "/mysql/sample-user.sql"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSave() {
        User u = new User();
        u.setId("123");
        u.setUsername("gilang");
        u.setEmail("gilang@gmail.com");
        u.setFullname("gilang suleman");
        userDao.save(u);
        Assert.assertNotNull(u.getId());
    }

    @Test
    public void cariById() {
        User u = userDao.findOne("123");

        Assert.assertNotNull(u);
        Assert.assertEquals("gilang", u.getUsername());
        Assert.assertEquals("gilang@gmail.com", u.getEmail());
        Assert.assertEquals("gilang suleman", u.getFullname());

        Assert.assertNotNull(userDao.findOne("123"));
    }
}
