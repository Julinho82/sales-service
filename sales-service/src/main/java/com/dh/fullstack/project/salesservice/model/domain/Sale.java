package com.dh.fullstack.project.salesservice.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * @author Julio Daviu
 */

@Data
@Entity
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idSale", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long numberSale;

    @Column(nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEmployee", referencedColumnName = "idEmployee", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idClient", referencedColumnName = "idClient", nullable = false)
    private Client client;

    @PrePersist
    void onPrePersis(){
        this.createdDate = new Date();
    }
}
