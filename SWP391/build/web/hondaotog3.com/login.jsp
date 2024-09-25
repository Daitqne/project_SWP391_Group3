<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            /* ??t hình n?n m?c ??nh vào ?ây. */
            background: url('drive.gianhangvn.com/image/your-image.jpg') no-repeat center center fixed;
            background-size: cover;
        }
        .go-back {
            position: absolute;
            top: 20px;
            left: 20px;
            font-size: 18px;
            color: #fff;
            text-decoration: none;
            display: flex;
            align-items: center;
        }
        .go-back img {
            width: 24px;
            height: 24px;
            margin-right: 8px;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
            padding: 20px;
        }
        .login-form {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }
        .login-form h2 {
            margin: 0 0 20px 0;
            color: #333;
        }
        .login-form input[type="text"], .login-form input[type="password"] {
            width: calc(100% - 22px);
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 6px;
            box-sizing: border-box;
        }
        .login-form input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
        }
        .login-form input[type="submit"]:hover {
            background-color: #218838;
        }
        .login-form a {
            color: #007bff;
            text-decoration: none;
            display: block;
            margin-top: 10px;
        }
        .login-form a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <a href="index.jsp" class="go-back">
        <img src="drive.gianhangvn.com/image/your-logo.png" alt="Go Back"> Home page
    </a>
    <div class="container">
        <div class="login-form">
            <h2>Login</h2>
            <form action="LoginServlet" method="post">
                <input type="text" name="username" placeholder="Username" required>
                <input type="password" name="password" placeholder="Password" required>
                <input type="submit" value="Login">
                <p><a href="forgot-password.jsp">Forgot Password?</a></p>
                <p><a href="change-password.jsp">change password</a></p>
                <p><a href="register.jsp">Register</a></p>
            </form>
        </div>
    </div>
</body>
</html>