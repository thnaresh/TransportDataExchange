package com.transportdataexchange.bogdan.repository;

import com.transportdataexchange.bogdan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByusername(String username);
}

