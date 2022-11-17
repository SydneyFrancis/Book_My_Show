package com.example.project.project_book_my_show.Repository;

import com.example.project.project_book_my_show.Model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
}
