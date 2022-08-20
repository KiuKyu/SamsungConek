package com.samsungconek.service.role;

import com.samsungconek.model.entity.Role;
import com.samsungconek.repository.IRoleRepository;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        List<Role> roles = roleRepository.findAll();
        BusinessAssert.isTrue(roles.size() > 0, BusinessExceptionCode.EMPTY_LIST, "Danh sách rỗng");
        return roles;
    }

    @Override
    public Role findById(Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        BusinessAssert.isTrue(roleOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return roleOptional.get();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public CustomResponse deleteById(Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        BusinessAssert.isTrue(roleOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        roleRepository.deleteById(id);
        return new CustomResponse("Thành công", 1);
    }

    @Override
    public Role update(Long id, Role newRole) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        BusinessAssert.isTrue(roleOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return roleRepository.save(newRole);
    }
}
