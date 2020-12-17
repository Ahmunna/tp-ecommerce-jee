package servlet;

import dao.Catalogue;
import entities.Category;
import entities.Product;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminServlet extends HttpServlet {

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
        String action = req.getParameter("action");
        if(action != null)
        {
            switch(action)
            {
                case "showAddProduct" : showAddProduct(req, resp); break;
                case "showAddCategory": showAddCategory(req, resp); break;
                case "showAssignRole": showAssignRole(req, resp); break;
                default: showAdminPanel(req, resp); break;
            }
        }
        else showAdminPanel(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch(action)
        {
            case "addProduct": addProduct(req, resp); break;
            case "addCategory": addCategory(req, resp); break;
            case "assignRole": assignRole(req, resp); break;
        }
    }

    private void assignRole(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void addCategory(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productDesignation = req.getParameter("productDesignation");
        String productDescription = req.getParameter("productDescription");
        String productQuantity = req.getParameter("productQuantity");
        String productPrice = req.getParameter("productPrice");
        String productCategory = req.getParameter("productCategory");

        Product p = new Product(productDesignation, productDescription, Double.parseDouble(productPrice), Integer.parseInt(productQuantity));
        cb.addProduct(p, Long.parseLong(productCategory));

        req.getRequestDispatcher("admin_panel.jsp").forward(req, resp);
    }

    private void showAdminPanel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("admin_panel.jsp").forward(req, resp);
    }

    private void showAssignRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("assign_role.jsp").forward(req, resp);
    }

    private void showAddCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add_category.jsp").forward(req, resp);
    }

    private void showAddProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = cb.getCategories();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("add_product.jsp").forward(req, resp);
    }

}
