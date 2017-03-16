package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the so_details database table.
 * 
 */
@Entity
@Table(name="so_details")
@NamedQuery(name="SoDetail.findAll", query="SELECT s FROM SoDetail s")
public class SoDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SO_DETAILS_ID", unique=true, nullable=false)
	private int soDetailsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATETIME")
	private Date createDatetime;

	@Column(name="CREATE_USER", length=50)
	private String createUser;

	@Column(name="SO_PROPERTY_ADDR", nullable=false, length=500)
	private String soPropertyAddr;

	@Column(name="SO_PROPERTY_NAME", nullable=false, length=100)
	private String soPropertyName;

	@Column(name="SO_PROPERTY_TAGLINE", length=100)
	private String soPropertyTagline;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATETIME")
	private Date updateDatetime;

	@Column(name="UPDATE_USER", length=50)
	private String updateUser;

	//bi-directional many-to-one association to SoType
	@ManyToOne
	@JoinColumn(name="SO_TYPE_ID", nullable=false)
	private SoType soType;

	//bi-directional many-to-one association to SoLocation
	@ManyToOne
	@JoinColumn(name="SO_LOCATION_ID", nullable=false)
	private SoLocation soLocation;

	//bi-directional many-to-one association to SoImagesDtl
	@OneToMany(mappedBy="soDetail")
	private List<SoImagesDtl> soImagesDtls;

	public SoDetail() {
	}

	public int getSoDetailsId() {
		return this.soDetailsId;
	}

	public void setSoDetailsId(int soDetailsId) {
		this.soDetailsId = soDetailsId;
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

	public String getSoPropertyAddr() {
		return this.soPropertyAddr;
	}

	public void setSoPropertyAddr(String soPropertyAddr) {
		this.soPropertyAddr = soPropertyAddr;
	}

	public String getSoPropertyName() {
		return this.soPropertyName;
	}

	public void setSoPropertyName(String soPropertyName) {
		this.soPropertyName = soPropertyName;
	}

	public String getSoPropertyTagline() {
		return this.soPropertyTagline;
	}

	public void setSoPropertyTagline(String soPropertyTagline) {
		this.soPropertyTagline = soPropertyTagline;
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

	public SoType getSoType() {
		return this.soType;
	}

	public void setSoType(SoType soType) {
		this.soType = soType;
	}

	public SoLocation getSoLocation() {
		return this.soLocation;
	}

	public void setSoLocation(SoLocation soLocation) {
		this.soLocation = soLocation;
	}

	public List<SoImagesDtl> getSoImagesDtls() {
		return this.soImagesDtls;
	}

	public void setSoImagesDtls(List<SoImagesDtl> soImagesDtls) {
		this.soImagesDtls = soImagesDtls;
	}

	public SoImagesDtl addSoImagesDtl(SoImagesDtl soImagesDtl) {
		getSoImagesDtls().add(soImagesDtl);
		soImagesDtl.setSoDetail(this);

		return soImagesDtl;
	}

	public SoImagesDtl removeSoImagesDtl(SoImagesDtl soImagesDtl) {
		getSoImagesDtls().remove(soImagesDtl);
		soImagesDtl.setSoDetail(null);

		return soImagesDtl;
	}

}