package com.devedores.demo.service;

import com.devedores.demo.dto.DebtDto;
import com.devedores.demo.dto.UserDto;
import com.devedores.demo.models.Debt;
import com.devedores.demo.models.User;
import com.devedores.demo.repository.DebtRepository;
import com.devedores.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DebtService {

    @Autowired
    private DebtRepository repo;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<DebtDto> getAllDto() {
        return repo.findAllDto();
    }

    public DebtDto create(DebtDto debtDto) {

        final Optional<User> user = userRepository.findById(debtDto.getUserId());
        user.orElseThrow(() -> new RuntimeException("User not found"));

        final Debt debt = debtDto.convertDtoToObject();
        final Debt saved = repo.save(debt);
        return DebtDto.convertObjectToDto(saved);
    }

    public Debt update(Debt debt, Integer id){
        return null;
    }

    @Transactional(readOnly = true)
    public DebtDto getById(Integer id) {
        Optional<Debt> debt = repo.findById(id);
        debt.orElseThrow(() -> new RuntimeException("User not found"));
        return DebtDto.convertObjectToDto(debt.get());
    }

    public Boolean delete(Integer id) {
        repo.deleteById(id);
        return Boolean.TRUE;
    }

    @Transactional
    public Boolean deleteAllByUser(User user){
        repo.deleteAllByUser(user);
        return Boolean.TRUE;
    }
}
