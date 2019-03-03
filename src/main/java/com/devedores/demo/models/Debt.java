package com.devedores.demo.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "debt")
public class Debt extends BaseEntity{

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "start_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startDate;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
