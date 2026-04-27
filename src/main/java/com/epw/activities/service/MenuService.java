package com.epw.activities.service;

import com.epw.activities.dto.MenuOptionDto;
import java.util.List;

public interface MenuService {
    List<MenuOptionDto> getMenuByRoleId(Integer roleId);
}
