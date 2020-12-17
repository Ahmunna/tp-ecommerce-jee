package servlet;

import dao.Catalogue;
import dao.CatalogueBean;
import entities.Cart;
import entities.Category;
import entities.Product;
import entities.Role;
import org.apache.log4j.Logger;


import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ControleurServlet extends HttpServlet {

    Logger logger = Logger.getLogger(ControleurServlet.class);


    Catalogue cb;

    @Override
    public void init() throws ServletException {
        super.init();
        try
        {
            InitialContext ic = new InitialContext();
            cb = (Catalogue) ic.lookup("java:global/web_catalogue_ear_exploded/web.war/CatalogueBean!dao.Catalogue");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get the action
        String action = req.getParameter("action");
        switch(action)
        {
            case "showCategories": showCategories(req, resp); break;
            case "showCart": showCart(req, resp); break;
            case "showProducts": showProducts(req,resp); break;
            case "validateOrder": validateOrder(req, resp); break;
            default: showError(req, resp); break;
        }
    }

    private void validateOrder(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("categoryId");
        List<Product> products = cb.getProductByCategory(Long.parseLong(categoryId));
        req.setAttribute("products", products);
        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }

    private void showError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("error.jsp").forward(req,resp);
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart c;
        if(session.getAttribute("cart") == null)
        {
            c = new Cart();
            session.setAttribute("cart", c);
        }
        else
        {
             c = (Cart) session.getAttribute("cart");
        }
        req.setAttribute("cartItems", c.getItems());
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

    private void showCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Showing all categories");
        List<Category> categories = cb.getCategories();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("categorie.jsp").forward(req,resp);
    }
}
