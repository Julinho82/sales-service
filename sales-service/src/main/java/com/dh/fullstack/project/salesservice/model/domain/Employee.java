package com.dh.fullstack.project.salesservice.model.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import java.io.Serializable;

/**
 * @author Julio Daviu
 */

@Data
@Entity
@PrimaryKeyJoinColumns(@PrimaryKeyJoinColumn(name = "idEmployee", referencedColumnName = "idPerson"))

public class Employee extends Person implements Serializable {

    @Column(length = 20)
    private String position;

}
