-- ============================================================
-- SCRIPT PARA POBLAR BASE DE DATOS - activities_db
-- Roles: 1=ADMIN, 2=CUSTOMER, 3=PROVIDER
-- ============================================================

-- -------------------------------------------
-- 1. USUARIOS DE PRUEBA
-- Contraseña de todos: "123" (BCrypt hash)
-- -------------------------------------------
INSERT INTO app_user (username, password, role)
VALUES
    ('admin_user',    '$2a$10$INSVdcU4PuPdMfwLHEa3wOqeoYL9nG9bJChKqANLNKZzOmzIHaxBa', 'ADMIN'),
    ('customer_user', '$2a$10$INSVdcU4PuPdMfwLHEa3wOqeoYL9nG9bJChKqANLNKZzOmzIHaxBa', 'CUSTOMER'),
    ('provider_user', '$2a$10$INSVdcU4PuPdMfwLHEa3wOqeoYL9nG9bJChKqANLNKZzOmzIHaxBa', 'PROVIDER');

-- -------------------------------------------
-- 2. OPCIONES DE MENÚ POR ROL
-- roleId: 1=ADMIN, 2=CUSTOMER, 3=PROVIDER
-- -------------------------------------------
INSERT INTO menu_option (name, content, role_id)
VALUES
    -- Admin (roleId=1) → acceso a todo
    ('customers',   'Customers',   1),
    ('departments', 'Departments', 1),
    ('providers',   'Providers',   1),
    ('users',       'Usuarios',    1),
    ('test',        'Prueba',      1),
    ('abtme',       'About Me',    1),
	('dashboard',   'Dashboard',   1),


    -- Customer (roleId=2) → solo customers y about me
    ('customers',   'Customers',   2),
    ('abtme',       'About Me',    2),

    -- Provider (roleId=3) → solo providers y about me
	('dashboard',   'Dashboard',   3),
    ('providers',   'Providers',   3),
    ('abtme',       'About Me',    3);
