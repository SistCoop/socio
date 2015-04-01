package org.sistcoop.socio.models.jpa.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.sistcoop.socio.models.enums.EstadoCuentaPersonal;
import org.sistcoop.socio.models.enums.TipoCuentaPersonal;

@Entity
@Table(name = "CUENTA_PERSONAL", indexes = { @Index(columnList = "id") })
public class CuentaPersonalEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private TipoCuentaPersonal tipoCuenta;
	private String numeroCuenta;
	private String moneda;

	private Date fechaApertura;
	private Date fechaCierre;

	private BigDecimal saldo;
	private int cantidadRetirantes;
	private EstadoCuentaPersonal estadoCuenta;

	private SocioEntity socio;

	private Set<TitularEntity> titulares = new HashSet<TitularEntity>();
	private Set<AutorizadoEntity> autorizados = new HashSet<AutorizadoEntity>();
	private Set<BeneficiarioEntity> beneficiarios = new HashSet<BeneficiarioEntity>();
	private Set<CuentaPersonalTasaEntity> tasas = new HashSet<CuentaPersonalTasaEntity>();

	private Timestamp version;

	public CuentaPersonalEntity() {
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
	@Enumerated(EnumType.STRING)
	public TipoCuentaPersonal getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuentaPersonal tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	@NotNull
	@Size(min = 14, max = 14)
	@NotEmpty
	@NotBlank
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	@NotNull
	@Size(min = 3, max = 3)
	@NotEmpty
	@NotBlank
	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	@Temporal(TemporalType.DATE)
	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	@NotNull
	@Min(value = 0)
	@DecimalMin(value = "0")
	@Digits(integer = 18, fraction = 2)
	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@NotNull
	@Min(value = 0)
	@Max(value = 5)
	public int getCantidadRetirantes() {
		return cantidadRetirantes;
	}

	public void setCantidadRetirantes(int cantidadRetirantes) {
		this.cantidadRetirantes = cantidadRetirantes;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	public EstadoCuentaPersonal getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(EstadoCuentaPersonal estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey)
	public SocioEntity getSocio() {
		return socio;
	}

	public void setSocio(SocioEntity socio) {
		this.socio = socio;
	}

	@OneToMany(mappedBy = "cuentaPersonal", fetch = FetchType.LAZY)
	public Set<TitularEntity> getTitulares() {
		return titulares;
	}

	public void setTitulares(Set<TitularEntity> titulares) {
		this.titulares = titulares;
	}

	@OneToMany(mappedBy = "cuentaPersonal", fetch = FetchType.LAZY)
	public Set<AutorizadoEntity> getAutorizados() {
		return autorizados;
	}

	public void setAutorizados(Set<AutorizadoEntity> autorizados) {
		this.autorizados = autorizados;
	}

	@OneToMany(mappedBy = "cuentaPersonal", fetch = FetchType.LAZY)
	public Set<BeneficiarioEntity> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(Set<BeneficiarioEntity> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	@OneToMany(mappedBy = "cuentaPersonal", fetch = FetchType.LAZY)
	public Set<CuentaPersonalTasaEntity> getTasas() {
		return tasas;
	}

	public void setTasas(Set<CuentaPersonalTasaEntity> tasas) {
		this.tasas = tasas;
	}

	@Version
	public Timestamp getVersion() {
		return version;
	}

	public void setVersion(Timestamp version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroCuenta == null) ? 0 : numeroCuenta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CuentaPersonalEntity))
			return false;
		CuentaPersonalEntity other = (CuentaPersonalEntity) obj;
		if (numeroCuenta == null) {
			if (other.numeroCuenta != null)
				return false;
		} else if (!numeroCuenta.equals(other.numeroCuenta))
			return false;
		return true;
	}

}
