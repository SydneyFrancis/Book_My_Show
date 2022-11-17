package com.example.project.project_book_my_show.Repository;

import com.example.project.project_book_my_show.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
