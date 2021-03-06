/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmansyah.gilang.jadwal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author gilang
 */
@Entity
public class Dosen {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @NotNull @NotEmpty
    @Column(nullable=false)
    private String nama;
    
    @NotNull @NotEmpty
    @Column(nullable=false)
    private String nip;
    
    @NotNull @NotEmpty
    @Column(nullable=false)
    private String nipy;
    
    @NotNull @NotEmpty
    @Column(nullable=false)
    private String hp;
    
    @NotNull @NotEmpty
    @Column(nullable=false, unique=true)
    private String email;
    
    @NotNull @NotEmpty
    @Column(nullable=false)
    private String alamat;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNipy() {
        return nipy;
    }

    public void setNipy(String nipy) {
        this.nipy = nipy;
    }
}
