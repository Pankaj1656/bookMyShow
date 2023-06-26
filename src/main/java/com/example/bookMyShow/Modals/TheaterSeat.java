package com.example.bookMyShow.Modals;

import com.example.bookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Theatre_Seats")
@Data
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theater theater;
}
