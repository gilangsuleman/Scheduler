/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.dao;

import com.firmansyah.gilang.jadwal.entity.Matakuliah;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author gilang
 */
public interface MatakuliahDao extends PagingAndSortingRepository<Matakuliah, String> {
    
}
