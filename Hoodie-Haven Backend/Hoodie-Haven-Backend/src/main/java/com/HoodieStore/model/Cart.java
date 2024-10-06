package com.HoodieStore.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
	@ManyToOne
	 @JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	private User user;
	public String getProductIds() {
		return null;
	}
	
	
	
}
