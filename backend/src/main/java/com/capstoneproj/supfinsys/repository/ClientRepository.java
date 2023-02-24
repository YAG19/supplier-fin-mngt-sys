package com.capstoneproj.supfinsys.repository;

import com.capstoneproj.supfinsys.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Repository("ClientRepository")
public interface ClientRepository extends JpaRepository<Client, Integer> {

//	@Query(value = "select c from Client c where c.username = ?1")
//	Client findByUserName(String username);
//
//	boolean existsByUsername(String username);



//	@Query("")
//	Optional<Client> getByUsername(String username);
}
