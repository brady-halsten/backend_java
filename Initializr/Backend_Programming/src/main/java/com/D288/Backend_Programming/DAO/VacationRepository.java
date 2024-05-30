package com.D288.Backend_Programming.DAO;

import com.D288.Backend_Programming.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "vacations", path = "vacations")
public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
