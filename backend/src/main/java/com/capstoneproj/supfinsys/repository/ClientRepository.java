package com.capstoneproj.supfinsys.repository;

import com.capstoneproj.supfinsys.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	@Query("select c from Client c where c.username = :username")
	public Client findByUserName(String userName);
}
