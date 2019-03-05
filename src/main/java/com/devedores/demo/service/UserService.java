package com.devedores.demo.service;

import com.devedores.demo.dto.UserDto;
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
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private DebtService debtService;

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return repo.findAll();
    }

    public UserDto create(UserDto user) {
        User obj = user.convertDtoToObject();
        if(obj == null){
            throw new RuntimeException("Not found user");
        }

        return UserDto.convertObjectToDto(repo.save(obj));
    }

    public UserDto update(UserDto userDto, Integer id){
        User recoveryUser = repo.getOne(id);

        if(recoveryUser == null){
            throw new RuntimeException("Not found user");
        }

        userDto.setId(id);
        return create(userDto);
    }

    @Transactional(readOnly = true)
    public UserDto getById(Integer id) {
        Optional<User> user = repo.findById(id);
        user.orElseThrow(() -> new RuntimeException("User not found"));
        return UserDto.convertObjectToDto(user.get());
    }

    @Transactional
    public Boolean delete(Integer id) {
        final Optional<User> user = repo.findById(id);
        user.orElseThrow(() -> new RuntimeException("User not found"));

        debtService.deleteAllByUser(user.get());
        repo.delete(user.get());
        return Boolean.TRUE;
    }

    @Transactional
    public List<User> importFromJsonPlaceHolder(List<User> users) {
        final List<String> usernames = users.stream().map(u -> u.getUsername()).collect(Collectors.toList());
        final List<String> filteredUsernames = repo.getOnlyExistsUsernamesByUsernames(usernames);
        final List<User> onlyNotExistsUsername = users.stream().filter(u -> !filteredUsernames.contains(u.getUsername())).collect(Collectors.toList());

        return repo.saveAll(onlyNotExistsUsername);
    }

    public List<User> getAllByFilter(Boolean onlyDebt) {
        return repo.finAllByFilter(onlyDebt);
    }
}
