package org.example.baitaptuan05.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products") 
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", length = 500, nullable = false, columnDefinition = "NVARCHAR(500)")
    private String name;

    @Column(name = "description", length = 500, nullable = false, columnDefinition = "NVARCHAR(500)")
    private String description;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Column(name = "discount", nullable = false)
    private Double discount;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "status", nullable = false)
    private Short status;

    @Column(name = "images", length = 200)
    private String images;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    private Category category;
}
