/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.dao;

import com.firmansyah.gilang.jadwal.entity.Kelas;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author gilang
 */
public interface KelasDao extends PagingAndSortingRepository<Kelas, String> {
    
}
