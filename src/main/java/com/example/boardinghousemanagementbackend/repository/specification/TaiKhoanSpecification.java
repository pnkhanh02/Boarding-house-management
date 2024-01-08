package com.example.boardinghousemanagementbackend.repository.specification;

import com.example.boardinghousemanagementbackend.modal.dto.PhongSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanSearchRequest;
import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import com.example.boardinghousemanagementbackend.utils.Utils;
import org.springframework.data.jpa.domain.Specification;

public class TaiKhoanSpecification {
    public static Specification<TaiKhoan> buildCondition(TaiKhoanSearchRequest request){
        return Specification.where(buildConditionUsername(request));
    }

    public static Specification<TaiKhoan> buildConditionUsername(TaiKhoanSearchRequest request){
        if (!Utils.isBlank(request.getUsername())){
            // Tạo điều kiện tìm kiếm với name
            return (root, query, cri) -> {
                // root: Chọn cột, field, để tìm kiếm (giá trị là thuộc tính trong java)
                // cri: CriteriaBuilder Khai báo loại so sánh dữ liệu. ( lớn hơn, nhỏ hơn, equal, like,.... )
                return cri.like(root.get("username"), "%" + request.getUsername() + "%");
            };
        }
        return null;
    }
}
