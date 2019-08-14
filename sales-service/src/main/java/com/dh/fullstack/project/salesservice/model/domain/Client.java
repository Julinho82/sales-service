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
@PrimaryKeyJoinColumns(@PrimaryKeyJoinColumn(name = "idClient", referencedColumnName = "idPerson"))
public class Client extends Person implements Serializable {

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = false, length = 50)
    private Date lastPurchase;

}
