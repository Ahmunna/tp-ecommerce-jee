package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String designation;
    private String description;
    private double price;
    private Boolean selected;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private int quantity;


    public Product() {
        super();
    }

    public Product(String designation, String description, double price, Boolean selected, Category category, int quantity) {
        this.designation = designation;
        this.description = description;
        this.price = price;
        this.selected = selected;
        this.category = category;
        this.quantity = quantity;
    }

    public Product(String designation, String description, double price, int quantity) {
        this.designation = designation;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
