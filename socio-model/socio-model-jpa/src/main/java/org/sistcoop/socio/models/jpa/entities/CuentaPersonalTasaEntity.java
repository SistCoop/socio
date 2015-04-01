package org.sistcoop.socio.models.jpa.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CUENTA_PERSONAL_TASA", indexes = { @Index(columnList = "id") })
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CuentaPersonalTasaEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String denominacion;
	private CuentaPersonalEntity cuentaPersonal;
	private BigDecimal valor;

	public CuentaPersonalTasaEntity() {
	}

	@Id
	@GeneratedValue(generator = "SgGenericGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@Size(min = 1, max = 30)
	@NotBlank
	@NotEmpty
	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey)
	public CuentaPersonalEntity getCuentaPersonal() {
		return cuentaPersonal;
	}

	public void setCuentaPersonal(CuentaPersonalEntity cuentaPersonal) {
		this.cuentaPersonal = cuentaPersonal;
	}

	@NotNull
	@Min(value = 0)
	@Max(value = 100)
	@DecimalMin(value = "0")
	@Digits(integer = 3, fraction = 2)
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuentaPersonal == null) ? 0 : cuentaPersonal.hashCode());
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CuentaPersonalTasaEntity))
			return false;
		CuentaPersonalTasaEntity other = (CuentaPersonalTasaEntity) obj;
		if (cuentaPersonal == null) {
			if (other.cuentaPersonal != null)
				return false;
		} else if (!cuentaPersonal.equals(other.cuentaPersonal))
			return false;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		return true;
	}

}
