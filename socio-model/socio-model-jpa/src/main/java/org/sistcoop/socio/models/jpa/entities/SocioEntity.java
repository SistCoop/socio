package org.sistcoop.socio.models.jpa.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotBlank;
import org.sistcoop.socio.models.enums.TipoPersona;

@Audited
@Cacheable
@Entity
@Table(name = "SOCIO")
@NamedQueries(value = { @NamedQuery(name = "SocioEntity.findAll", query = "SELECT s FROM SocioEntity s") })
public class SocioEntity implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_PERSONA")
    private TipoPersona tipoPersona;

    @NotNull
    @Size(min = 1, max = 20)
    @NotBlank
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;

    @NotNull
    @Size(min = 1, max = 20)
    @NotBlank
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;

    /**
     * El representante legal siempre es una persona natural
     */
    @Size(min = 1, max = 20)
    @Column(name = "TIPO_DOCUMENTO_REPRESENTANTE_LEGAL")
    private String tipoDocumentoRepresentanteLegal;

    @Size(min = 1, max = 20)
    @Column(name = "NUMERO_DOCUMENTO_REPRESENTANTE_LEGAL")
    private String numeroDocumentoRepresentanteLegal;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_FIN")
    private Date fechaFin;

    @NotNull
    @Type(type = "org.hibernate.type.TrueFalseType")
    @Column(name = "ESTADO")
    private boolean estado;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, optional = false)
    @JoinColumn(foreignKey = @ForeignKey, name = "CUENTA_APORTE_ID")
    private CuentaAporteEntity cuentaAporte;

    @OneToMany(mappedBy = "socio", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<ComisionSocioAsignadaEntity> comisiones = new HashSet<ComisionSocioAsignadaEntity>();

    @OneToMany(mappedBy = "socio", fetch = FetchType.LAZY)
    private Set<CuentaPersonalEntity> cuentasPersonales = new HashSet<CuentaPersonalEntity>();

    @Version
    private Timestamp optlk;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoPersona getTipoPersona() {
        return this.tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumentoRepresentanteLegal() {
        return this.tipoDocumentoRepresentanteLegal;
    }

    public void setTipoDocumentoRepresentanteLegal(String tipoDocumentoRepresentanteLegal) {
        this.tipoDocumentoRepresentanteLegal = tipoDocumentoRepresentanteLegal;
    }

    public String getNumeroDocumentoRepresentanteLegal() {
        return this.numeroDocumentoRepresentanteLegal;
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

    public CuentaAporteEntity getCuentaAporte() {
        return cuentaAporte;
    }

    public void setCuentaAporte(CuentaAporteEntity cuentaAporte) {
        this.cuentaAporte = cuentaAporte;
    }

    public Set<ComisionSocioAsignadaEntity> getComisiones() {
        return comisiones;
    }

    public void setComisione(Set<ComisionSocioAsignadaEntity> comisiones) {
        this.comisiones = comisiones;
    }

    public Set<CuentaPersonalEntity> getCuentasPersonales() {
        return cuentasPersonales;
    }

    public void setCuentasPersonales(Set<CuentaPersonalEntity> cuentasPersonales) {
        this.cuentasPersonales = cuentasPersonales;
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        SocioEntity other = (SocioEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
