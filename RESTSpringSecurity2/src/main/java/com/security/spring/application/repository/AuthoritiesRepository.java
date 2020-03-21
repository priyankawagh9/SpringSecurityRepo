package com.security.spring.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.spring.application.model.Authorities;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {

}
