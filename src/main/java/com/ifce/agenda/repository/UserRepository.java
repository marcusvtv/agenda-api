package com.ifce.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ifce.agenda.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
