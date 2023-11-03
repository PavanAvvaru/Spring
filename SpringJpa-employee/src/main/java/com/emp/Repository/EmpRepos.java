package com.emp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.emp.entity.Employee;
@Repository
public interface EmpRepos extends JpaRepository<Employee, Integer>{

}
