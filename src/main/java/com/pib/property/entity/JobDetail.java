package com.pib.property.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.pib.nullhandler.NotNullObject;
import com.pib.nullhandler.NullObject;
import com.pib.property.model.builder.AbstractBuilder;

public class JobDetail implements Serializable, NotNullObject {
	private Long id;
	private String jobId ;
	private String type;
	private String category;
	private String overTime;
	private Long   minSalary;
	private Long   maxSalary;
	private Long   hires;
	private String emergencyLevel;
	private String shiftStartTime;
	private String location;
	private String qualification;
	private LocalDateTime createAt;
    private LocalDateTime updateAt;
    
	public void fillNotRequire() {
		location = location != null ? location : "";
		qualification = qualification != null ? qualification : "";
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getJobId() {
		return jobId;
	}


	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getOverTime() {
		return overTime;
	}


	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}


	public Long getMinSalary() {
		return minSalary;
	}


	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}


	public Long getMaxSalary() {
		return maxSalary;
	}


	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}


	public Long getHires() {
		return hires;
	}


	public void setHires(Long hires) {
		this.hires = hires;
	}


	public String getEmergencyLevel() {
		return emergencyLevel;
	}


	public void setEmergencyLevel(String emergencyLevel) {
		this.emergencyLevel = emergencyLevel;
	}


	public String getShiftStartTime() {
		return shiftStartTime;
	}


	public void setShiftStartTime(String shiftStartTime) {
		this.shiftStartTime = shiftStartTime;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
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


    public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public static final Null NULL = new Null();

    private static class Null extends JobDetail implements NullObject {
    }

    public static class Builder extends AbstractBuilder {
        @Override
        public JobDetail build() {
            try {
                return super.build(JobDetail.class);
            } catch (InstantiationException | IllegalAccessException e) {
                return NULL;
            }
        }
    }

	@Override
	public String toString() {
		return "JobDetail [id=" + id + ", jobId=" + jobId + ", type=" + type + ", category=" + category + ", overTime="
				+ overTime + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary + ", hires=" + hires
				+ ", emergencyLevel=" + emergencyLevel + ", shiftStartTime=" + shiftStartTime + ", location=" + location
				+ ", qualification=" + qualification + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}

	 

     
}