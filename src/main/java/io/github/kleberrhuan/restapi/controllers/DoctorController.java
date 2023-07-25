package io.github.kleberrhuan.restapi.controllers;

import io.github.kleberrhuan.restapi.entities.Doctor;
import io.github.kleberrhuan.restapi.records.doctor.DoctorData;
import io.github.kleberrhuan.restapi.records.doctor.DoctorListData;
import io.github.kleberrhuan.restapi.records.doctor.DoctorPutData;
import io.github.kleberrhuan.restapi.repositories.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorRepository repository;

    @Autowired
    public DoctorController(DoctorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DoctorData body) {
        repository.save(new Doctor(body));
    }

    @GetMapping
    public Page<DoctorListData> getAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return repository.findAllByInactiveFalse(pageable).map(DoctorListData::new);
    }

    @GetMapping("/{id}")
    public DoctorListData getById(@PathVariable Long id) {
        try{
        var Doctor = repository.findById(id).stream().map(DoctorListData::new).toList();
        return Doctor.get(0);
        } catch(Exception e){
            return null;
        }
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DoctorPutData body) {
        var doctor = repository.getReferenceById(body.id());
        doctor.update(body);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.delete();
    }


}
