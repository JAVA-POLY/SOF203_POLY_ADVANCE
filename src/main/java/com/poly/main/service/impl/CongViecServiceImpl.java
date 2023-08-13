/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.main.service.impl;

import com.poly.main.model.CongViec;
import com.poly.main.service.CongViecService;
import com.poly.main.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hangnt
 */
public class CongViecServiceImpl implements CongViecService{

    private final Session hSession;

    public CongViecServiceImpl() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    @Override
    public void insert(CongViec congViec) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(congViec);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
        }
    }

    @Override
    public void update(CongViec congViec) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(congViec);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
        }
    }

    @Override
    public void delete(CongViec congViec) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(congViec);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
        }
    }

    @Override
    public CongViec findByID(Long id) {
        String hql = "SELECT obj FROM CongViec obj WHERE obj.id = ?1";
        TypedQuery<CongViec> query = this.hSession.createQuery(hql, CongViec.class);
        query.setParameter(1, id);
        CongViec ch = query.getSingleResult();
        return ch;
    }

    @Override
    public List<CongViec> findAll() {
        String hql = "SELECT obj FROM CongViec obj";
        TypedQuery<CongViec> query = this.hSession.createQuery(hql, CongViec.class);
        return query.getResultList();
    }
}
