package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // tự động tăng trong SQL Server
	private Long  categoryId;

	@Column(name = "categoryName", length=200, columnDefinition = "NVARCHAR(255) NOT NULL")
	private String categoryName;

	@OneToMany (mappedBy = "category", cascade = CascadeType.ALL)
    private Set<ProductEntity> products;
}
