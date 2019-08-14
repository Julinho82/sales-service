package com.dh.fullstack.project.salesservice.model.domain;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Julio Daviu
 */

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idPerson")
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Gender gender;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(nullable = false)
    private Boolean isDeleted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdDate;

    @PrePersist
    void onPrePersist(){
        this.createdDate = new Date();
    }
}
