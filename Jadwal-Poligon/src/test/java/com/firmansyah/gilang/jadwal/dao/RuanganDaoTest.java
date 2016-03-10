/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.dao;

import com.firmansyah.gilang.jadwal.App;
import com.firmansyah.gilang.jadwal.entity.Ruangan;
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
@Sql(scripts = {"/mysql/delete-data.sql", "/mysql/sample-ruangan.sql"})
public class RuanganDaoTest {

    @Autowired
    private RuanganDao ruanganDao;

    @Test
    public void saveTest() {
        Ruangan r = new Ruangan();
        r.setId("efg");
        r.setNama("lab software");
        r.setKapasitas("25");
        ruanganDao.save(r);
        Assert.assertNotNull(r.getId());
    }

    @Test
    public void cariById() {
        Ruangan r = ruanganDao.findOne("efg");

        Assert.assertNotNull(r);
        Assert.assertEquals("lab software", r.getNama());
        Assert.assertEquals("25", r.getKapasitas());

        Assert.assertNotNull(ruanganDao.findOne("efg"));
    }
}
