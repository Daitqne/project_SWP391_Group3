<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Password</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .form-container {
            margin-top: 50px;
        }
        .form-control {
            border-radius: 100px;
        }
        .btn-custom {
            padding-right: 160px;
            padding-left: 160px;
            border-radius: 100px;
        }
        .notification {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center form-container">
        <div class="col-md-6 col-md-offset-3">
            <h1 class="text-center">Thay đổi mật khẩu</h1>
            <form action="authen?action=changepassword" method="post">
                <input type="hidden" name="user_Id" value="${sessionScope.us.user_Id}"/>
                <c:if test="${not empty notification}">
                    <div class="alert alert-info notification">${notification}</div>
                </c:if>
                <div class="form-group">
                    <label for="old_pass"><b>Nhập mật khẩu cũ</b></label>
                    <input id="old_pass" name="old_pass" type="password" class="form-control" placeholder="Mật khẩu cũ" required>
                </div>
                <div class="form-group">
                    <label for="new_pass1"><b>Nhập mật khẩu mới</b></label>
                    <input id="new_pass1" name="new_pass1" type="password" class="form-control" placeholder="Mật khẩu mới" required>
                </div>
                <div class="form-group">
                    <label for="new_pass2"><b>Nhập lại mật khẩu mới</b></label>
                    <input id="new_pass2" name="new_pass2" type="password" class="form-control" placeholder="Nhập lại mật khẩu mới" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-dark btn-custom">Cập nhập mật khẩu</button>
                </div>
            </form>
            <div class="text-center">
                <a href="authen?action=login" class="btn btn-link">Quay lại Login</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
