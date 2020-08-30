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
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private LocalDateTime time ;
    public Reservation(String name, LocalDateTime time){
        this.name= name;
        this.time=time;
    }
}
