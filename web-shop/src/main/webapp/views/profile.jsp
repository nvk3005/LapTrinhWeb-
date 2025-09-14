<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="container mt-5">
  <div class="card shadow">
    <div class="card-header text-center">
      <h4>Cập nhật thông tin cá nhân</h4>
    </div>
    <div class="card-body">
      <form action="${pageContext.request.contextPath}/updateProfile" method="post" enctype="multipart/form-data">
        
        <!-- Avatar -->
        <div class="form-group text-center">
          <img src="${sessionScope.account.avatar != null ? sessionScope.account.avatar : 'https://via.placeholder.com/120'}"
               alt="Avatar"
               class="rounded-circle img-thumbnail mb-3"
               width="120" height="120">
          <div>
            <input type="file" class="form-control-file" name="avatar">
          </div>
        </div>

        <!-- Fullname -->
        <div class="form-group">
          <label for="fullname">Họ và tên</label>
          <input type="text" class="form-control" id="fullname" name="fullname"
                 value="${sessionScope.account.fullname}" required>
        </div>

        <!-- Phone -->
        <div class="form-group">
          <label for="phone">Số điện thoại</label>
          <input type="text" class="form-control" id="phone" name="phone"
                 value="${sessionScope.account.phone}" required>
        </div>

        <!-- Submit -->
        <button type="submit" class="btn btn-primary btn-block">Lưu thay đổi</button>
      </form>
    </div>
  </div>
</div>
    