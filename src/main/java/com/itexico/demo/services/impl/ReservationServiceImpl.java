package com.itexico.demo.services.impl;

import com.itexico.demo.models.dao.IReservationDao;
import com.itexico.demo.models.entity.Reservation;
import com.itexico.demo.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServiceImpl implements IReservationService {
    @Autowired
    IReservationDao reservationDao;
    @Override
    public List<Reservation> findAll() {
        return (List<Reservation>) reservationDao.findAll();
    }

    @Override
    public Reservation getById(int id ) {
        return reservationDao.findById(id).orElse(null);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationDao.save(reservation);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationDao.save(reservation);
    }

    @Override
    public void delete(int id) {
        reservationDao.deleteById(id);
    }
}
