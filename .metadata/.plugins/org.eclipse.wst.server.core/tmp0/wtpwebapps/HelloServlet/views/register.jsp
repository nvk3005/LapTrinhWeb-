<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Form Đăng Ký</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- Thông báo lỗi -->
	<c:if test="${alert != null}">
		<div class="alert alert-danger text-center">${alert}</div>
	</c:if>
	<div class="container py-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card shadow-sm">
					<div class="card-body">
						<h3 class="card-title text-center mb-4">Tạo tài khoản mới</h3>
						<form action="register" method="post">
							<div class="mb-3">
								<label for="inputUsername" class="form-label">Tên đăng
									nhập</label> <input type="text" class="form-control" id="inputUsername"
									name="username" placeholder="Tên đăng nhập">
							</div>
							<div class="mb-3">
								<label for="inputFullName" class="form-label">Họ tên</label> <input
									type="text" class="form-control" id="inputFullName"
									name="fullname" placeholder="Họ tên">
							</div>
							<div class="mb-3">
								<label for="inputEmail" class="form-label">Email</label> <input
									type="email" class="form-control" id="inputEmail" name="email"
									placeholder="Nhập Email">
							</div>
							<div class="mb-3">
								<label for="inputPhone" class="form-label">Số điện thoại</label>
								<input type="tel" class="form-control" id="inputPhone"
									name="phone" placeholder="Nhập số điện thoại">
							</div>
							<div class="mb-3">
								<label for="inputPassword" class="form-label">Mật khẩu</label> <input
									type="password" class="form-control" id="inputPassword"
									name="password" placeholder="Mật khẩu">
							</div>
							<button type="submit" class="btn btn-primary w-100">Tạo
								tài khoản</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS (tùy chọn) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
