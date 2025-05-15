package com.example.musicschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.musicschool.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
