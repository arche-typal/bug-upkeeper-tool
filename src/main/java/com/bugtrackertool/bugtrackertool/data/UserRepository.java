package com.bugtrackertool.bugtrackertool.data;

import com.bugtrackertool.bugtrackertool.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
