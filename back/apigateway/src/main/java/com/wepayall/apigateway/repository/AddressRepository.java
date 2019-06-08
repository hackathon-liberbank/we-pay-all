package com.wepayall.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wepayall.apigateway.dao.AddressDAO;

@Repository
public interface AddressRepository extends JpaRepository<AddressDAO, Long>{

}
