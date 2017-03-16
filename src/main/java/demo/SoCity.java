package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the so_city database table.
 * 
 */
@Entity
@Table(name="so_city")
@NamedQuery(name="SoCity.findAll", query="SELECT s FROM SoCity s")
public class SoCity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SO_CITY_ID", unique=true, nullable=false)
	private int soCityId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATETIME")
	private Date createDatetime;

	@Column(name="CREATE_USER", length=50)
	private String createUser;

	@Column(name="SO_CITY_NAME", nullable=false, length=100)
	private String soCityName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATETIME")
	private Date updateDatetime;

	@Column(name="UPDATE_USER", length=50)
	private String updateUser;

	//bi-directional many-to-one association to SoState
	@ManyToOne
	@JoinColumn(name="SO_STATE_ID", nullable=false)
	private SoState soState;

	//bi-directional many-to-one association to SoLocation
	@OneToMany(mappedBy="soCity")
	private List<SoLocation> soLocations;

	public SoCity() {
	}

	public int getSoCityId() {
		return this.soCityId;
	}

	public void setSoCityId(int soCityId) {
		this.soCityId = soCityId;
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

	public String getSoCityName() {
		return this.soCityName;
	}

	public void setSoCityName(String soCityName) {
		this.soCityName = soCityName;
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

	public SoState getSoState() {
		return this.soState;
	}

	public void setSoState(SoState soState) {
		this.soState = soState;
	}

	public List<SoLocation> getSoLocations() {
		return this.soLocations;
	}

	public void setSoLocations(List<SoLocation> soLocations) {
		this.soLocations = soLocations;
	}

	public SoLocation addSoLocation(SoLocation soLocation) {
		getSoLocations().add(soLocation);
		soLocation.setSoCity(this);

		return soLocation;
	}

	public SoLocation removeSoLocation(SoLocation soLocation) {
		getSoLocations().remove(soLocation);
		soLocation.setSoCity(null);

		return soLocation;
	}

}