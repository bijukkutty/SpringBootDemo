package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the so_country database table.
 * 
 */
@Entity
@Table(name="so_country")
@NamedQuery(name="SoCountry.findAll", query="SELECT s FROM SoCountry s")
public class SoCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SO_COUNTRY_ID", unique=true, nullable=false)
	private int soCountryId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATETIME")
	private Date createDatetime;

	@Column(name="CREATE_USER", length=50)
	private String createUser;

	@Column(name="SO_COUNTRY_NAME", nullable=false, length=100)
	private String soCountryName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATETIME")
	private Date updateDatetime;

	@Column(name="UPDATE_USER", length=50)
	private String updateUser;

	//bi-directional many-to-one association to SoState
	@OneToMany(mappedBy="soCountry", cascade = CascadeType.ALL)
	private List<SoState> soStates;

	public SoCountry() {
	}

	public int getSoCountryId() {
		return this.soCountryId;
	}

	public void setSoCountryId(int soCountryId) {
		this.soCountryId = soCountryId;
	}

	public Date getCreateDatetime() {
		return this.createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getSoCountryName() {
		return this.soCountryName;
	}

	public void setSoCountryName(String soCountryName) {
		this.soCountryName = soCountryName;
	}

	public Date getUpdateDatetime() {
		return this.updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public List<SoState> getSoStates() {
		return this.soStates;
	}

	public void setSoStates(List<SoState> soStates) {
		this.soStates = soStates;
	}

	public SoState addSoState(SoState soState) {
		getSoStates().add(soState);
		soState.setSoCountry(this);

		return soState;
	}

	public SoState removeSoState(SoState soState) {
		getSoStates().remove(soState);
		soState.setSoCountry(null);

		return soState;
	}

}