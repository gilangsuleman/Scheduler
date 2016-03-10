/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.dao;

import com.firmansyah.gilang.jadwal.App;
import com.firmansyah.gilang.jadwal.entity.lab;
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
@Sql(scripts = {"/mysql/delete-data.sql", "/mysql/sample-lab.sql"})
public class labDaoTest {
    
    @Autowired
    private labDoa doa;
    
    @Test
    public void saveTest(){
        lab l = new lab();
        l.setId("asd");
        l.setNama("MM");
        doa.save(l);
        Assert.assertNotNull(l.getId());
    }
    
    @Test
    public void cariById(){
        lab l = doa.findOne("asd");
        
        Assert.assertNotNull(l);
        Assert.assertEquals("MM", l.getNama());
        
        Assert.assertNotNull(doa.findOne("asd"));
    }
}
