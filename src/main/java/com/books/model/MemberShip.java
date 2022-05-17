package com.books.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="membership")
public class MemberShip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	@Column(name="user_id")
	private Integer userId;
	@Column(name="start_date")
	private LocalDate start;
	@Column(name="end_date")
	private LocalDate end;
}
