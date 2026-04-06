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

## 🚀 Quick Start

### 1. Compilar el Proyecto

```bash
cd /workspaces/actividad-4punto1
javac src/main/java/*.java -d target/
```

### 2. Ejecutar la Aplicación

```bash
java -cp target/ Main
```


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

## ✅ Mejoras Realizadas

### A partir del código original:

1. **Refactorización de Main.java**
   - Métodos más pequeños y enfocados
   - Mejor separación de responsabilidades
   - Manejo mejorado de recursos (Scanner)

2. **Documentación**
   - JavaDoc en todas las clases
   - Explicación de métodos complejos
   - Documentación de parámetros y retornos

3. **Validación**
   - Validación de parámetros null
   - Excepciones informativas
   - Validación preventiva en setters

4. **Organización**
   - Estructura Maven-like
   - Separación clara de componentes
   - Preparada para crecimiento

---

## 🛠️ Mantenimiento

### Limpiar compilación
```bash
rm -rf target/
mkdir target/
```

### Verificar compilación
```bash
javac -Xlint:all src/main/java/*.java -d target/
```

### Listar clases compiladas
```bash
ls target/
```

---

## 📜 Licencia

Este proyecto es privado. Para uso académico/educativo.

---

## 👨‍💻 Autor

Desarrollado como actividad de formación en Clean Code y buenas prácticas.

---

## 🤝 Contribuciones

Sigue los estándares definidos en [CLEAN_CODE.md](CLEAN_CODE.md) y [STANDARDS.md](STANDARDS.md).

---

## 📞 Soporte

Para preguntas sobre:
- **Estructura**: Ver [ESTRUCTURA.md](ESTRUCTURA.md)
- **Compilación**: Ver [COMPILACION.md](COMPILACION.md)
- **Clean Code**: Ver [CLEAN_CODE.md](CLEAN_CODE.md)
- **Estándares**: Ver [STANDARDS.md](STANDARDS.md)