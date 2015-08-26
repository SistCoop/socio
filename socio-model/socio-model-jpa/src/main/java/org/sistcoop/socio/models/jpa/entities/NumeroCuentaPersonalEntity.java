package org.sistcoop.socio.models.jpa.entities;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.envers.Audited;

@Audited
@Cacheable
@Entity
@Table(name = "NUMERO_CUENTA_PERSONAL")
@GenericGenerator(name = "NumeroCuentaPersonalGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
        @Parameter(name = "prefer_sequence_per_entity", value = "true"),
        @Parameter(name = "optimizer ", value = "pooled") })
public class NumeroCuentaPersonalEntity implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "NumeroCuentaPersonalGenerator")
    @Column(name = "NUMERO_CUENTA")
    private Long numeroCuenta;

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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
        NumeroCuentaPersonalEntity other = (NumeroCuentaPersonalEntity) obj;
        if (numeroCuenta == null) {
            if (other.numeroCuenta != null)
                return false;
        } else if (!numeroCuenta.equals(other.numeroCuenta))
            return false;
        return true;
    }

}
