package com.itexico.demo.demo.models.dao;

import com.itexico.demo.demo.models.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface IReservationDao extends CrudRepository<Reservation, Integer> {
    
}
