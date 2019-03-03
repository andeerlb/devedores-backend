package com.devedores.demo.repository;

import com.devedores.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Integer id);

    @Query("SELECT u.username FROM User u WHERE u.username IN :usernames")
    List<String> getOnlyExistsUsernamesByUsernames(@Param("usernames") List<String> usernames);
}
