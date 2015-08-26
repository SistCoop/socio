package org.sistcoop.socio.representations.idm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CuentaPersonalRepresentation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String tipoCuenta;
    private String numeroCuenta;
    private String moneda;
    private Date fechaApertura;
    private Date fechaCierre;
    private BigDecimal saldo;
    private int cantidadRetirantes;
    private String estado;

    private TitularRepresentation[] titulares;
    private TasaCuentaPersonalRepresentation[] tasas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public int getCantidadRetirantes() {
        return cantidadRetirantes;
    }

    public void setCantidadRetirantes(int cantidadRetirantes) {
        this.cantidadRetirantes = cantidadRetirantes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TitularRepresentation[] getTitulares() {
        return titulares;
    }

    public void setTitulares(TitularRepresentation[] titulares) {
        this.titulares = titulares;
    }

    public TasaCuentaPersonalRepresentation[] getTasas() {
        return tasas;
    }

    public void setTasas(TasaCuentaPersonalRepresentation[] tasas) {
        this.tasas = tasas;
    }

}
