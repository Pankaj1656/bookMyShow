package com.example.bookMyShow.Repository;

import com.example.bookMyShow.Modals.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
