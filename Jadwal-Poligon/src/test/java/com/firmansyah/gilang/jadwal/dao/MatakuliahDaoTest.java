/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.dao;

import com.firmansyah.gilang.jadwal.App;
import com.firmansyah.gilang.jadwal.entity.Matakuliah;
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
@Sql(scripts = {"/mysql/delete-data.sql", "/mysql/sample-matakuliah.sql"})
public class MatakuliahDaoTest {
    @Autowired
    private MatakuliahDao matakuliahDao;
    
    @Test
    public void saveTest(){
        Matakuliah m=new Matakuliah();
        m.setId("234");
        m.setKode("00-11");
        m.setNama("Proyek Akhir");
        m.setSks("4");
        m.setProdi("Teknik Informatika");
        m.setJam("4");
        matakuliahDao.save(m);
        Assert.assertNotNull(m.getId());
    }
    @Test
    public void cariById(){
        Matakuliah m=matakuliahDao.findOne("234");
        
        Assert.assertEquals("00-11", m.getKode());
        Assert.assertEquals("Proyek Akhir", m.getNama());
        Assert.assertEquals("4", m.getSks());
        Assert.assertEquals("Teknik Informatika", m.getProdi());
        Assert.assertEquals("4", m.getJam());
        
        Assert.assertNotNull(matakuliahDao.findOne("234"));
    }
}
