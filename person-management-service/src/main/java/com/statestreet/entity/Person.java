package com.statestreet.entity;

import lombok.Data;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Data
@Table(name = "TB_PERSON")
@Entity
public class Person {
    @Id
    @Column(name = "ID_PERSON")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_generator")
    @SequenceGenerator(name = "person_seq_generator", sequenceName = "TB_PERSON_SEQ", allocationSize = 1)
    private Long idPerson;

    @ManyToOne
    @JoinColumn(name = "ID_GENDER", referencedColumnName = "ID_GENDER", nullable = false)
    private Gender gender;

    @Column(name = "FULL_NAME")
    private String fullName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "BIRTHDATE")
    private Date birthdate;
    
}
