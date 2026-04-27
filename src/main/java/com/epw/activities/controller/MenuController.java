package com.epw.activities.controller;

import com.epw.activities.dto.MenuOptionDto;
import com.epw.activities.service.MenuService;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "http://localhost:5173")
public class MenuController {

    // Mapeo de roleId (número) a nombre del rol
    private static final Map<Integer, String> ROLE_MAP = Map.of(
        1,
        "ADMIN",
        2,
        "CUSTOMER",
        3,
        "PROVIDER"
    );

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{roleId}")
    public List<MenuOptionDto> getMenuByRole(
        @PathVariable Integer roleId,
        Authentication authentication
    ) {
        // Validar que el roleId existe en el mapa
        String expectedRole = ROLE_MAP.get(roleId);
        if (expectedRole == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Role ID inválido: " + roleId
            );
        }

        // Obtener el rol del usuario autenticado (formato "ROLE_ADMIN")
        String userRole = authentication
            .getAuthorities()
            .stream()
            .map(GrantedAuthority::getAuthority)
            .findFirst()
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "No se encontró rol para el usuario"
                )
            );

        // userRole viene como "ROLE_ADMIN", extraemos solo "ADMIN"
        String roleName = userRole.replace("ROLE_", "");

        // Validar que el roleId solicitado coincida con el rol del usuario
        if (!roleName.equals(expectedRole)) {
            throw new ResponseStatusException(
                HttpStatus.FORBIDDEN,
                "No tienes permiso para acceder al menú de este rol"
            );
        }

        return menuService.getMenuByRoleId(roleId);
    }
}
