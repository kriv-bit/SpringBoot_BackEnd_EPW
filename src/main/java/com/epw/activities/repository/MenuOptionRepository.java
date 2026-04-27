package com.epw.activities.repository;

import com.epw.activities.entity.MenuOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuOptionRepository extends JpaRepository<MenuOption, Long> {
    List<MenuOption> findByRoleId(Integer roleId);
}
