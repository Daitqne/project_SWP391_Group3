<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Edit Profile</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .avatar-upload {
                position: relative;
                max-width: 205px;
                margin: 50px auto;
            }
            .avatar-edit {
                position: absolute;
                right: 12px;
                z-index: 1;
                top: 10px;
            }
            .avatar-edit input {
                display: none;
            }
            .avatar-edit input + label {
                display: inline-block;
                width: 34px;
                height: 34px;
                margin-bottom: 0;
                border-radius: 100%;
                background: #ffffff;
                border: 1px solid transparent;
                box-shadow: 0px 2px 4px 0px rgba(0, 0, 0, 0.12);
                cursor: pointer;
                font-weight: normal;
                transition: all 0.2s ease-in-out;
            }
            .avatar-edit input + label:hover {
                background: #f1f1f1;
                border-color: #d6d6d6;
            }
            .avatar-preview img {
                width: 192px;
                height: 192px;
                border-radius: 100%;
                border: 6px solid #f8f8f8;
                box-shadow: 0px 2px 4px 0px rgba(0, 0, 0, 0.1);
            }
        </style>
    </head>
    <body>
        <div class="container bootstrap snippet">
            <div class="row">
                <div class="col-sm-10"><h1>Edit Profile</h1></div>
            </div>
            <div class="row">
                <div class="col-sm-3">
                    <div class="text-center">
                        <div class="avatar-upload">
                            <div class="avatar-edit">
                                <input type="file" id="imageUpload" name="avatar" accept=".png, .jpg, .jpeg">
                                <label for="imageUpload"><i class="glyphicon glyphicon-pencil"></i></label>
                            </div>
                            <div class="avatar-preview">
                                <img id="imagePreview" src="${sessionScope.us.avatar}" alt="User Avatar">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-9">
                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <hr>
                            <form class="form" action="authen?action=editprofile" method="post" id="registrationForm" enctype="multipart/form-data">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="first_name"><h4>Full Name</h4></label>
                                        <input type="text" value="${sessionScope.us.fullName}" class="form-control" name="fullName" id="first_name" placeholder="Full Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="mobile"><h4>Mobile</h4></label>
                                        <input type="text" value="${sessionScope.us.mobile}" class="form-control" name="mobile" id="mobile" placeholder="Mobile Number">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="email"><h4>Email</h4></label>
                                        <input type="email" value="${sessionScope.us.email}" class="form-control" name="email" id="email" placeholder="Email" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="location"><h4>Address</h4></label>
                                        <input type="text" value="${sessionScope.us.address}" class="form-control" name="address" id="location" placeholder="Address">
                                    </div>
                                </div>
                               <%--  <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="gender"><h4>Gender</h4></label>
                                        <%--   <div>
                                            <input name="gender" type="radio" value="1" ${sessionScope.us.gender == true ? 'checked' : ''}/> Male
                                        </div>
                                        <div>
                                            <input name="gender" type="radio" value="0" ${sessionScope.us.gender == false ? 'checked' : ''}/> Female
                                        </div>  
                                    </div>
                                </div> --%> 
                                <input type="hidden" name="userId" value="${sessionScope.us.user_Id}"/>
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <br>
                                        <button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Save</button>
                                        <button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>
                                        <a class="btn btn-lg btn-primary" href="authen?action=changepassword"><i class="glyphicon glyphicon-lock"></i> Change Password</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                function readURL(input) {
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();
                        reader.onload = function (e) {
                            $('#imagePreview').attr('src', e.target.result);
                        }
                        reader.readAsDataURL(input.files[0]);
                    }
                }
                $("#imageUpload").change(function () {
                    readURL(this);
                });
            });
        </script>
    </body>
</html>
