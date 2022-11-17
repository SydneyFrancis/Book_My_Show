package com.example.project.project_book_my_show.Repository;

import com.example.project.project_book_my_show.Model.MovieEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

}
