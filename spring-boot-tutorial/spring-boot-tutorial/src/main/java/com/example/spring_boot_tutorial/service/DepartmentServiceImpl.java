package com.example.spring_boot_tutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.spring_boot_tutorial.dto.DepartmentDTO;
import com.example.spring_boot_tutorial.entity.Department;
import com.example.spring_boot_tutorial.error.DepartmentNotFound;
import com.example.spring_boot_tutorial.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // 🔹 Save: Also update cache
    @Override
    @CachePut(value = "department", key = "#result.departmentId")
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // 🔹 Fetch all: Cache entire list
    @Override
    @Cacheable(value = "departments")
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    // 🔹 Fetch by ID: Cache each by ID
    @Override
    @Cacheable(value = "department", key = "#departmetnId")
    public Department fetchDepartmentFetchById(Long departmetnId) throws DepartmentNotFound {
        Optional<Department> dept = departmentRepository.findById(departmetnId);
        System.out.println("called from DB");
        if (!dept.isPresent()) {
            throw new DepartmentNotFound("Department not available");
        }
        return dept.get();
    }

    // 🔹 Delete by ID: Evict from cache
    @Override
    @CacheEvict(value = "department", key = "#departmetnId")
    public void deleteDepartmentById(Long departmetnId) {
        departmentRepository.deleteById(departmetnId);
    }

    // 🔹 Update by ID: Update cache as well
    @Override
    @CachePut(value = "department", key = "#departmetnId")
    public Department updateDepartmentById(Long departmetnId, Department department) {
        Department deptDB = departmentRepository.findById(departmetnId).get();

        if (Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName())) {
            deptDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddres()) && !"".equals(department.getDepartmentAddres())) {
            deptDB.setDepartmentAddres(department.getDepartmentAddres());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode())) {
            deptDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(deptDB);
    }

    // 🔹 Custom find by name (optional cache)
    @Override
    @Cacheable(value = "departmentByName", key = "#departmentName")
    public Department fetchDistinctByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    // 🔹 List by name (optional cache)
    @Override
    @Cacheable(value = "departmentListByName", key = "#departmentName")
    public List<DepartmentDTO> fetchDepartmentListFetchByName(String departmentName) {
        return departmentRepository.findDistinctByDepartmentName(departmentName);
    }
}
