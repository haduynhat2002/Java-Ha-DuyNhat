<%@ page import="com.example.baitapcrud.entity.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%
    List<Product> list = (List<Product>) request.getAttribute("product");
    if (list == null) {
        list = new ArrayList<>();
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
                            <section class="section">
                                <div class="card">
                                    <div class="card-header">
                                        Product Datatable
                                    </div>
                                    <div class="card-body">
                                        <table class='table table-striped' id="table1">
                                            <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Name</th>
                                                <th>Thumbnail</th>
                                                <th>Price</th>
                                                <th>Action</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%for (int i = 0; i < list.size(); i++) {%>
                                            <tr class="<%=i%2 == 0 ? "" : "odd"%>">
                                                <td><%=list.get(i).getId()%></td>
                                                <td><%=list.get(i).getName()%></td>
                                                <td><img src="<%=list.get(i).getThumbnail()%>" class="img-thumbnail img-rounded" style="width: 192px; height: 128px;"></td>
                                                <td><%=list.get(i).getPrice()%></td>
                                                <td>
                                                    <a href="/admin/products/detail?id=<%=list.get(i).getId()%>" class="btn icon icon-left btn-primary"><i data-feather="info"></i> Detail</a>
                                                    <a href="/admin/products/update?id=<%=list.get(i).getId()%>" class="btn icon icon-left btn-success"><i data-feather="edit"></i> Edit</a>
                                                    <a href="/admin/products/delete?id=<%=list.get(i).getId()%>" class="btn icon icon-left btn-danger"><i data-feather="trash-2"></i> Delete</a>
                                                </td>
                                            </tr>
                                            <%}%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </section>
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
