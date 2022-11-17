package com.example.project.project_book_my_show.Repository;

import com.example.project.project_book_my_show.Model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
