package org.sistcoop.socio.representations.idm;

import java.io.Serializable;
import java.math.BigDecimal;

public class TasaCuentaPersonalRepresentation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String denominacion;
    private BigDecimal valor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
