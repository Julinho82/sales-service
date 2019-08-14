package com.dh.fullstack.project.salesservice.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Julio Daviu
 */

@Data
@Entity

public class Detail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idDetail")
    private Long id;

    @Column(nullable = false)
    private Integer totalProducts;

    @Column(nullable = false)
    private Long totalPrice;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idSale", referencedColumnName = "idSale")
    private Sale sale;

}
