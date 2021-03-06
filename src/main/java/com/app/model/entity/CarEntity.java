package com.app.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "car")
public class CarEntity extends PersistableEntityImpl {
    private String carNumber;
    private Date warrantyDate;
    private OrderEntity orderEntity;


    @Column(name = "car_number", length = 15, nullable = false, unique = true)
    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Column(name = "warranty_date", length = 20, nullable = false)
    public Date getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(Date warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

    @OneToOne(mappedBy = "carEntity", cascade= CascadeType.ALL)
    @JsonBackReference
    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
}
