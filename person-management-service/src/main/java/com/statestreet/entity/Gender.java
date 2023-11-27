package com.statestreet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "TB_GENDER")
@Entity
public class Gender {
    @Id
    @Column(name = "ID_GENDER")
    private Integer idGender;

    @Column(name = "NAME")
    private String name;
    
    public Gender(GenderType genderType) {
    	this.idGender = genderType.getId();
    }
    
    public static enum GenderType {
        MALE(1, "Male"),
        FEMALE(2, "Female"),
        OTHER(3, "Other");

        private final Integer id;
        private final String name;

        GenderType(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
