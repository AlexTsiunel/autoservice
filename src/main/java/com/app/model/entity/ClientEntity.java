package com.app.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "client")
public class ClientEntity extends PersistableEntityImpl
{
	private String firstName;
	private String secondName;
	private String email;
	private List<OrderEntity> orderEntities;

	@Column(name = "first_name", length = 20, nullable = false)
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	@Column(name = "second_name", length = 20, nullable = false)
	public String getSecondName()
	{
		return secondName;
	}

	public void setSecondName(String secondName)
	{
		this.secondName = secondName;
	}

	@Column(name = "email", length = 50)
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}


	@OneToMany(mappedBy = "clientEntity", cascade = CascadeType.ALL)
	@JsonBackReference
	public List<OrderEntity> getOrderEntities() {
		return orderEntities;
	}

	public void setOrderEntities(List<OrderEntity> orderEntities) {
		this.orderEntities = orderEntities;
	}

}