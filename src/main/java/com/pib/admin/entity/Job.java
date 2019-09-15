package com.pib.admin.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.pib.admin.model.builder.AbstractBuilder;
import com.pib.admin.nullhandler.NotNullObject;
import com.pib.admin.nullhandler.NullObject;

public class Job implements Serializable, NotNullObject {
	private Long id;
	private String title ;
	private Long employerId;
	private String employerName;
	private String contactName;
	private String contactPhone;
	private String location;
	private int    hiresPerYear;
	private String knowUs;
	private String recevieType;
	private String recevieEmail;
	private String needResume;
	private LocalDateTime createAt;
    private LocalDateTime updateAt;
    
	public void fillNotRequire() {
		title = title != null ? title :"" ;
		location = location != null ? location : "0";
		recevieType = recevieType != null ? recevieType : "EMAIL";
		recevieEmail = recevieEmail != null ? recevieEmail : "";
		knowUs = knowUs != null ? knowUs : "";
		needResume = needResume != null ? needResume : "YES";
    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	 

	public Long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}


	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public int getHiresPerYear() {
		return hiresPerYear;
	}

	public void setHiresPerYear(int hiresPerYear) {
		this.hiresPerYear = hiresPerYear;
	}

	public String getKnowUs() {
		return knowUs;
	}

	public void setKnowUs(String knowUs) {
		this.knowUs = knowUs;
	}

	public String getRecevieType() {
		return recevieType;
	}

	public void setRecevieType(String recevieType) {
		this.recevieType = recevieType;
	}

	public String getRecevieEmail() {
		return recevieEmail;
	}

	public void setRecevieEmail(String recevieEmail) {
		this.recevieEmail = recevieEmail;
	}

	public String getNeedResume() {
		return needResume;
	}

	public void setNeedResume(String needResume) {
		this.needResume = needResume;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
 
	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public void createAt() {
        createAt = LocalDateTime.now(ZoneId.of("UTC"));
    }

    public void updateAt() {
        updateAt = LocalDateTime.now(ZoneId.of("UTC"));
    }


    public static final Null NULL = new Null();

    private static class Null extends Job implements NullObject {
    }

    public static class Builder extends AbstractBuilder {
        @Override
        public Job build() {
            try {
                return super.build(Job.class);
            } catch (InstantiationException | IllegalAccessException e) {
                return NULL;
            }
        }
    }

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", employerId=" + employerId + ", employerName=" + employerName
				+  ", contactName=" + contactName + ", contactPhone="
				+ contactPhone + ", location=" + location + ", hiresPerYear=" + hiresPerYear + ", knowUs=" + knowUs
				+ ", recevieType=" + recevieType + ", recevieEmail=" + recevieEmail + ", needResume=" + needResume
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}


     
}