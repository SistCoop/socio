package org.sistcoop.socio.representations.idm;

import java.io.Serializable;
import java.util.Date;

public class SocioRepresentation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String tipoPersona;
    private String tipoDocumento;
    private String numeroDocumento;

    private String tipoDocumentoRepresentanteLegal;
    private String numeroDocumentoRepresentanteLegal;

    private Date fechaInicio;
    private Date fechaFin;
    private boolean estado;

    private CuentaAporteRepresentation cuentaAporte;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
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

    public String getTipoDocumentoRepresentanteLegal() {
        return tipoDocumentoRepresentanteLegal;
    }

    public void setTipoDocumentoRepresentanteLegal(String tipoDocumentoRepresentanteLegal) {
        this.tipoDocumentoRepresentanteLegal = tipoDocumentoRepresentanteLegal;
    }

    public String getNumeroDocumentoRepresentanteLegal() {
        return numeroDocumentoRepresentanteLegal;
    }

    public void setNumeroDocumentoRepresentanteLegal(String numeroDocumentoRepresentanteLegal) {
        this.numeroDocumentoRepresentanteLegal = numeroDocumentoRepresentanteLegal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public CuentaAporteRepresentation getCuentaAporte() {
        return cuentaAporte;
    }

    public void setCuentaAporte(CuentaAporteRepresentation cuentaAporte) {
        this.cuentaAporte = cuentaAporte;
    }

}
