package com.D288.Backend_Programming.DAO;

import com.D288.Backend_Programming.entities.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "excursions", path = "excursions")
public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
}
