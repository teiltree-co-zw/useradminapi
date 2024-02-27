package com.authadmin.useradminapi.repository;

import com.authadmin.useradminapi.entity.Role;
import com.authadmin.useradminapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User findByRole(Role role);


}
