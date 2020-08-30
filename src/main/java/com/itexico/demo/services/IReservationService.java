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
    List<Reservation> findAll();
    Reservation getById(int id);
    Reservation save(Reservation reservation);
    Reservation update(Reservation reservation);
    void delete(int id);
}
