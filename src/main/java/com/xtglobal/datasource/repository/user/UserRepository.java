package com.xtglobal.datasource.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xtglobal.datasource.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
