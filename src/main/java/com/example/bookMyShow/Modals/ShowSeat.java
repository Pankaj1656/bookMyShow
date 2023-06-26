package com.example.bookMyShow.Modals;

import com.example.bookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Entity
@Table(name="ShowSeat")
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String SeatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer price;

    private Boolean isAvailable;

    private Boolean isFoodAttached;

    @ManyToOne
    @JoinColumn
    private Show show;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeatNo() {
        return SeatNo;
    }

    public void setSeatNo(String seatNo) {
        SeatNo = seatNo;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Boolean getFoodAttached() {
        return isFoodAttached;
    }

    public void setFoodAttached(Boolean foodAttached) {
        isFoodAttached = foodAttached;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
