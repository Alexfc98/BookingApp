package com.Backend.Users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.Users.Model.User;

public interface UserRepository extends JpaRepository<User,String> {


}
