package com.itexico.demo.utils;

import com.itexico.demo.models.dao.IReservationDao;
import com.itexico.demo.models.entity.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * This class loads automatically some data sample
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);

    private IReservationDao reservationDao;

    @Autowired
    public DatabaseLoader(IReservationDao reservationDao){
        this.reservationDao=reservationDao;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("loading data to DB");
        reservationDao.save(new Reservation("Edgar", LocalDateTime.now()));
        reservationDao.save(new Reservation("Marcelo", LocalDateTime.now()));
        reservationDao.save(new Reservation("Eduardo", LocalDateTime.now()));
        reservationDao.save(new Reservation("Miguel", LocalDateTime.now()));
        reservationDao.save(new Reservation("Daniel", LocalDateTime.now()));
    }
}
