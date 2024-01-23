package com.example.boardinghousemanagementbackend.service.impl;

import com.example.boardinghousemanagementbackend.exception.CustomException;
import com.example.boardinghousemanagementbackend.exception.ErrorResponseEnum;
import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import com.example.boardinghousemanagementbackend.repository.TaiKhoanRepository;
import com.example.boardinghousemanagementbackend.repository.specification.PhongSpecification;
import com.example.boardinghousemanagementbackend.repository.specification.TaiKhoanSpecification;
import com.example.boardinghousemanagementbackend.service.ITaiKhoanService;
import com.example.boardinghousemanagementbackend.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanService implements ITaiKhoanService, UserDetailsService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public List<TaiKhoan> getAll() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public Page<TaiKhoan> search(TaiKhoanSearchRequest request) {
        PageRequest pageRequest = Utils.buildPageRequest(request);
        Specification<TaiKhoan> specification = TaiKhoanSpecification.buildCondition(request);
        return taiKhoanRepository.findAll(specification, pageRequest);
    }

    @Override
    public int getNumberOfTaiKhoan() {
        return taiKhoanRepository.findAll().size();
    }

    @Override
    public TaiKhoan getById(Long id) {
        Optional<TaiKhoan> optionalTaiKhoan = taiKhoanRepository.findById(id);
        if(optionalTaiKhoan.isPresent()){
            return optionalTaiKhoan.get();
        }
        return null;
    }

    @Override
    public void delete(long id) {
        taiKhoanRepository.deleteById(id);
    }

    @Override
    public TaiKhoan create(TaiKhoanCreateRequest request) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //Kiểm tra tất cả các dữ liệu đầu vào
        //Nếu không thỏa mãn -> throw ra lỗi
        String regex = "^[a-zA-Z0-9]*$";
        boolean checkedUserName = request.getUsername().matches(regex);
        if(!checkedUserName){
            throw new CustomException(ErrorResponseEnum.USERNAME_EXISTED);
        }


        if(taiKhoanRepository.existsByUsername(request.getUsername())){
            throw new CustomException(ErrorResponseEnum.USERNAME_EXISTED);
        }
        TaiKhoan taiKhoan = new TaiKhoan();
        BeanUtils.copyProperties(request, taiKhoan);
        //Set lại mật khẩu đã được mã hóa
        taiKhoan.setPassword(passwordEncoder.encode(request.getPassword()));
        return taiKhoanRepository.save(taiKhoan);
    }

    @Override
    public TaiKhoan update(TaiKhoanUpdateRequest request) {
        TaiKhoan taiKhoan = getById(request.getId());
        if(taiKhoan != null){
            BeanUtils.copyProperties(request, taiKhoan);
            return taiKhoanRepository.save(taiKhoan);
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<TaiKhoan> accountOptional = taiKhoanRepository.findByUsername(username);
        if(accountOptional.isPresent()){
            List<GrantedAuthority> authorities = new ArrayList<>();
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(accountOptional.get().getRole().toString());

            authorities.add(accountOptional.get().getRole());
            return new User(username, accountOptional.get().getPassword(), authorities);
        }else{
            throw new UsernameNotFoundException(username);
        }
    }
}
