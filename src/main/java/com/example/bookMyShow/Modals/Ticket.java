package com.example.bookMyShow.Modals;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Tickets")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private Integer totalPrice;

    private String bookedSeats;

    @CreationTimestamp
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private Show show;

    @ManyToOne
    @JoinColumn
    private User user;

}
