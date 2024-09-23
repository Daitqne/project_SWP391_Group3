<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cấp lại mật khẩu</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <!-- Kích hoạt modal khi trang tải -->
    <script>
        $(document).ready(function(){
            $('#ResetPasswordModal').modal('show');
        });
    </script>

    <div class="modal fade col-md-12" role="dialog" id="ResetPasswordModal">
        <div class="modal-dialog">
            <div class="modal-content" style="border-radius: 10px; margin-top: 150px;">
                <div class="modal-header">
                    <h1 style="text-align: center; margin-left: 70px;">Cấp lại mật khẩu</h1>
                </div>
                <div class="modal-body">
                    <!-- Hiển thị thông báo nếu có -->
                    <c:if test="${notification ne null}">
                        <div class="alert alert-danger">
                            ${notification}
                        </div>
                    </c:if>
                    <!-- Form gửi email để cấp lại mật khẩu -->
                    <form action="authen?action=resetpassword" method="post">
                        <div class="form-group">
                            <input name="email" type="email" class="form-control" placeholder="Email của bạn" style="border-radius: 100px;" required>
                        </div>
                        <br>
                        <center>
                            <button type="submit" class="btn btn-dark" style="padding-right: 200px;
                                    padding-left: 200px;
                                    border-radius: 100px;
                                    margin-bottom: -40px;
                                    height: 50px;">Kiểm tra
                            </button>
                        </center>
                    </form>
                    <br><br>
                    <!-- Liên kết quay lại trang đăng nhập -->
                    <a type="button" href="authen?action=login" style="padding-left: 170px; text-decoration: none; border-radius: 100px;">Quay lại Đăng nhập</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
