// Generated with g9.

package mx.com.udes.metaphorce.model;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "employeeId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="EmployeeId", unique=true, nullable=false)
    private int employeeId;
    @Column(name="TaxIdNumber", nullable=false, length=13)
    private String taxIdNumber;
    @Column(name="Name", nullable=false, length=60)
    private String name;
    @Column(name="LastName", nullable=false, length=120)
    private String lastName;
    @Column(name="BirthDate", nullable=false)
    private LocalDate birthDate;
    @Column(name="Email", nullable=false, length=60)
    private String email;
    @Column(name="CellPhone", nullable=false, length=20)
    private String cellPhone;
    @JsonIgnore
    @Column(name="IsActive", nullable=false)
    private boolean isActive;
    @JsonIgnore
    @Column(name="DateCreated", nullable=false)
    private LocalDateTime dateCreated;
    @JsonIgnore
    @OneToMany(mappedBy="employee")
    private Set<Contract> contract;

    /** Default constructor. */
    public Employee() {
        super();
    }

    /**
     * Access method for employeeId.
     *
     * @return the current value of employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Setter method for employeeId.
     *
     * @param aEmployeeId the new value for employeeId
     */
    public void setEmployeeId(int aEmployeeId) {
        employeeId = aEmployeeId;
    }

    /**
     * Access method for taxIdNumber.
     *
     * @return the current value of taxIdNumber
     */
    public String getTaxIdNumber() {
        return taxIdNumber;
    }

    /**
     * Setter method for taxIdNumber.
     *
     * @param aTaxIdNumber the new value for taxIdNumber
     */
    public void setTaxIdNumber(String aTaxIdNumber) {
        taxIdNumber = aTaxIdNumber;
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
     * Access method for lastName.
     *
     * @return the current value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for lastName.
     *
     * @param aLastName the new value for lastName
     */
    public void setLastName(String aLastName) {
        lastName = aLastName;
    }

    /**
     * Access method for birthDate.
     *
     * @return the current value of birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Setter method for birthDate.
     *
     * @param aBirthDate the new value for birthDate
     */
    public void setBirthDate(LocalDate aBirthDate) {
        birthDate = aBirthDate;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for cellPhone.
     *
     * @return the current value of cellPhone
     */
    public String getCellPhone() {
        return cellPhone;
    }

    /**
     * Setter method for cellPhone.
     *
     * @param aCellPhone the new value for cellPhone
     */
    public void setCellPhone(String aCellPhone) {
        cellPhone = aCellPhone;
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
     * Compares the key for this instance with another Employee.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Employee and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Employee)) {
            return false;
        }
        Employee that = (Employee) other;
        if (this.getEmployeeId() != that.getEmployeeId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Employee.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Employee)) return false;
        return this.equalKeys(other) && ((Employee)other).equalKeys(this);
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
        i = getEmployeeId();
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
        StringBuffer sb = new StringBuffer("[Employee |");
        sb.append(" employeeId=").append(getEmployeeId());
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
        ret.put("employeeId", Integer.valueOf(getEmployeeId()));
        return ret;
    }

}
