 Manual de Usuario - Nicole's Decoraciones

Página Principal
**URL:** `http://localhost:8080/NicolesDecoracionesWeb/`

 Opciones disponibles:
1. **Nueva Reservación** - Registrar nuevo cliente
2. **Ver Reservaciones** - Listado de todos los clientes

## Registrar Nueva Reservación

### Paso 1: Acceder al formulario
- Click en **" Nueva Reservación"**

### Paso 2: Completar datos del cliente
Nombre: [María González]
Teléfono: [555-1234]
Email: [maria@email.com] (opcional)
Evento: [Seleccionar tipo]
Fecha: [Seleccionar fecha]

### Paso 3: Enviar formulario
- Click en **"Registrar Reservación"**

###  Mensajes posibles:
- ** Éxito:** "RESERVACIÓN EXITOSA"
- ** Error:** "FECHA RESERVADA - Seleccione otra"

##  Ver Reservaciones Existentes

### Paso 1: Acceder al listado
- Click en **" Ver Reservaciones"**

### Paso 2: Ver información
La tabla muestra:
- Nombre del cliente
- Teléfono de contacto
- Email (si proporcionó)
- Tipo de evento
- Fecha reservada
- Fecha de registro

##  Solución de Problemas Comunes

### Problema: No carga la página
**Solución:**
1. Verificar que GlassFish esté iniciado
2. Recargar página (F5)
3. Acceder a: `http://localhost:8080/NicolesDecoracionesWeb/`

### Problema: Fecha muestra "Reservada"
**Solución:**
1. Seleccionar otra fecha en el calendario
2. Verificar en "Listado de Reservaciones" qué fecha está ocupada

### Problema: No se guardan los datos
**Solución:**
1. Verificar que MySQL (XAMPP) esté iniciado
2. Completar todos los campos obligatorios (*)

## Backup de Datos (Recomendado)

### Backup manual:
1. Abrir phpMyAdmin (`http://localhost/phpmyadmin`)
2. Seleccionar base `nicoles_decoraciones`
3. Click en "Exportar"
4. Seleccionar "SQL"
5. Click en "Continuar"

### Frecuencia recomendada:
- **Diario:** Si usas el sistema frecuentemente
- **Semanal:** Si es uso ocasional

## Soporte Técnico

### Contacto:
- **Desarrolladora:** Alejandra Salas Ruiz
- **Para reportes:** 3328514374

### Horarios de soporte:
- Lunes a Viernes: 9:00 AM - 6:00 PM
- Respuesta en máximo: 24 horas

---

*Última actualización: Enero 2024*
