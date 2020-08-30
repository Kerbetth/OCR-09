package com.medic.mediscreen.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PATIENT")
@EqualsAndHashCode(of = "id")
public class Patient {
    @Id
    @GeneratedValue
    Integer patId;
    @NotBlank
    String family;
    @NotBlank
    String given;
    @NotBlank
    Date dob;
    @NotBlank
    char sex;
    @NotBlank
    String address;
    String phone;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "patient")
    private Set<PatHistory> patHistories;
}
