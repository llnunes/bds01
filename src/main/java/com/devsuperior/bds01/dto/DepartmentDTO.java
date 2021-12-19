package com.devsuperior.bds01.dto;

import java.io.Serializable;

import com.devsuperior.bds01.entities.Department;

public class DepartmentDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Long id;
	public String name;
		
	public DepartmentDTO() {
		super();
	}

	public DepartmentDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public DepartmentDTO(Department entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
	}	
}
