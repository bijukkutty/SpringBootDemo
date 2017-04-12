package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the so_images_dtls database table.
 * 
 */
@Entity
@Table(name="so_images_dtls")
@NamedQuery(name="SoImagesDtl.findAll", query="SELECT s FROM SoImagesDtl s")
public class SoImagesDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SO_IMAGES_DTLS_ID", unique=true, nullable=false)
	private int soImagesDtlsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATETIME")
	private Date createDatetime;

	@Column(name="CREATE_USER", length=50)
	private String createUser;

	@Column(name="SO_IMAGE")
	private byte[] soImage;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATETIME")
	private Date updateDatetime;

	@Column(name="UPDATE_USER", length=50)
	private String updateUser;

	//bi-directional many-to-one association to SoDetail
	@ManyToOne
	@JoinColumn(name="SO_DETAILS_ID", nullable=false)
	private SoDetail soDetail;

	public SoImagesDtl() {
	}

	public int getSoImagesDtlsId() {
		return this.soImagesDtlsId;
	}

	public void setSoImagesDtlsId(int soImagesDtlsId) {
		this.soImagesDtlsId = soImagesDtlsId;
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

	public byte[] getSoImage() {
		return this.soImage;
	}

	public void setSoImage(byte[] soImage) {
		this.soImage = soImage;
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

	public SoDetail getSoDetail() {
		return this.soDetail;
	}

	public void setSoDetail(SoDetail soDetail) {
		this.soDetail = soDetail;
	}

}