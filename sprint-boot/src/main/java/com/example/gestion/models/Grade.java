package com.example.gestion.models;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "grade")
	private String grade;
	
	@Column(name = "fromDate")
	private Date fromDate;
	
	@Column(name = "toDate")
	private Date toDate;
	
	public Grade() {
		
	}

	public Grade(String name, Date from_date, Date to_date, boolean b) {
		this.grade = name;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public String getname() {
		return this.grade;
	}

	public Date getfrom_date() {
		return this.fromDate;
	}

	public Date getto_date() {
		return this.toDate;
	}

	public void setName(String name) {
		this.grade = name;
	}

	public void setFromDate(Date from_date) {
		this.fromDate = from_date;
	}

	public void setToDate(Date to_date) {
		this.toDate = to_date;
	}

}
