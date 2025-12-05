 Arquitectura Técnica - Nicole's Decoraciones

Diagrama de Arquitectura

 Vista de Alto Nivel:
```mermaid
graph TB
    subgraph "Cliente"
        A[Usuario/Nicole<br/>Navegador Web]
    end
    
    subgraph "Frontend"
        B[Páginas JSP<br/>formulario.jsp<br/>lista-clientes.jsp]
        C[Bootstrap 5<br/>CSS/JavaScript]
    end
    
    subgraph "Backend"
        D[Servlets<br/>FormularioServlet<br/>ListaClientesServlet]
        E[Modelos<br/>Cliente.java]
        F[DAO<br/>ClienteDAO.java]
    end
    
    subgraph "Persistencia"
        G[MySQL Database<br/>XAMPP]
    end
    
    subgraph "Infraestructura"
        H[GlassFish Server]
        I[GitHub Actions CI/CD]
        J[Drone CI]
    end
    
    A --> B
    B --> D
    D --> E
    D --> F
    F --> G
    H --> B
    H --> D
    I --> K[Repositorio GitHub]
    J --> K
    
    style A fill:#e1f5fe
    style B fill:#f3e5f5
    style D fill:#e8f5e8
    style G fill:#fff3e0
    style H fill:#fce4ec
