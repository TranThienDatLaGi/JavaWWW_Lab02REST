package vn.edu.iuh.fit.frontend.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.backend.models.Cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/quantity-inc-dec")
public class QuantityIncDecServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter();) {
            String action = req.getParameter("action");
            long id = Long.parseLong(req.getParameter("id"));
            HttpSession session = req.getSession();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

            System.out.println(cart_list);
            if (action != null && cart_list != null) {
                if (action.equals("inc")) {
                    for (Cart c : cart_list) {
                        if (c.getId() == id) {
                            int quatity = c.getQuantity();
                            quatity++;
                            c.setQuantity(quatity);
                            resp.sendRedirect("cart.jsp");
                        }
                    }
                }
                if (action.equals("dec")) {
                    for (Cart c : cart_list) {
                        if (c.getId() == id) {
                            int quatity = c.getQuantity();
                            quatity--;
                            if (quatity <= 1)
                                quatity = 1;
                            c.setQuantity(quatity);
                            resp.sendRedirect("cart.jsp");
                        }
                    }
                }
                if (action.equals("delete")) {
                    Cart cart = null;
                    for (Cart c : cart_list) {
                        if (c.getId() == id) {
                            cart = c;
                            break;
                        }
                    }
                    if (cart != null) {
                        cart_list.remove(cart);
                    }
                    resp.sendRedirect("cart.jsp");
                }

            } else {
                resp.sendRedirect("cart.jsp");
            }

        }
    }
}