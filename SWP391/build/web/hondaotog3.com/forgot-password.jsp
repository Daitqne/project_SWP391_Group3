<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quên Mật Khẩu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 400px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
        }
        input[type="email"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .message {
            color: green;
            text-align: center;
        }
        .error {
            color: red;
            text-align: center;
        }
        .link {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Quên Mật Khẩu</h2>
    <form action="${pageContext.request.contextPath}/ForgotPasswordServlet" method="post">
        <label for="email">Nhập địa chỉ email của bạn:</label>
        <input type="email" id="email" name="email" required>
        <input type="submit" value="Gửi Mã Xác Thực">
    </form>

    <p class="message">
        <%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %>
    </p>
    <p class="error">
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </p>

    <div class="link">
        <a href="https://mail.google.com" target="_blank">
            Mở Gmail để nhận mật khẩu mới
        </a>
    </div>
</div>

<script>
    document.querySelector("form").onsubmit = function() {
        return confirm("Đây có phải bạn không? Nhấn OK để nhận mã xác thực cho mật khẩu mới.");
    }
</script>

</body>
</html>