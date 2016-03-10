/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.dao;

import com.firmansyah.gilang.jadwal.App;
import com.firmansyah.gilang.jadwal.entity.Permission;
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
@Sql(scripts = {"/mysql/delete-data.sql", "/mysql/sample-permission.sql"})
public class PermissionDaoTest {
    
    @Autowired
    private PermissionDao permissionDao;
    
    @Test
    public void testSave() {
        Permission p = new Permission();
        p.setId("001");
        p.setKode("abc");
        p.setNama("thp");
        permissionDao.save(p);
        Assert.assertNotNull(p.getId());
    }
    
    @Test
    public void cariById() {
        Permission p = permissionDao.findOne("001");
        
        Assert.assertNotNull(p);
        Assert.assertEquals("abc", p.getKode());
        Assert.assertEquals("thp", p.getNama());
        
        Assert.assertNotNull(permissionDao.findOne("001"));
    }
}
