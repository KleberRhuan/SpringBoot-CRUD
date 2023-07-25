package io.github.kleberrhuan.restapi.repositories;

import io.github.kleberrhuan.restapi.entities.Doctor;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByInactiveFalse(Pageable pageable);
}
