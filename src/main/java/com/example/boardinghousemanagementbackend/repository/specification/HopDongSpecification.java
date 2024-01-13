package com.example.boardinghousemanagementbackend.repository.specification;

import com.example.boardinghousemanagementbackend.modal.dto.HopDongSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanSearchRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import com.example.boardinghousemanagementbackend.utils.Utils;
import org.springframework.data.jpa.domain.Specification;

public class HopDongSpecification {
    public static Specification<HopDong> buildCondition(HopDongSearchRequest request){
        return Specification.where(buildConditionName(request));
    }

    public static Specification<HopDong> buildConditionName(HopDongSearchRequest request){
        if (!Utils.isBlank(request.getName())){
            // Tạo điều kiện tìm kiếm với name
            return (root, query, cri) -> {
                // root: Chọn cột, field, để tìm kiếm (giá trị là thuộc tính trong java)
                // cri: CriteriaBuilder Khai báo loại so sánh dữ liệu. ( lớn hơn, nhỏ hơn, equal, like,.... )
                return cri.like(root.get("name"), "%" + request.getName() + "%");
            };
        }
        return null;
    }
}
