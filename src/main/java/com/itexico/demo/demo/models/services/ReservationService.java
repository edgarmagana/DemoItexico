package com.itexico.demo.demo.models.services;

import com.itexico.demo.demo.models.dao.IReservationDao;
import com.itexico.demo.demo.models.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationService implements IReservationService {
    @Autowired
    IReservationDao reservationDao;
    @Override
    public List<Reservation> findAll() {
        return (List<Reservation>) reservationDao.findAll();
    }
}
