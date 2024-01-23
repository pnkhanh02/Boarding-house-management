package com.example.boardinghousemanagementbackend.repository.specification;

import com.example.boardinghousemanagementbackend.modal.dto.PhongSearchRequest;
import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import com.example.boardinghousemanagementbackend.utils.Utils;
import org.springframework.data.jpa.domain.Specification;

public class PhongSpecification {
    public static Specification<Phong> buildCondition(PhongSearchRequest request){
        return Specification.where(buildConditionTitle(request))
                .and(buildConditionAddress(request))
                .and(buildConditionArea(request))
                .and(buildConditionPrice(request));
    }

    public static Specification<Phong> buildConditionTitle(PhongSearchRequest request){
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

    public static Specification<Phong> buildConditionAddress(PhongSearchRequest request){
        if (!Utils.isBlank(request.getAddress())){
            // Tạo điều kiện tìm kiếm với name
            return (root, query, cri) -> {
                // root: Chọn cột, field, để tìm kiếm (giá trị là thuộc tính trong java)
                // cri: CriteriaBuilder Khai báo loại so sánh dữ liệu. ( lớn hơn, nhỏ hơn, equal, like,.... )
                return cri.like(root.get("address"), "%" + request.getAddress() + "%");
            };
        }
        return null;
    }

    public static Specification<Phong> buildConditionArea(PhongSearchRequest request){
        if (request.getArea() != null){
            // Tạo điều kiện tìm kiếm với name
            return (root, query, cri) -> {
                // root: Chọn cột, field, để tìm kiếm (giá trị là thuộc tính trong java)
                // cri: CriteriaBuilder Khai báo loại so sánh dữ liệu. ( lớn hơn, nhỏ hơn, equal, like,.... )
                return cri.equal(root.get("area"),  request.getArea() );
            };
        }
        return null;
    }

    public static Specification<Phong> buildConditionPrice(PhongSearchRequest request){
        if (request.getPrice() != null){
            // Tạo điều kiện tìm kiếm với name
            return (root, query, cri) -> {
                // root: Chọn cột, field, để tìm kiếm (giá trị là thuộc tính trong java)
                // cri: CriteriaBuilder Khai báo loại so sánh dữ liệu. ( lớn hơn, nhỏ hơn, equal, like,.... )
                return cri.equal(root.get("price"), request.getPrice() );
            };
        }
        return null;
    }
}
