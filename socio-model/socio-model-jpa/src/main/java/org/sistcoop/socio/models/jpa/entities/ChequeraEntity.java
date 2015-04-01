package org.sistcoop.socio.models.jpa.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "CHEQUERA")
public class ChequeraEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private int cantidad;
	private int numeroInicio;
	private int numeroFin;

	private Date fechaDisponible;
	private Date fechaExpiracion;

	private boolean estado;

	private CuentaPersonalEntity cuentaPersonal;
	private Set<ChequeEntity> cheques = new HashSet<ChequeEntity>();

	@Id
	@GeneratedValue(generator = "SgGenericGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@Min(value = 1)
	@Max(value = 1000)
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@NotNull
	@Min(value = 1)
	public int getNumeroInicio() {
		return numeroInicio;
	}

	public void setNumeroInicio(int numeroInicio) {
		this.numeroInicio = numeroInicio;
	}

	@NotNull
	@Min(value = 1)
	public int getNumeroFin() {
		return numeroFin;
	}

	public void setNumeroFin(int numeroFin) {
		this.numeroFin = numeroFin;
	}

	@NotNull
	public Date getFechaDisponible() {
		return fechaDisponible;
	}

	public void setFechaDisponible(Date fechaDisponible) {
		this.fechaDisponible = fechaDisponible;
	}

	@NotNull
	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	@NotNull
	@Type(type = "org.hibernate.type.TrueFalseType")
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey)
	public CuentaPersonalEntity getCuentaPersonal() {
		return cuentaPersonal;
	}

	public void setCuentaPersonal(CuentaPersonalEntity cuentaPersonal) {
		this.cuentaPersonal = cuentaPersonal;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chequera")
	public Set<ChequeEntity> getCheques() {
		return cheques;
	}

	public void setCheques(Set<ChequeEntity> cheques) {
		this.cheques = cheques;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ChequeraEntity))
			return false;
		ChequeraEntity other = (ChequeraEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
