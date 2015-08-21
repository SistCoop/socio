package org.sistcoop.socio.models.jpa.entities;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotBlank;

@Audited
@Cacheable
@Entity
@Table(name = "CUENTA_APORTE_MONEDA")
@NamedQueries(value = {
        @NamedQuery(name = "CuentaAporteMonedaEntity.findAll", query = "SELECT c FROM CuentaAporteMonedaEntity c"),
        @NamedQuery(name = "CuentaAporteMonedaEntity.findByEstado", query = "SELECT c FROM CuentaAporteMonedaEntity c WHERE c.estado =:estado") })
public class CuentaAporteMonedaEntity implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 3)
    @Column(name = "MONEDA")
    private String moneda;

    @NotNull
    @Type(type = "org.hibernate.type.TrueFalseType")
    @Column(name = "ESTADO")
    private boolean estado;

    @Version
    private Timestamp optlk;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
        CuentaAporteMonedaEntity other = (CuentaAporteMonedaEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
