package org.sistcoop.socio.models.jpa.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CUENTA_PERSONAL_INTERES_GENERADO", indexes = { @Index(columnList = "id") })
public class CuentaPersonalInteresGeneradoEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private CuentaPersonalEntity cuentaPersonal;
	private BigDecimal capital;
	private BigDecimal interesGenerado;
	private Date fecha;

	public CuentaPersonalInteresGeneradoEntity() {
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
	@DecimalMin(value = "0")
	@Digits(integer = 18, fraction = 2)
	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	@NotNull
	@Min(value = 0)
	@DecimalMin(value = "0")
	@Digits(integer = 18, fraction = 2)
	public BigDecimal getInteresGenerado() {
		return interesGenerado;
	}

	public void setInteresGenerado(BigDecimal interesGenerado) {
		this.interesGenerado = interesGenerado;
	}

	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuentaPersonal == null) ? 0 : cuentaPersonal.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CuentaPersonalInteresGeneradoEntity))
			return false;
		CuentaPersonalInteresGeneradoEntity other = (CuentaPersonalInteresGeneradoEntity) obj;
		if (cuentaPersonal == null) {
			if (other.cuentaPersonal != null)
				return false;
		} else if (!cuentaPersonal.equals(other.cuentaPersonal))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}

}
