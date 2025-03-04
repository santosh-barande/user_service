package com.venturingdigitally.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.venturingdigitally.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
