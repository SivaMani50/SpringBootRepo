package com.example.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Employee(Integer empId, String name, String city) {
		super();
		this.empId = empId;
		this.name = name;
		this.city = city;
	}

	@Id
	@Column(name = "EMPID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CITY")
	private String city;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(empId).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && this.getClass() == obj.getClass()) {
			Employee emp = (Employee) obj;
			return new EqualsBuilder().append(empId, emp.empId).isEquals();
		}
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("empId", empId).append("name", name).append("city", city)
				.appendSuper(super.toString()).toString();
	}

}
