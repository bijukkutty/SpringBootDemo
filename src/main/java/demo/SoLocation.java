package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the so_location database table.
 * 
 */
@Entity
@Table(name="so_location")
@NamedQuery(name="SoLocation.findAll", query="SELECT s FROM SoLocation s")
public class SoLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SO_LOCATION_ID", unique=true, nullable=false)
	private int soLocationId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATETIME")
	private Date createDatetime;

	@Column(name="CREATE_USER", length=50)
	private String createUser;

	@Column(name="SO_LOCATION_NAME", nullable=false, length=100)
	private String soLocationName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATETIME")
	private Date updateDatetime;

	@Column(name="UPDATE_USER", length=50)
	private String updateUser;

	//bi-directional many-to-one association to SoDetail
	@OneToMany(mappedBy="soLocation")
	private List<SoDetail> soDetails;

	//bi-directional many-to-one association to SoCity
	@ManyToOne
	@JoinColumn(name="SO_CITY_ID", nullable=false)
	private SoCity soCity;

	public SoLocation() {
	}

	public int getSoLocationId() {
		return this.soLocationId;
	}

	public void setSoLocationId(int soLocationId) {
		this.soLocationId = soLocationId;
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

	public String getSoLocationName() {
		return this.soLocationName;
	}

	public void setSoLocationName(String soLocationName) {
		this.soLocationName = soLocationName;
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

	public List<SoDetail> getSoDetails() {
		return this.soDetails;
	}

	public void setSoDetails(List<SoDetail> soDetails) {
		this.soDetails = soDetails;
	}

	public SoDetail addSoDetail(SoDetail soDetail) {
		getSoDetails().add(soDetail);
		soDetail.setSoLocation(this);

		return soDetail;
	}

	public SoDetail removeSoDetail(SoDetail soDetail) {
		getSoDetails().remove(soDetail);
		soDetail.setSoLocation(null);

		return soDetail;
	}

	public SoCity getSoCity() {
		return this.soCity;
	}

	public void setSoCity(SoCity soCity) {
		this.soCity = soCity;
	}

}