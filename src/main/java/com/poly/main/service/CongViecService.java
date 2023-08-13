/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.main.service;

import com.poly.main.model.CongViec;
import java.util.List;

/**
 *
 * @author hangnt
 */
public interface CongViecService {

    List<CongViec> findAll();

    void insert(CongViec congViec);

    void update(CongViec congViec);

    void delete(CongViec congViec);

    CongViec findByID(Long id);

}
