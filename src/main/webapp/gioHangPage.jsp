<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Cart" %>
<%@ page import="vn.edu.iuh.fit.backend.services.ProductService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="vn.edu.iuh.fit.backend.services.ProductPriceService" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ Hàng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

    <style>
        .table tbody td {
            vertical-align: middle;
        }

        .btn-incre, .btn-decre {
            box-shadow: none;
            font-size: 25px;
        }

        .container {
            margin-top: 20px;
        }

        .navbar-nav {
            display: flex;
            align-items: center;
        }

        .badge {
            margin-left: 5px;
        }

        th {
            text-align: center;
        }

        .table th, .table td {
            vertical-align: middle;
            text-align: center;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }

        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }

        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
        }

        .btn-danger:hover {
            background-color: #bd2130;
            border-color: #bd2130;
        }
    </style>
</head>
<body>
<%
    ProductService productServices = new ProductService();
    ProductPriceService productPriceServices = new ProductPriceService();
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
    Double total = 0.0;
    List<Cart> cartProduct = null;
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null && !cart_list.isEmpty()) {

        for (Cart c : cart_list) {
            Double price = productPriceServices.getNewPriceByIdProduct(String.valueOf(c.getId()));
            total += price * c.getQuantity();
        }
        cartProduct = cart_list;
        request.setAttribute("cart_list", cart_list);
        request.setAttribute("total", total);
    }
%>

<div class="container">
    <div class="d-flex justify-content-between align-items-center py-3">
        <div class="d-flex align-items-center">
            <h1 class="mr-3">Total Price:</h1>
            <h2 style="color: red">$ ${(total > 0) ? dcf.format(total) : 0}</h2>
        </div>
        <a class="btn btn-primary" href="#">Check Out</a>

        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="danhSachSanPhamClient.jsp">List product</a></li>
            <li class="nav-item">
                <a class="nav-link" href="gioHangPage.jsp">Cart <span
                        class="badge badge-danger">${cart_list.size()!=null?cart_list.size():0}</span></a>
            </li>
            <li class="nav-item"><a class="nav-link" href="index.jsp">Back to home</a></li>
        </ul>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Category</th>
            <th scope="col">Price</th>
            <th scope="col">Buy Now</th>
            <th scope="col">Cancel</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (cart_list != null) {
                for (Cart c : cartProduct) {
                    System.out.println(productServices.findAll().size());
                    Double price = productPriceServices.getNewPriceByIdProduct(String.valueOf(c.getId()));
                    Product product = productServices.findOne(Long.valueOf(c.getId())).get();
                    if (product != null && price != null) {
        %>
        <tr>
            <td><%= product.getName() %>
            </td>
            <td><%= product.getUnit() %>
            </td>
            <td><%= dcf.format(price * c.getQuantity()) %> $</td>
            <td>
                <form action="order-now" method="get" class="form-inline">
                    <input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
                    <div class="form-group d-flex justify-content-between w-50">
                        <a class="btn btn-sm btn-incre"
                           href="quantity-inc-dec?action=inc&id=<%= c.getId() %>"><i
                                class="fas fa-plus-square"></i></a>
                        <input type="text" name="quantity"
                               class="form-control w-50 text-center"
                               value="<%= c.getQuantity() %>" readonly>
                        <a class="btn btn-sm btn-decre"
                           href="quantity-inc-dec?action=dec&id=<%= c.getId() %>"><i
                                class="fas fa-minus-square"></i></a>
                    </div>
                    <button type="submit" class="btn btn-primary btn-sm">Buy</button>
                </form>
            </td>
            <td><a class="btn btn-sm btn-danger" href="quantity-inc-dec?action=delete&id=<%= c.getId() %>">Remove</a>
            </td>
        </tr>
        <% }
        }
        }
        %>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</body>
</html>