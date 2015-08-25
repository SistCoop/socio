package org.sistcoop.socio.models.jpa.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotBlank;
import org.sistcoop.socio.models.enums.EstadoCuentaPersonal;
import org.sistcoop.socio.models.enums.TipoCuentaPersonal;

@Audited
@Cacheable
@Entity
@Table(name = "CUENTA_PERSONAL")
@NamedQueries(value = { @NamedQuery(name = "CuentaPersonalEntity.findAll", query = "SELECT C FROM CuentaPersonalEntity c") })
public class CuentaPersonalEntity implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_CUENTA")
    private TipoCuentaPersonal tipoCuenta;

    @NotNull
    @Size(min = 0, max = 20)
    @NotBlank
    @Column(name = "NUMERO_CUENTA")
    private String numeroCuenta;

    @NotNull
    @Size(min = 3, max = 3)
    @NotBlank
    @Column(name = "MONEDA")
    private String moneda;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_APERTURA")
    private Date fechaApertura;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_CIERRE")
    private Date fechaCierre;

    @NotNull
    @Min(value = 0)
    @Digits(integer = 18, fraction = 2)
    @Column(name = "SALDO")
    private BigDecimal saldo;

    @NotNull
    @Min(value = 0)
    @Column(name = "CANTIDAD_RETIRANTES")
    private int cantidadRetirantes;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO")
    private EstadoCuentaPersonal estado;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "SOCIO_ID")
    private SocioEntity socio;

    @OneToMany(mappedBy = "cuentaPersonal", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<TitularEntity> titulares = new HashSet<TitularEntity>();

    @OneToMany(mappedBy = "cuentaPersonal", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<AutorizadoEntity> autorizados = new HashSet<AutorizadoEntity>();

    @OneToMany(mappedBy = "cuentaPersonal", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<BeneficiarioEntity> beneficiarios = new HashSet<BeneficiarioEntity>();

    @OneToMany(mappedBy = "cuentaPersonal", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<CuentaPersonalTasaEntity> tasas = new HashSet<CuentaPersonalTasaEntity>();

    @Version
    private Timestamp optlk;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoCuentaPersonal getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuentaPersonal tipoCuenta) {
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

    public EstadoCuentaPersonal getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuentaPersonal estado) {
        this.estado = estado;
    }

    public SocioEntity getSocio() {
        return socio;
    }

    public void setSocio(SocioEntity socio) {
        this.socio = socio;
    }

    public Set<TitularEntity> getTitulares() {
        return titulares;
    }

    public void setTitulares(Set<TitularEntity> titulares) {
        this.titulares = titulares;
    }

    public Set<AutorizadoEntity> getAutorizados() {
        return autorizados;
    }

    public void setAutorizados(Set<AutorizadoEntity> autorizados) {
        this.autorizados = autorizados;
    }

    public Set<BeneficiarioEntity> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(Set<BeneficiarioEntity> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public Set<CuentaPersonalTasaEntity> getTasas() {
        return tasas;
    }

    public void setTasas(Set<CuentaPersonalTasaEntity> tasas) {
        this.tasas = tasas;
    }

    public Timestamp getOptlk() {
        return optlk;
    }

    public void setOptlk(Timestamp optlk) {
        this.optlk = optlk;
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
        if (getClass() != obj.getClass())
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
