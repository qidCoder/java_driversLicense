package com.driverlicense.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String number;
    
    @DateTimeFormat(pattern = "YYYY-dd-mm")
    private Date expirationDate;
    
    private String state;
    
    @Column(updatable=false)
    private Date createdAt;
    
    private Date updatedAt;
    
    @OneToOne(fetch=FetchType.LAZY)
    
    @JoinColumn(name="person_id")// Defines mapping for composite foreign keys. It indicates that the corresponding table to this entity has a foreign_key to the referenced table.
    private Person person;
    
    //constructor
    public License() {
        
    //getters and setters
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	public String formatDate() {
		SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
		return date.format(this.expirationDate);
	}
}
