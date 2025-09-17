package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false) // foreign key
    private CategoryEntity category;

    @Column(name = "name", length = 200, columnDefinition = "NVARCHAR(200) NOT NULL")
    private String name;

    @Column(name = "image")
    private String image;
}
