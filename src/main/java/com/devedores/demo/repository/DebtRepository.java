package com.devedores.demo.repository;

import com.devedores.demo.dto.DebtDto;
import com.devedores.demo.models.Debt;
import com.devedores.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Integer> {
    Optional<Debt> findById(Integer id);

    @Query("SELECT new com.devedores.demo.dto.DebtDto(debt) FROM Debt debt")
    List<DebtDto> findAllDto();

    void deleteAllByUser(User user);

    @Query("SELECT new com.devedores.demo.dto.DebtDto(debt) FROM Debt debt WHERE (debt.user.id = :userId OR :userId IS NULL) AND (debt.startDate = :startDate OR :startDate IS NULL)")
    List<DebtDto> finAllByUseridOrStartDate(@Param("userId") Integer userId, @Param("startDate") Date startDate);
}
