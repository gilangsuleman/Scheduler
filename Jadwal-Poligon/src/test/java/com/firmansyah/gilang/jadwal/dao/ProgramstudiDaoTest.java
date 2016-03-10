/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.dao;

import com.firmansyah.gilang.jadwal.App;
import com.firmansyah.gilang.jadwal.entity.Programstudi;
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
@Sql(scripts = {"/mysql/delete-data.sql", "/mysql/sample-prodi.sql"})
public class ProgramstudiDaoTest {

    @Autowired
    private ProgramstudiDao programstudiDao;

    @Test
    public void saveTest() {
        Programstudi p = new Programstudi();
        p.setId("abc");
        p.setNama("Teknik Informatika");
        p.setSingkatan("TI");
        p.setKetua("Ismail Mohidin");
        programstudiDao.save(p);
        Assert.assertNotNull(p.getId());
    }

    @Test
    public void cariById() {
        Programstudi p = programstudiDao.findOne("abc");
        
        Assert.assertNotNull(p);
        Assert.assertEquals("Teknik Informatika", p.getNama());
        Assert.assertEquals("TI", p.getSingkatan());
        Assert.assertEquals("Ismail Mohidin", p.getKetua());
        
        Assert.assertNotNull(programstudiDao.findOne("abc"));
    }
}
