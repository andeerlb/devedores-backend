package com.devedores.demo.dto;

import com.devedores.demo.models.Address;
import com.devedores.demo.models.Debt;
import com.devedores.demo.models.Geolocation;
import com.devedores.demo.models.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DebtDto implements Serializable {

    private static final long serialVersionUID = 349908227042971365L;

    private Integer id;
    private String name;
    private String reason;
    private BigDecimal value;
    private Date startDate;
    private Integer userId;

    public DebtDto() {
    }

    public DebtDto(Debt debt){
        BeanUtils.copyProperties(debt, this);

        if(debt.getUser() != null){
           setUserId(debt.getUser().getId());
           setName(debt.getUser().getName());
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Debt convertDtoToObject(){
        User user = new User(this.userId);
        Debt debt = new Debt();

        BeanUtils.copyProperties(this, debt);
        debt.setUser(user);
        return debt;
    }

    public static DebtDto convertObjectToDto(Debt debt){
         DebtDto debtDto = new DebtDto();
         debtDto.setUserId(debt.getUser().getId());
         BeanUtils.copyProperties(debt, debtDto);
         return debtDto;
    }
}
