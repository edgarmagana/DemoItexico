package com.itexico.demo.demo.models.services;

import com.itexico.demo.demo.models.entity.Reservation;

import java.util.List;

public interface IReservationService {
    public List<Reservation> findAll();
}
