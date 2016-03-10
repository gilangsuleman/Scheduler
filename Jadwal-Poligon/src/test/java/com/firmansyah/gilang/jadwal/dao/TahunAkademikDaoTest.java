/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.dao;

import com.firmansyah.gilang.jadwal.App;
import com.firmansyah.gilang.jadwal.entity.TahunAkademik;
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
@Sql(scripts = {"/mysql/delete-data.sql", "/mysql/sample-tahunakademik.sql"})
public class TahunAkademikDaoTest {
    
    @Autowired
    private TahunAkademikDao tahunAkademikDao;
    
    @Test
    public void saveTest(){
        TahunAkademik t= new TahunAkademik();
        t.setId("cde");
        t.setTahun("2016a");
        tahunAkademikDao.save(t);
        Assert.assertNotNull(t.getId());
    }
    
    @Test
    public void cariById(){
        TahunAkademik t = tahunAkademikDao.findOne("cde");
        
        Assert.assertNotNull(t);
        Assert.assertEquals("2016a", t.getTahun());
        
        Assert.assertNotNull(tahunAkademikDao.findOne("cde"));
    }
}
