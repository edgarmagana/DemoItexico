package com.itexico.demo.controllers;

import com.itexico.demo.models.entity.Reservation;
import com.itexico.demo.services.IReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable int id){
        ResponseEntity<?> response;
        Reservation reservation;
        Map<String,Object> errorMap = new HashMap<>();
        try {
            reservation = reservationService.getById(id);
        }catch (DataAccessException e){
            errorMap.put("message", "Error while querying the database");
            return  new ResponseEntity<Map<String, Object>>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(reservation == null){
            errorMap.put("message", "Reservation id ".concat(Integer.toString(id).concat(" not found")));
            return  new ResponseEntity<Map<String,Object>>(errorMap,HttpStatus.NOT_FOUND);
        }
        response = new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
        return response;
    }

    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody Reservation reservation){
        ResponseEntity<?> response;
        Reservation newReservation;
        Map<String,Object> responseMap = new HashMap<>();

        try {
            newReservation= reservationService.save(new Reservation(reservation));
        }catch (DataAccessException e){
            responseMap.put("message", "Error while insert in database");
            return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response = new ResponseEntity<Reservation>(newReservation, HttpStatus.CREATED);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReservation(@RequestBody Reservation reservation, @PathVariable int id){
        Map<String, Object> responseMap = new HashMap<>();
        ResponseEntity<?> response;
        Reservation modifiedReservation;
        Reservation currentReservation = reservationService.getById(id);

        if(currentReservation == null){
            responseMap.put("message", "Reservation id ".concat(Integer.toString(id).concat(" not found")));
            return new ResponseEntity<Map<String,Object>>(responseMap,HttpStatus.NOT_FOUND);
        }

        try{
            currentReservation.setName(reservation.getName());
            modifiedReservation = reservationService.update(currentReservation);
        }catch (DataAccessException e){
            responseMap.put("message", "Error while update");
            return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response = new ResponseEntity<Reservation>(modifiedReservation, HttpStatus.CREATED);
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable int id){
        Map<String, Object> responseMap = new HashMap<>();
        ResponseEntity<?> response;
        Reservation currentReservation = reservationService.getById(id);
        if(currentReservation == null){
            responseMap.put("message", "Reservation id ".concat(Integer.toString(id).concat(" not found")));
            return new ResponseEntity<Map<String,Object>>(responseMap,HttpStatus.NOT_FOUND);
        }
        try {
            reservationService.delete(id);
        }catch (DataAccessException e){
            responseMap.put("message", "Error while delete in database");
            return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        responseMap.put("message","Reservation deleted successfully");
        response = new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
        return response;
    }
}
