// Generated with g9.

package mx.com.udes.metaphorce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Contract implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "contractId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ContractId", unique=true, nullable=false)
    private long contractId;
    @Column(name="DateFrom", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Calendar dateFrom;
    @Column(name="DateTo", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Calendar dateTo;
    @Column(name="SalaryPerDay", nullable=false, precision=10, scale=2)
    private BigDecimal salaryPerDay;
    @Column(name="IsActive", nullable=false)
    private boolean isActive;
    @Column(name="DateCreated", nullable=false)
    private LocalDateTime dateCreated;
    @ManyToOne(optional=false)
    @JoinColumn(name="EmployeeId", nullable=false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name="ContractTypeId")
    private ContractType contractType;

    /** Default constructor. */
    public Contract() {
        super();
    }

    /**
     * Access method for contractId.
     *
     * @return the current value of contractId
     */
    public long getContractId() {
        return contractId;
    }

    /**
     * Setter method for contractId.
     *
     * @param aContractId the new value for contractId
     */
    public void setContractId(long aContractId) {
        contractId = aContractId;
    }

    /**
     * Access method for dateFrom.
     *
     * @return the current value of dateFrom
     */
    public Calendar getDateFrom() {
        return dateFrom;
    }

    /**
     * Setter method for dateFrom.
     *
     * @param aDateFrom the new value for dateFrom
     */
    public void setDateFrom(Calendar aDateFrom) {
        dateFrom = aDateFrom;
    }

    /**
     * Access method for dateTo.
     *
     * @return the current value of dateTo
     */
    public Calendar getDateTo() {
        return dateTo;
    }

    /**
     * Setter method for dateTo.
     *
     * @param aDateTo the new value for dateTo
     */
    public void setDateTo(Calendar aDateTo) {
        dateTo = aDateTo;
    }

    /**
     * Access method for salaryPerDay.
     *
     * @return the current value of salaryPerDay
     */
    public BigDecimal getSalaryPerDay() {
        return salaryPerDay;
    }

    /**
     * Setter method for salaryPerDay.
     *
     * @param aSalaryPerDay the new value for salaryPerDay
     */
    public void setSalaryPerDay(BigDecimal aSalaryPerDay) {
        salaryPerDay = aSalaryPerDay;
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
     * Access method for employee.
     *
     * @return the current value of employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Setter method for employee.
     *
     * @param aEmployee the new value for employee
     */
    public void setEmployee(Employee aEmployee) {
        employee = aEmployee;
    }

    /**
     * Access method for contractType.
     *
     * @return the current value of contractType
     */
    public ContractType getContractType() {
        return contractType;
    }

    /**
     * Setter method for contractType.
     *
     * @param aContractType the new value for contractType
     */
    public void setContractType(ContractType aContractType) {
        contractType = aContractType;
    }

    /**
     * Compares the key for this instance with another Contract.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Contract and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Contract)) {
            return false;
        }
        Contract that = (Contract) other;
        if (this.getContractId() != that.getContractId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Contract.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Contract)) return false;
        return this.equalKeys(other) && ((Contract)other).equalKeys(this);
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
        i = (int)(getContractId() ^ (getContractId()>>>32));
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
        StringBuffer sb = new StringBuffer("[Contract |");
        sb.append(" contractId=").append(getContractId());
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
        ret.put("contractId", Long.valueOf(getContractId()));
        return ret;
    }

}
