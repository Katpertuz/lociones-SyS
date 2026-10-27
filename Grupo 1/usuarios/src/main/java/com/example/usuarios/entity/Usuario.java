package com.example.usuarios.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

public class Usuario {
    @Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    @Column(nullable = false)
    private Boolean activo = true;

    // Preferencias de accesibilidad (en camelCase)
    @Column(name = "tamano_texto", nullable = false)
    private String tamanoTexto = "NORMAL";

    @Column(name = "lectura_en_voz", nullable = false)
    private Boolean lecturaEnVoz = false;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public Usuario() {}

    public Usuario(String nombre, String email, String password, Rol rol) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.activo = true;
        this.tamanoTexto = "NORMAL";
        this.lecturaEnVoz = false;
    }

    // Getters y Setters (en camelCase)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public String getTamanoTexto() { return tamanoTexto; }
    public void setTamanoTexto(String tamanoTexto) { this.tamanoTexto = tamanoTexto; }

    public Boolean getLecturaEnVoz() { return lecturaEnVoz; }
    public void setLecturaEnVoz(Boolean lecturaEnVoz) { this.lecturaEnVoz = lecturaEnVoz; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}

}
