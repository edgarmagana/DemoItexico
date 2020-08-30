package com.itexico.demo.models.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@NoArgsConstructor
@Getter @Setter
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDateTime time ;

    @PrePersist
    public void createDate(){
        time = LocalDateTime.now();
    }
    public Reservation(String name, LocalDateTime time){
        this.name= name;
        this.time=time;
    }
}
