package com.santiago.companylist.models;

public class Contact {

    private Integer id;
    private String categoria;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String pagina;
    private String picture;
    private String detalle;

    // declaramos un constructor


    public Contact(Integer id, String categoria, String nombre, String direccion, String telefono, String email, String pagina, String picture, String detalle) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.pagina = pagina;
        this.picture = picture;
        this.detalle = detalle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }


//metodo to string  un objeto convertirlo a un string -----que avlor tiene un objeto


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", pagina='" + pagina + '\'' +
                ", picture='" + picture + '\'' +
                ", detalle='" + detalle + '\'' +
                '}';
    }
}
