package com.epw.activities.service.impl;

import com.epw.activities.dto.MenuOptionDto;
import com.epw.activities.entity.MenuOption;
import com.epw.activities.repository.MenuOptionRepository;
import com.epw.activities.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuOptionRepository menuOptionRepository;

    public MenuServiceImpl(MenuOptionRepository menuOptionRepository) {
        this.menuOptionRepository = menuOptionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuOptionDto> getMenuByRoleId(Integer roleId) {
        List<MenuOption> options = menuOptionRepository.findByRoleId(roleId);

        return options.stream()
                .map(opt -> new MenuOptionDto(opt.getName(), opt.getContent()))
                .toList();
    }
}
