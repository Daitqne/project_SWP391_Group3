
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng ký tài khoản</title>
        <style>
            body {
                background-color: #f8f9fa;
                font-family: 'Arial', sans-serif;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            .modal {
                width: 100%;
                max-width: 500px;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
                overflow: hidden;
            }
            .modal-header {
                background-color: #343a40;
                color: #fff;
                text-align: center;
                padding: 15px 0;
            }
            .modal-header h2 {
                margin: 0;
                font-size: 24px;
            }
            .modal-body {
                padding: 20px;
            }
            .form-group {
                margin-bottom: 15px;
            }
            .form-group input {
                width: calc(100% - 24px);
                padding: 10px 12px;
                border: 1px solid #ced4da;
                border-radius: 50px;
                font-size: 16px;
                margin: 0 auto;
                display: block;
                box-sizing: border-box;
            }
            .form-group input:focus {
                border-color: #80bdff;
                outline: none;
                box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
            }
            .btn {
                background-color: #343a40;
                color: #fff;
                padding: 10px 40px;
                border: none;
                border-radius: 50px;
                font-size: 16px;
                font-weight: bold;
                cursor: pointer;
                display: block;
                margin: 0 auto;
                margin-top: 20px;
            }
            .btn:hover {
                background-color: #23272b;
            }
            .gender-group {
                display: flex;
                align-items: center;
                justify-content: center;
                margin-bottom: 15px;
            }
            .gender-group label {
                margin-left: 10px;
                margin-right: 20px;
            }
            .modal-footer {
                text-align: center;
                padding: 10px 0;
            }
            .modal-footer a {
                color: #343a40;
                text-decoration: none;
                font-size: 14px;
            }
            .modal-footer a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <div class="modal" id="registerModal">
            <div class="modal-header">
                <h2>Đăng ký tài khoản</h2>
            </div>
            <div class="modal-body">
                <section>
                    <div class="container">
                        <form action="signup" method="POST">
                            <div class="form-group">
                                <input type="text" id="firstname" placeholder="Họ" name="Firstname" required>
                                
                            </div>
                            <div class="form-group">
                                
                                <input type="text" id="lastname" placeholder="Tên" name="Lastname" required>
                            </div>
                            <div class="form-group">
                                <input type="email" id="email" placeholder="Email" name="email" required>
                            </div>
                            <div class="form-group">
                                <input type="text" id="phone" placeholder="Số điện thoại" name="phone" required>
                            </div>
                            <div class="form-group">
                                <input type="password" id="pwd" placeholder="Mật khẩu" name="password" required>
                                <span id="pwd-error" style="color:red;"></span>
                            </div>
                            <div class="form-group">
                                <input type="password" id="repassword" placeholder="Nhập lại mật khẩu" name="repassword" required>
                            </div>
                            <span style="color:red">${notification}</span>
                            <input type="submit" value="Đăng ký" class="btn"/>
                        </form>
                        <div class="modal-footer">
                            <a data-toggle="modal" data-dismiss="modal" data-target="#loginModal" href="authen?action=login">Quay lại đăng nhập</a>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <script>
            document.getElementById('pwd').addEventListener('input', function () {
                const password = this.value;
                const errorMsg = document.getElementById('pwd-error');
                const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
                if (!regex.test(password)) {
                    errorMsg.textContent = "Mật khẩu phải có ít nhất 8 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt.";
                } else {
                    errorMsg.textContent = "";
                }
            });
        </script>

    </body>
</html>