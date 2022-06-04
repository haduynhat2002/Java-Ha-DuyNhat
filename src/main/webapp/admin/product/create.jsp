<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.baitapcrud.entity.Product" %>
<%@ page import="com.example.baitapcrud.entity.myenum.ProductStatus" %>
<%
    Product product = (Product) request.getAttribute("product");
    if (product == null) {
        product = new Product();
    }
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<jsp:include page="/admin/includes/head.jsp"/>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="/admin/includes/navbar.jsp"/>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <jsp:include page="/admin/includes/main-sidebar.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>General Form</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">General Form</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-12">
                        <!-- general form elements -->
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">Quick Example</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form action="/admin/product/create" method="post">
                                <div class="m-3 mt-3">
                                    <label>Category</label>
                                    <input type="text" class="form-control" value="<%=product.getCategoryId()%>" placeholder="Enter product name"
                                           name="categoryId">
                                    <%
                                        if (errors.containsKey("name")) {
                                    %>
                                    <p class="valid">* <%=errors.get("name")%>
                                    </p>
                                    <%}%>
                                </div>
                                <div class="m-3 mt-3">
                                    <label>Name product</label>
                                    <input type="text" class="form-control" value="<%=product.getName()%>" placeholder="Enter product name"
                                           name="name">
                                    <%
                                        if (errors.containsKey("name")) {
                                    %>
                                    <p class="valid">* <%=errors.get("name")%>
                                    </p>
                                    <%}%>
                                </div>
                                <div class="m-3">
                                    <label>Description</label>
                                    <input type="text" class="form-control" value="<%=product.getDescription()%>"
                                           placeholder="Enter description" name="description">
                                    <%
                                        if (errors.containsKey("description")) {
                                    %>
                                    <p class="valid">* <%=errors.get("description")%>
                                    </p>
                                    <%}%>
                                </div>
                                <div class="m-3">
                                    <label>Detail</label>
                                    <input type="text" class="form-control" value="<%=product.getDetail()%>" placeholder="Enter detail"
                                           name="detail">
                                </div>
                                <div class="m-3">
                                    <label>Price</label>
                                    <input type="number" class="form-control" value="<%=product.getPrice()%>" placeholder="Enter price"
                                           name="price">
                                </div>
                                <div class="m-3">
                                    <label>Thumbnail</label>
                                    <input type="text" class="form-control" value="<%=product.getThumbnail()%>" placeholder="Enter thumbnail"
                                           name="thumbnail">
                                    <%
                                        if (errors.containsKey("thumbnail")) {
                                    %>
                                    <p class="valid"><%=errors.get("name")%>
                                    </p>
                                    <%}%>
                                </div>
                                <select name="status" class="m-3 choices form-select" style="width: 10%; height: 35px;" data-value="<%=product.getStatus()%>">
                                    <%for (int i = 0; i < ProductStatus.values().length; i++) {%>
                                    <option value="<%=ProductStatus.values()[i].getValue()%>"><%=ProductStatus.values()[i].name()%>
                                    </option>
                                    <%}%>
                                </select>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </form>
                        </div>
                        <!-- /.card -->

                    </div>
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="/admin/includes/footer.jsp"/>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<jsp:include page="/admin/includes/script.jsp"/>
</body>
</html>
