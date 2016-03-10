/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.dao;

import com.firmansyah.gilang.jadwal.App;
import com.firmansyah.gilang.jadwal.entity.Semester;
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
@Sql(scripts = {"/mysql/delete-data.sql", "/mysql/sample-semester.sql"})
public class SemesterDaoTest {
    @Autowired
    private SemesterDao semesterDao;
    
    @Test
    public void saveTest(){
        Semester s = new Semester();
        s.setId("011");
        s.setTingkat("I");
        semesterDao.save(s);
        Assert.assertNotNull(s.getId());
    }
    
    @Test
    public void cariById(){
        Semester s = semesterDao.findOne("011");
        
        Assert.assertNotNull(s);
        Assert.assertEquals("I", s.getTingkat());
        
        Assert.assertNotNull(semesterDao.findOne("011"));
    }
}
