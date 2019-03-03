package com.devedores.demo.controller;

import com.devedores.demo.dto.DebtDto;
import com.devedores.demo.models.Debt;
import com.devedores.demo.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("debts")
public class DebtController {

    @Autowired
    private DebtService service;

    @GetMapping
    public ResponseEntity<DebtDto> getById(@RequestParam("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DebtDto>> getAllDto() {
        return ResponseEntity.ok(service.getAllDto());
    }

    @PostMapping
    public ResponseEntity<DebtDto> create(@RequestBody DebtDto debtDto) {
        return ResponseEntity.ok(service.create(debtDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Debt> edit(@PathVariable("id") Integer id, @RequestBody Debt debt){
        return ResponseEntity.ok(service.update(debt, id));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestParam("id") Integer id){
        return ResponseEntity.ok(service.delete(id));
    }
}
