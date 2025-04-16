package com.projetJEE.Repository;

import com.projetJEE.model.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur,Integer> {
	Administrateur findByEmail(String email);
}
