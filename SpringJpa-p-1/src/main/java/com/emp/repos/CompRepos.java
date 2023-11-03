package com.emp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.Company;

public interface CompRepos extends JpaRepository<Company, Integer>{

}
