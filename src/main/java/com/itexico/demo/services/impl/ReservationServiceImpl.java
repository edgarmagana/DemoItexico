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
}
