<img width="1114" height="981" alt="Diagrama sin título-Ejercicio 1 drawio" src="https://github.com/user-attachments/assets/bfe7c2ed-7934-49b9-be19-81f108f5c012" />
# 🛒 Sistema de E-Commerce - Carrito de Compras

## 📝 Descripción

Sistema completo de e-commerce con gestión de:
- **Catálogo** de productos
- **Carrito** de compras
- **Procesamiento** de pagos con tarjeta
- **Gestión** de envíos y transportadoras
- **Registro** de quejas de clientes

---

## 📁 Estructura del Proyecto

```
actividad-4punto1/
├── src/
│   └── main/
│       ├── java/                    # Código fuente Java
│       │   ├── Main.java           # Punto de entrada
│       │   ├── Cliente.java
│       │   ├── Carrito.java
│       │   ├── Catalogo.java
│       │   ├── Producto.java
│       │   ├── Pedido.java
│       │   ├── EstadoPedido.java   # Enum de estados
│       │   ├── Pago.java           # Clase abstracta
│       │   ├── PagoTarjeta.java
│       │   ├── Envio.java
│       │   ├── Transportadora.java
│       │   ├── Queja.java
│       │   └── GestionarQueja.java
│       └── js/                      # Código fuente JavaScript
│           └── EstadoPedido.js     # Enums en JavaScript
├── target/                          # Archivos compilados (.class)
├── .gitignore                       # Archivos a ignorar en Git
├── README.md                        # Este archivo
├── ESTRUCTURA.md                    # Documentación estructura proyecto
├── COMPILACION.md                   # Guía compilación y ejecución
├── CLEAN_CODE.md                    # Mejoras de Clean Code
├── STANDARDS.md                     # Estándares por lenguaje
└── .git/                            # Repositorio Git
```

---


## 📊 Clases Principales

### Dominio (Modelos)
- `Cliente` - Información y operaciones del cliente
- `Producto` - Datos del producto
- `Carrito` - Gestión del carrito de compras
- `Pedido` - Información del pedido
- `Pago` (abstracta) / `PagoTarjeta` - Procesamiento de pagos
- `Transportadora` - Información de envíos
- `Queja` / `GestionarQueja` - Gestión de quejas

### Utilidades
- `Main` - Orquestación del flujo de aplicación
- `Catalogo` - Gestión del catálogo de productos
- `Envio` - Gestión de envíos
- `EstadoPedido` - Enum de estados

---

## 📝 Flujo de la Aplicación

```
1. Crear Catálogo
   ↓
2. Registrar Cliente
   ↓
3. Llenar Carrito (múltiples productos)
   ↓
4. Procesar Pago (validación tarjeta)
   ↓
5. Crear Pedido
   ↓
6. Despachar Envío
   ↓
7. Opcionalmente: Registrar Queja
```

---
