package com.itexico.demo.models.dao;

import com.itexico.demo.models.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *Provides all methods for DAO operations.
 * It use the CrudRepository interface for common methods.
 * examples: findAll(),findById(),save().
 */
public interface IReservationDao extends CrudRepository<Reservation, Integer> {
    
}
