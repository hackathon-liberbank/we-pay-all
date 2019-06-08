package com.liberbank.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liberbank.apigateway.dao.EventDAO;

@Repository
public interface EventRepository extends JpaRepository<EventDAO, Long> {

}
