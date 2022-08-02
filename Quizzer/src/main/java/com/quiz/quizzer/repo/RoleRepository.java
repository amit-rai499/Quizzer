package com.quiz.quizzer.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.quizzer.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
