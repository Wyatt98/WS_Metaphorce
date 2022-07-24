// Generated with g9.

package mx.com.udes.metaphorce.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ContractType implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "contractTypeId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ContractTypeId", unique=true, nullable=false)
    private short contractTypeId;
    @Column(name="Name", nullable=false, length=80)
    private String name;
    @Column(name="Description", length=255)
    private String description;
    @Column(name="IsActive", nullable=false)
    private boolean isActive;
    @Column(name="DateCreated", nullable=false)
    private LocalDateTime dateCreated;
    @JsonIgnore
    @OneToMany(mappedBy="contractType")
    private Set<Contract> contract;

    /** Default constructor. */
    public ContractType() {
        super();
    }

    /**
     * Access method for contractTypeId.
     *
     * @return the current value of contractTypeId
     */
    public short getContractTypeId() {
        return contractTypeId;
    }

    /**
     * Setter method for contractTypeId.
     *
     * @param aContractTypeId the new value for contractTypeId
     */
    public void setContractTypeId(short aContractTypeId) {
        contractTypeId = aContractTypeId;
    }

    /**
     * Access method for name.
     *
     * @return the current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     *
     * @param aName the new value for name
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * Access method for description.
     *
     * @return the current value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for description.
     *
     * @param aDescription the new value for description
     */
    public void setDescription(String aDescription) {
        description = aDescription;
    }

    /**
     * Access method for isActive.
     *
     * @return true if and only if isActive is currently true
     */
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * Setter method for isActive.
     *
     * @param aIsActive the new value for isActive
     */
    public void setIsActive(boolean aIsActive) {
        isActive = aIsActive;
    }

    /**
     * Access method for dateCreated.
     *
     * @return the current value of dateCreated
     */
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    /**
     * Setter method for dateCreated.
     *
     * @param aDateCreated the new value for dateCreated
     */
    public void setDateCreated(LocalDateTime aDateCreated) {
        dateCreated = aDateCreated;
    }

    /**
     * Access method for contract.
     *
     * @return the current value of contract
     */
    public Set<Contract> getContract() {
        return contract;
    }

    /**
     * Setter method for contract.
     *
     * @param aContract the new value for contract
     */
    public void setContract(Set<Contract> aContract) {
        contract = aContract;
    }

    /**
     * Compares the key for this instance with another ContractType.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ContractType and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ContractType)) {
            return false;
        }
        ContractType that = (ContractType) other;
        if (this.getContractTypeId() != that.getContractTypeId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ContractType.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ContractType)) return false;
        return this.equalKeys(other) && ((ContractType)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getContractTypeId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[ContractType |");
        sb.append(" contractTypeId=").append(getContractTypeId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("contractTypeId", Short.valueOf(getContractTypeId()));
        return ret;
    }

}
