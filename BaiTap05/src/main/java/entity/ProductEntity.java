package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name="product_name", length = 500, columnDefinition = "nvarchar(500")
    private String name;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double unitPrice;
    @Column(length = 200)
    private String images;
    @Column(columnDefinition = "nvarchar(500) not null")
    private String description;
    private double discount;
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(nullable = false)
    private short status;

    @ManyToOne
    @JoinColumn(name="categoryID")
    private CategoryEntity category;
}
