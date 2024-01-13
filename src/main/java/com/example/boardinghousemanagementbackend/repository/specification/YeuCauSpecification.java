package com.example.boardinghousemanagementbackend.repository.specification;

import com.example.boardinghousemanagementbackend.modal.dto.HopDongSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.YeuCauSearchRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.YeuCau;
import com.example.boardinghousemanagementbackend.utils.Utils;
import org.springframework.data.jpa.domain.Specification;

public class YeuCauSpecification {
    public static Specification<YeuCau> buildCondition(YeuCauSearchRequest request){
        return Specification.where(buildConditionTitle(request));
    }

    public static Specification<YeuCau> buildConditionTitle(YeuCauSearchRequest request){
        if (!Utils.isBlank(request.getTitle())){
            // Tạo điều kiện tìm kiếm với name
            return (root, query, cri) -> {
                // root: Chọn cột, field, để tìm kiếm (giá trị là thuộc tính trong java)
                // cri: CriteriaBuilder Khai báo loại so sánh dữ liệu. ( lớn hơn, nhỏ hơn, equal, like,.... )
                return cri.like(root.get("title"), "%" + request.getTitle() + "%");
            };
        }
        return null;
    }
}
