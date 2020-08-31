package com.itexico.demo.services;

import com.itexico.demo.models.entity.Reservation;

import java.util.List;

/**
 * provides methods to perform CRUD operations on Reservation resources
 */
public interface IReservationService {
    /**
     * Retrieves all reservations stored in the database
     * @return The Reservation list
     */
    public List<Reservation> findAll();
}
