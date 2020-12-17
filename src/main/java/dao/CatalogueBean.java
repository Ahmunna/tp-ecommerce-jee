package dao;

import entities.*;
import org.jboss.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;


@Stateless(name = "CatalogueBean")
public class CatalogueBean  implements Catalogue{

    private static final Logger LOGGER = Logger.getLogger(CatalogueBean.class);
    @PersistenceContext(unitName = "catalogueWeb")
    EntityManager em;

    @Override
    public Long addCategory(Category c) {
        em.persist(c);
        return c.getIdCategory();
    }

    @Override
    public List<Category> getCategories() {
        Query req = em.createQuery("select c from Category c");
        return req.getResultList();
    }

    @Override
    public Category getCategory(Long idCategory) {
        System.out.println("Getting category");return em.find(Category.class, idCategory);
    }

    @Override
    public void removeCategory(Long idCategory) {
        Category c = getCategory(idCategory);
        em.remove(c);
    }

    @Override
    public void updateCategory(Category c) {
        em.merge(c);
    }

    @Override
    public Long addProduct(Product p, Long idCategory) {
        Category c = getCategory(idCategory);
        p.setCategory(c);
        em.persist(p);
        return p.getIdProduct();
    }

    @Override
    public List<Product> getProducts() {
        Query req = em.createQuery("select p from Product p ");
        return req.getResultList();
    }

    @Override
    public List<Product> getProductByCategory(Long idCategory) {
        Query req = em.createQuery("select p from Product p where p.category.idCategory = :x");
        req.setParameter("x", idCategory);
        return req.getResultList();
    }

    @Override
    public List<Product> getProductsByKeyword(String keyword) {
        Query req = em.createQuery("select p from Product p where p.designation like :x or p.description like :x");
        req.setParameter("x", "%"+keyword+"%");
        return req.getResultList();
    }

    @Override
    public List<Product> getSelectedProducts() {
        Query req = em.createQuery("select p from Product p where p.selected = true");
        return req.getResultList();
    }

    @Override
    public Product getProduct(Long idProduct) {
        return em.find(Product.class, idProduct);
    }

    @Override
    public void removeProduct(Long idProduct) {
        Product p = getProduct(idProduct);
        em.remove(p);
    }

    @Override
    public void updateProduct(Product p) {
        em.merge(p);
    }

    @Override
    public void addUser(User u) {
        em.persist(u);
    }

    @Override
    public void assignRole(Role r, Long userId) {
        User u = em.find(User.class, userId);
       u.getRoles().add(r);
       em.persist(r);
    }

    @Override
    public Order saveOrder(Cart c, Client cl) {
        em.persist(cl);
        Order cmd=new Order();
        cmd.setOrderDate(new Date());
        cmd.setItems(c.getItems());
        for (OrderLine lc:c.getItems()){
            em.persist(lc);
        }
        em.persist(cmd);
        return cmd;
    }

    @Override
    public Role getRole(Long roleId) {
        return em.find(Role.class, roleId);
    }

    public CatalogueBean() {
        LOGGER.info("A catalogue been was created");
    }
}
