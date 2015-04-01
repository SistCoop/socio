package org.sistcoop.socio.models.jpa.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.sistcoop.socio.models.enums.EstadoCheque;
import org.sistcoop.socio.models.enums.TipoPersona;

@Entity
@Table(name = "CHEQUE")
public class ChequeEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private EstadoCheque estado;

	private int numeroCheque;
	private int numeroChequeUnico;

	private TipoPersona tipoPersona;
	private String tipoDocumento;
	private String numeroDocumento;
	private String persona;

	private BigDecimal monto;
	private Date fechaCambioEstado;
	private ChequeraEntity chequera;

	@Id
	@GeneratedValue(generator = "SgGenericGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstadoCheque getEstado() {
		return estado;
	}

	public void setEstado(EstadoCheque estado) {
		this.estado = estado;
	}

	public int getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(int numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	public int getNumeroChequeUnico() {
		return numeroChequeUnico;
	}

	public void setNumeroChequeUnico(int numeroChequeUnico) {
		this.numeroChequeUnico = numeroChequeUnico;
	}

	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(TipoPersona tipoPersona) {
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

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Date getFechaCambioEstado() {
		return fechaCambioEstado;
	}

	public void setFechaCambioEstado(Date fechaCambioEstado) {
		this.fechaCambioEstado = fechaCambioEstado;
	}

	public ChequeraEntity getChequera() {
		return chequera;
	}

	public void setChequera(ChequeraEntity chequera) {
		this.chequera = chequera;
	}

}
