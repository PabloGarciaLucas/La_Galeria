
CREATE DATABASE galeria;

USE galeria;

CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(255) NOT NULL,
    user_passwd VARCHAR(255) NOT NULL,
    user_email VARCHAR(255) UNIQUE NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE roles (
    role_id INT NOT NULL AUTO_INCREMENT,
    user_id INT,
    user_role VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    PRIMARY KEY (role_id)
);

CREATE TABLE categorias (
    ID_Categoria INT NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(255),
    Descripcion TEXT,
    Activo SMALLINT,
    PRIMARY KEY (ID_Categoria)
);

CREATE TABLE pedidos (
    ID_Pedido INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    FechaPedido TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    PRIMARY KEY (ID_Pedido)
);

CREATE TABLE productos (
    ID_Producto INT NOT NULL AUTO_INCREMENT,
    ID_Categoria INT NOT NULL,
    Nombre VARCHAR(255),
    Descripcion TEXT,
    Precio DECIMAL(10, 2),
    CantidadEnStock INT,
    PRIMARY KEY (ID_Producto),
    FOREIGN KEY (ID_Categoria) REFERENCES categorias(ID_Categoria)
);

CREATE TABLE detalles_pedido (
    ID_detalle INT NOT NULL AUTO_INCREMENT,
    ID_Pedido INT NOT NULL,
    ID_Producto INT NOT NULL,
    Cantidad INT,
    PrecioUnitario DECIMAL(10, 2),
    PRIMARY KEY (ID_detalle),
    FOREIGN KEY (ID_Pedido) REFERENCES pedidos(ID_Pedido),
    FOREIGN KEY (ID_Producto) REFERENCES productos(ID_Producto)
);

INSERT INTO users (user_name, user_passwd, user_email) 
VALUES 
('usuario1', 'contrasena1', 'usuario1@example.com'),
('usuario2', 'contrasena2', 'usuario2@example.com'),
('usuario3', 'contrasena3', 'usuario3@example.com');

INSERT INTO roles (user_id, user_role) 
VALUES 
(1, 'Administrador'),
(2, 'Gerente'),
(3, 'Usuario');

INSERT INTO categorias (Nombre, Descripcion, Activo) 
VALUES 
('Cócteles sin alcohol', 'Cócteles refrescantes sin contenido alcohólico', 1),
('Cócteles con alcohol', 'Cócteles con contenido alcohólico para disfrutar con moderación', 1),
('Aperitivos', 'Bebidas para abrir el apetito antes de la comida', 1);

INSERT INTO pedidos (user_id, FechaPedido) 
VALUES 
(1, NOW()),
(2, NOW()),
(3, NOW());

INSERT INTO productos (ID_Categoria, Nombre, Descripcion, Precio, CantidadEnStock) 
VALUES 
(1, 'Piña Colada', 'Deliciosa mezcla de piña, leche de coco y ron', 8.99, 50),
(2, 'Margarita', 'Cóctel refrescante a base de tequila, triple sec y limón', 7.50, 40),
(3, 'Martini', 'Clásico cóctel a base de ginebra y vermut', 9.99, 30);

INSERT INTO detalles_pedido (ID_Pedido, ID_Producto, Cantidad, PrecioUnitario) 
VALUES 
(1, 1, 2, 8.99),
(2, 2, 1, 7.50),
(3, 3, 3, 9.99);
