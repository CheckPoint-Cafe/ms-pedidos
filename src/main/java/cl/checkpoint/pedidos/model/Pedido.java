package cl.checkpoint.pedidos.model;

import jakarta.persistence.*;

@Entity
public class Pedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long clienteId;
  private String producto;
  private Integer cantidad;
  private String estado;

  public Long getId() {
    return id;
  }

  public Long getClienteId() {
    return clienteId;
  }

  public void setClienteId(Long value) {
    this.clienteId = value;
  }

  public String getProducto() {
    return producto;
  }

  public void setProducto(String value) {
    this.producto = value;
  }

  public Integer getCantidad() {
    return cantidad;
  }

  public void setCantidad(Integer value) {
    this.cantidad = value;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String value) {
    this.estado = value;
  }
}
