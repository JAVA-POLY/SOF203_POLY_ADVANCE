/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.main.service.impl;

import com.poly.main.model.TheLoai;
import com.poly.main.service.TheLoaiService;
import com.poly.main.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author hangnt
 */
public class TheLoaiServiceImpl implements TheLoaiService{

    private final Session hSession;

    public TheLoaiServiceImpl() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    @Override
    public TheLoai findByID(Long id) {
        String hql = "SELECT obj FROM TheLoai obj WHERE obj.id = ?1";
        TypedQuery<TheLoai> query = this.hSession.createQuery(hql, TheLoai.class);
        query.setParameter(1, id);
        TheLoai ch = query.getSingleResult();
        return ch;
    }

    @Override
    public List<TheLoai> findAll() {
        String hql = "SELECT obj FROM TheLoai obj";
        TypedQuery<TheLoai> query = this.hSession.createQuery(hql, TheLoai.class);
        return query.getResultList();
    }
}
