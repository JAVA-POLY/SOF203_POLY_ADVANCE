/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.main.service;

import com.poly.main.model.TheLoai;
import java.util.List;

/**
 *
 * @author hangnt
 */
public interface TheLoaiService {

    List<TheLoai> findAll();

    TheLoai findByID(Long id);
    
}
