package dao;

import entities.*;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface Catalogue {

    Long addCategory(Category c);
    List<Category> getCategories();
    Category getCategory(Long idCategory);
    void removeCategory(Long idCategory);
    void updateCategory(Category c);

    Long addProduct(Product p, Long idCategory);
    List<Product> getProducts();
    List<Product> getProductByCategory(Long idCategory);
    List<Product> getProductsByKeyword(String keyword);
    List<Product> getSelectedProducts();
    Product getProduct(Long idProduct);
    void removeProduct(Long idProduct);
    void updateProduct(Product p);

    void addUser(User u);
    Role getRole(Long roleId);
    void assignRole(Role r, Long userId);
    Order saveOrder(Cart c, Client cl);

}
