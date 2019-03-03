package com.devedores.demo.repository;

import com.devedores.demo.dto.DebtDto;
import com.devedores.demo.models.Debt;
import com.devedores.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Integer> {
    Optional<Debt> findById(Integer id);

    @Query("SELECT new com.devedores.demo.dto.DebtDto(debt) FROM Debt debt")
    List<DebtDto> findAllDto();

    void deleteAllByUser(User user);
}
