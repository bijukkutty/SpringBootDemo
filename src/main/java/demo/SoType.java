package demo;

import java.io.Serializable; 
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the so_type database table.
 * 
 */
@Entity
@Table(name="so_type")
@NamedQuery(name="SoType.findAll", query="SELECT s FROM SoType s")
public class SoType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SO_TYPE_ID", unique=true, nullable=false)
	private int soTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATETIME")
	private Date createDatetime;

	@Column(name="CREATE_USER", length=50)
	private String createUser;

	@Column(name="SO_TYPE_NAME", length=100)
	private String soTypeName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATETIME")
	private Date updateDatetime;

	@Column(name="UPDATE_USER", length=50)
	private String updateUser;

	//bi-directional many-to-one association to SoDetail
	@OneToMany(mappedBy="soType")
	private List<SoDetail> soDetails;

	public SoType() {
	}

	public int getSoTypeId() {
		return this.soTypeId;
	}

	public void setSoTypeId(int soTypeId) {
		this.soTypeId = soTypeId;
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

	public String getSoTypeName() {
		return this.soTypeName;
	}

	public void setSoTypeName(String soTypeName) {
		this.soTypeName = soTypeName;
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
		soDetail.setSoType(this);

		return soDetail;
	}

	public SoDetail removeSoDetail(SoDetail soDetail) {
		getSoDetails().remove(soDetail);
		soDetail.setSoType(null);

		return soDetail;
	}

}