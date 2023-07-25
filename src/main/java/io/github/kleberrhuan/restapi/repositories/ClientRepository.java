package io.github.kleberrhuan.restapi.repositories;

import io.github.kleberrhuan.restapi.entities.Client;
import io.github.kleberrhuan.restapi.records.client.ClientListData;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Page<Client> findAllByInactiveFalse(Pageable pageable);
}
