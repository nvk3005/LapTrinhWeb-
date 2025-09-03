<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Đăng nhập</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body class="bg-light">

  <div class="container d-flex justify-content-center align-items-center vh-100">
    <form action="login" method="post" class="p-4 shadow rounded bg-white" style="min-width: 350px;">
      <h2 class="text-center mb-4">Tạo tài khoản mới</h2>

      <!-- Thông báo lỗi -->
      <c:if test="${alert != null}">
        <div class="alert alert-danger text-center">
          ${alert}
        </div>
      </c:if>

      <!-- Username -->
      <div class="mb-3">
        <label class="form-label">Tài khoản</label>
        <div class="input-group">
          <span class="input-group-text"><i class="fa fa-user"></i></span>
          <input type="text" placeholder="Tài khoản" name="username" class="form-control">
        </div>
      </div>

      <!-- Password -->
      <div class="mb-3">
        <label class="form-label">Mật khẩu</label>
        <div class="input-group">
          <span class="input-group-text"><i class="fa fa-lock"></i></span>
          <input type="password" placeholder="Mật khẩu" name="password" class="form-control">
        </div>
      </div>

      <!-- Nút submit -->
      <div class="d-grid">
        <button type="submit" class="btn btn-primary">Đăng nhập</button>
      </div>
    </form>
  </div>

</body>
</html>
