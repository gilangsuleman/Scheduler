/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.dao;

import com.firmansyah.gilang.jadwal.App;
import com.firmansyah.gilang.jadwal.entity.Kelas;
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
@Sql(scripts = {"/mysql/delete-data.sql", "/mysql/sample-kelas.sql"})
public class KelasDaoTest {

    @Autowired
    private KelasDao kelasDao;

    @Test
    public void saveTest() {
        Kelas k = new Kelas();
        k.setId("456");
        k.setNama("A");
        kelasDao.save(k);
        Assert.assertNotNull(k.getId());
    }

    @Test
    public void cariById() {
        Kelas k = kelasDao.findOne("456");

        Assert.assertNotNull(k);
        Assert.assertEquals("A", k.getNama());

        Assert.assertNotNull(kelasDao.findOne("456"));

    }
}
