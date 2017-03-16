package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the so_states database table.
 * 
 */
@Entity
@Table(name="so_states")
@NamedQuery(name="SoState.findAll", query="SELECT s FROM SoState s")
public class SoState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SO_STATE_ID", unique=true, nullable=false)
	private int soStateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATETIME")
	private Date createDatetime;

	@Column(name="CREATE_USER", length=50)
	private String createUser;

	@Column(name="SO_STATE_NAME", nullable=false, length=100)
	private String soStateName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATETIME")
	private Date updateDatetime;

	@Column(name="UPDATE_USER", length=50)
	private String updateUser;

	//bi-directional many-to-one association to SoCity
	@OneToMany(mappedBy="soState")
	private List<SoCity> soCities;

	//bi-directional many-to-one association to SoCountry
	@ManyToOne
	@JoinColumn(name="SO_COUNTRY_ID", nullable=false)
	private SoCountry soCountry;

	public SoState() {
	}

	public int getSoStateId() {
		return this.soStateId;
	}

	public void setSoStateId(int soStateId) {
		this.soStateId = soStateId;
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

	public String getSoStateName() {
		return this.soStateName;
	}

	public void setSoStateName(String soStateName) {
		this.soStateName = soStateName;
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

	public List<SoCity> getSoCities() {
		return this.soCities;
	}

	public void setSoCities(List<SoCity> soCities) {
		this.soCities = soCities;
	}

	public SoCity addSoCity(SoCity soCity) {
		getSoCities().add(soCity);
		soCity.setSoState(this);

		return soCity;
	}

	public SoCity removeSoCity(SoCity soCity) {
		getSoCities().remove(soCity);
		soCity.setSoState(null);

		return soCity;
	}

	public SoCountry getSoCountry() {
		return this.soCountry;
	}

	public void setSoCountry(SoCountry soCountry) {
		this.soCountry = soCountry;
	}

}