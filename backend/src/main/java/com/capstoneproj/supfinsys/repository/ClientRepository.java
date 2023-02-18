package com.capstoneproj.supfinsys.repository;

import com.capstoneproj.supfinsys.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
