package com.itexico.demo.controllers;

import com.itexico.demo.models.entity.Reservation;
import com.itexico.demo.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private IReservationService reservationService;
    @GetMapping("")
    public List<Reservation> allReservations(){
        return reservationService.findAll();
    }
}
