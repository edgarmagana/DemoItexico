package com.itexico.demo.controllers;

import com.itexico.demo.models.entity.Reservation;
import com.itexico.demo.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private IReservationService reservationService;
    @GetMapping
    public ResponseEntity<?> allReservations(){
        ResponseEntity<?> response;
        List<Reservation> reservations = new ArrayList<>();
        try{
            reservations=reservationService.findAll();
        }catch(DataAccessException e){
            Map<String,Object> errorMap= new HashMap<>();
            errorMap.put("message", "Error while querying the database");
            return new ResponseEntity<Map<String, Object>>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response= new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
        return response;
    }
}
