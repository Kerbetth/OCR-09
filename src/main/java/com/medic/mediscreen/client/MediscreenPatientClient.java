package com.medic.mediscreen.client;

import com.medic.mediscreen.dto.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "mediscreenPatient", url = "${PATIENT_URI}", primary = false)
public interface MediscreenPatientClient {

    @GetMapping(value = "/patients")
    List<Patient> getPatientList();

    @GetMapping(value = "/patient/id")
    Patient getPatientById(@RequestParam int id);

    @GetMapping(value = "/patient/familyName")
    Patient getPatientByFamilyName(@RequestParam String familyName);

    @PostMapping(value = "/patient/add", consumes = "application/json")
    void addAPatient(@RequestBody Patient patient);

    @PutMapping(value = "/patient/set", consumes = "application/json")
    void setAPatient(@RequestBody Patient patient);

    @DeleteMapping(value = "/patient/del", consumes = "application/json")
    void deleteAPatient(@RequestParam int patientId);
}
