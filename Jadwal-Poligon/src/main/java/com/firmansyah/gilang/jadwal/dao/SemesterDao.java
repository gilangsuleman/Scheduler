/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.dao;

import com.firmansyah.gilang.jadwal.entity.Semester;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author gilang
 */
public interface SemesterDao extends PagingAndSortingRepository<Semester, String> {
    
}
