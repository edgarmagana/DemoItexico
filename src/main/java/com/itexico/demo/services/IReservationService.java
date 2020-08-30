package com.itexico.demo.services;

import com.itexico.demo.models.entity.Reservation;

import java.util.List;

/**
 *
 */
public interface IReservationService {
    /**
     *
     * @return
     */
    public List<Reservation> findAll();
}
