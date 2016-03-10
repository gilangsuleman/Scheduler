/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.dao;

import com.firmansyah.gilang.jadwal.App;
import com.firmansyah.gilang.jadwal.entity.Dosen;

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
@Sql(scripts = {"/mysql/delete-data.sql", "/mysql/sample-dosen.sql"})
public class DosenDaoTest {

    @Autowired
    private DosenDao dosenDao;

    @Test
    public void saveTest() {
        Dosen d = new Dosen();
        d.setId("012");
        d.setNama("ismail mohidin");
        d.setNip("123456789");
        d.setNipy("abcdefghijk");
        d.setEmail("is.mohidin@gmail.com");
        d.setAlamat("isimu");
        d.setHp("081234567");
        dosenDao.save(d);
        Assert.assertNotNull(d.getId());
    }

    public void cariById() {
        Dosen d=dosenDao.findOne("012");
        
        Assert.assertNotNull(d);
        Assert.assertEquals("ismail mohidin", d.getNama());
        Assert.assertEquals("123456789", d.getNip());
        Assert.assertEquals("abcdefghijk", d.getNipy());
        Assert.assertEquals("is.mohidin@gmail.com", d.getEmail());
        Assert.assertEquals("isimu", d.getAlamat());
        Assert.assertEquals("081234567", d.getHp());
        
        Assert.assertNotNull(dosenDao.findOne("012"));
    }
}
