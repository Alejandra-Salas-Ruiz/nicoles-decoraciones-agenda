#  Changelog - Nicole's Decoraciones

Todos los cambios notables en este proyecto serán documentados en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/es-ES/1.0.0/),
y este proyecto adhiere a [Versionado Semántico](https://semver.org/lang/es/).

## [1.0.0-beta] - 2025-12-05

### Agregado
- Estructura inicial del proyecto Java Web con GlassFish
- Conexión a base de datos MySQL con XAMPP
- Formulario de registro de clientes (formulario.jsp)
- Validación de fechas ocupadas en tiempo real
- Listado de reservaciones existentes (lista-clientes.jsp)
- Documentación completa del proyecto
- Integración CI/CD con GitHub Actions y Drone CI
- Gestión de proyecto con Gitlo (GitHub + Trello integration)
- Sistema de automatización con reglas en Trello
- Arquitectura MVC con Servlets y JSP

### Changed
- Migración de aplicación de consola a web
- Actualización de stack tecnológico a Java EE 7
- Implementación de patrón DAO para persistencia
- Mejora en la estructura de paquetes del proyecto

### Fixed
- Configuración de driver MySQL para conexión a base de datos
- Validación de formato de fechas en formulario
- Organización de branches en repositorio GitHub

## [0.1.0] - 2025-12-04

### Agregado
- Configuración inicial del repositorio GitHub
- Creación de branches main y develop
- 5 Issues detallados con milestones (Beta v1.0, GA v1.0)
- Project Board en GitHub Projects
- Archivos de documentación base (README, LICENSE, .gitignore)
- Configuración de GitHub Actions para CI/CD
- Integración con Drone CI para pipelines
- Tablero Trello con automatizaciones
- Documentación arquitectónica completa


---

## Próximos Cambios Planeados

### Para versión 1.0.0-GA (Diciembre 2025):
- Sistema de autenticación básica para Nicole
- Mejoras en la interfaz de usuario con Bootstrap
- Exportación de listados a formato PDF
- Sistema de backup automático de base de datos
- Pruebas unitarias completas con JUnit

### Para versión 1.1.0 (Enero 2026):
- Calendario visual interactivo
- Notificaciones por email automáticas
- Búsqueda avanzada de clientes
- Dashboard con estadísticas básicas

---

##  Notas de Versionado

### Versiones:
- **Major (1.X.X):** Cambios incompatibles con versiones anteriores
- **Minor (X.1.X):** Nuevas funcionalidades compatibles
- **Patch (X.X.1):** Correcciones de bugs compatibles

### Estado Actual:
- **Versión actual:** 1.0.0-beta (en desarrollo)
- **Próxima versión:** 1.0.0-GA (planeada para Diciembre 2025)
- **Estabilidad:** Beta - Para pruebas internas

### Política de soporte:
- **Versión actual:** Soporte completo durante desarrollo
- **Versión anterior:** Soporte crítico solamente
- **Versiones más antiguas:** Sin soporte oficial

---

*Este CHANGELOG se actualiza con cada release importante. Última actualización: 5/12/2025*
