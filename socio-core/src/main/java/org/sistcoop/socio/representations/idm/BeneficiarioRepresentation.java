package org.sistcoop.socio.representations.idm;

import java.io.Serializable;
import java.math.BigDecimal;

public class BeneficiarioRepresentation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private BigDecimal porcentajeBeneficio;
    private String tipoDocumento;
    private String numeroDocumento;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPorcentajeBeneficio() {
        return porcentajeBeneficio;
    }

    public void setPorcentajeBeneficio(BigDecimal porcentajeBeneficio) {
        this.porcentajeBeneficio = porcentajeBeneficio;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

}
