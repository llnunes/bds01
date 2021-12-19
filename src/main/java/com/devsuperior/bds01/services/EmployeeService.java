package com.devsuperior.bds01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import com.devsuperior.bds01.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional(readOnly = true)
	public Page<EmployeeDTO> findAllPaged(Pageable pageable) {		
		Page<Employee> page = repository.findAll(pageable);
		return page.map(d -> new EmployeeDTO(d));
	}
	
	@Transactional
	public EmployeeDTO insert(EmployeeDTO dto) {
		Employee c = new Employee();
		c.setName(dto.getName());
		c.setEmail(dto.getEmail());
		Department department = new Department(dto.getDepartmentId(), null);//departmentRepository.getOne(dto.getDepartmentId());
		c.setDepartment(department);
		repository.save(c);
		return new EmployeeDTO(c);
	}
}
