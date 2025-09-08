<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Danh mục mới</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">
                <div class="card shadow">
                    <div class="card-header bg-success text-white text-center py-3">
                        <h4 class="mb-0"><i class="bi bi-plus-circle me-2"></i>Thêm Danh mục mới</h4>
                    </div>
                    <div class="card-body p-4">
                        <form action="add" method="post" enctype="multipart/form-data">
                            
                            <!-- Tên danh mục -->
                            <div class="mb-3">
                                <label class="form-label fw-bold">Tên danh mục:</label>
                                <input type="text" class="form-control" name="name" required>
                                <div class="form-text text-muted">Nhập tên danh mục.</div>
                            </div>
                            
                            <!-- Ảnh đại diện -->
                            <div class="mb-4">
                                <label class="form-label fw-bold">Ảnh đại diện:</label>
                                <input type="file" class="form-control" name="icon" accept="image/*" required>
                                <div class="form-text text-muted">Chọn ảnh từ máy tính của bạn.</div>
                            </div>
                            
                            <!-- Nút thao tác -->
                            <div class="d-flex justify-content-between mt-4">
                                <a href="<c:url value='/category/list'/>" class="btn btn-secondary">
                                    <i class="bi bi-arrow-left me-1"></i> Quay lại
                                </a>
                                <div>
                                    <button type="reset" class="btn btn-outline-danger me-2">
                                        <i class="bi bi-arrow-clockwise me-1"></i> Đặt lại
                                    </button>
                                    <button type="submit" class="btn btn-success">
                                        <i class="bi bi-check-circle me-1"></i> Thêm mới
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                
                <!-- Hiển thị thông báo -->
                <c:if test="${not empty message}">
                    <div class="alert alert-success alert-dismissible fade show mt-4" role="alert">
                        <i class="bi bi-check-circle-fill me-2"></i> ${message}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                </c:if>
                
                <c:if test="${not empty error}">
                    <div class="alert alert-danger alert-dismissible fade show mt-4" role="alert">
                        <i class="bi bi-exclamation-triangle-fill me-2"></i> ${error}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                </c:if>
            </div>
        </div>
    </div>

    <!-- Bootstrap 5 JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
