<%@ page import="vn.edu.iuh.fit.backend.models.Product" %>
<%@ page import="vn.edu.iuh.fit.backend.services.ProductService" %>
<%@ page import="java.util.*" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <style>
        .card-img-top {
            height: 200px;
            width: 100%;
            object-fit: contain;
        }

        .price,
        .Manu {
            color: #333;
        }

        /* Căn chỉnh container */
        .container {
            margin-top: 20px;
            margin-bottom: 20px;
            max-width: 1200px; /* Giới hạn chiều rộng */
        }

        .card {
            width: 100%;
            margin-bottom: 20px;
        }

        .btn-group {
            display: flex;
            justify-content: space-between;
        }

        .cart-badge {
            position: relative;
            display: inline-block;
            margin-left: 5px; /* Khoảng cách giữa hình giỏ hàng và badge */
        }

        .cart-badge span {
            position: absolute;
            top: -39px;
            right: 10px;
            background-color: firebrick;
            color: white;
            border-radius: 50%;
            padding-bottom: 6px;
            padding-top: 6px;
            padding-left: 8px;
            padding-right: 8px;
            font-size: 17px;
            line-height: 1; /* Để căn giữa nội dung */
        }
    </style>
</head>
<body>

<%
    ProductService productServices = new ProductService();
    List<Product> lst = productServices.findAll();
    System.out.println(lst.size());

    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    int size = 0;
    if(cart_list != null) {
        size = cart_list.size();
        request.setAttribute("cart_list", cart_list);
    }
%>
<div class="container">
    <div class="row">
        <div class="col-md-12 mb-3">
            <h4 class="card-header mb-3">Danh sách sản phẩm</h4>
            <a class="nav-link" href="index.jsp">Back to home</a>
            <a class="btn btn-primary btn-sm float-right" href="gioHangPage.jsp">
                Xem giỏ hàng
                <img src="images/cart.png" style="height: 30px;">
                <% if (size > 0) { %>
                <div class="cart-badge">
                    <span><%=size%></span>
                </div>
                <% } %>
            </a>
        </div>
    </div>

    <div class="row">
        <%
            if (!lst.isEmpty()) {
                for (Product p : lst) {%>
        <div class="col-lg-3 col-md-4 col-sm-6">
            <div class="card">
                <img class="card-img-top" src="<%=p.getProductImageList().get(0).getPath()%>" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title"><%=p.getName()%>
                    </h5>
                    <h6 class="price"><%="$ " + p.getProductPrices().get(0).getPrice()%>
                    </h6>
                    <h6 class="Manu"><%=p.getManufacturer() + "&nbsp;&nbsp;" + p.getUnit()%>
                    </h6>
                    <div class="btn-group">
                        <a href="add-to-cart?id=<%=p.getProduct_id()%>" class="btn btn-dark">Add cart</a>
                        <a href="#" class="btn btn-primary">Buy</a>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</body>
</html>

