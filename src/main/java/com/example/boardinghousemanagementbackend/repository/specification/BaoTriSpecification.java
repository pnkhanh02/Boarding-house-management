package com.example.boardinghousemanagementbackend.repository.specification;

import com.example.boardinghousemanagementbackend.modal.dto.BaoTriSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.YeuCauSearchRequest;
import com.example.boardinghousemanagementbackend.modal.entity.BaoTri;
import com.example.boardinghousemanagementbackend.modal.entity.YeuCau;
import com.example.boardinghousemanagementbackend.utils.Utils;
import org.springframework.data.jpa.domain.Specification;

public class BaoTriSpecification {
    public static Specification<BaoTri> buildCondition(BaoTriSearchRequest request){
        return Specification.where(buildConditionDate(request));
    }

    public static Specification<BaoTri> buildConditionDate(BaoTriSearchRequest request){
        if (request.getMaintenanceDate() != null){
            // Tạo điều kiện tìm kiếm với name
            return (root, query, cri) -> {
                // root: Chọn cột, field, để tìm kiếm (giá trị là thuộc tính trong java)
                // cri: CriteriaBuilder Khai báo loại so sánh dữ liệu. ( lớn hơn, nhỏ hơn, equal, like,.... )
                return cri.equal(root.get("maintenanceDate"), request.getMaintenanceDate() );
            };
        }
        return null;
    }
}
