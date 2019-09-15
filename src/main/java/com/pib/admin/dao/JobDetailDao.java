package com.pib.admin.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.pib.admin.entity.JobDetail;
import com.pib.admin.model.SearchCondition;
 

@Repository
@Mapper
public interface JobDetailDao {
	
    @Insert("insert into Job_Detail(id, jobid, overtime, type, category, min_salary, max_salary, hires, emergency_level, shift_start_time, location, qualification, updateat) "+
            "values(#{id}, #{jobId}, #{overTime}, #{type}, #{category}, #{minSalary},#{maxSalary},#{hires},#{emergencyLevel},#{shiftStartTime}, #{location}, #{qualification}, #{updateAt})")
    @SelectKey(statement = "select SEQ_JOBDETAIL_ID.NEXTVAL from dual ", keyProperty = "id", before = true, resultType = long.class)
    int save(JobDetail e);

    @Delete("delete from Job_Detail where id=#{id}")
    int delete(JobDetail e);


    @UpdateProvider(type = Sql.class, method = "update")
    int update(JobDetail e);


    @Select("select * from Job_Detail e where id=#{id}")
    JobDetail findById(JobDetail e);

    
    class Sql {
        public static String update(final JobDetail e) {
            return new SQL() {{
                UPDATE("Job_Detail");
                if (e.getJobId() != null) SET("jobId=#{jobId}");
                if (e.getOverTime() != null) SET("overtime=#{overTime}");
                if (e.getType() != null) SET("type=#{type}");
                if (e.getCategory() != null) SET("category=#{category}");
                if (e.getMinSalary() != null) SET("min_salary=#{minSalary}");
                if (e.getMaxSalary() != null) SET("max_salary=#{maxSalary}");
                if (e.getHires() != null) SET("hires=#{hires}");
                if (e.getEmergencyLevel() != null) SET("emergency_level=#{emergencyLevel}");
                if (e.getMaxSalary() != null) SET("max_salary=#{maxSalary}");
                if (e.getMaxSalary() != null) SET("max_salary=#{maxSalary}");
                if (e.getShiftStartTime() != null) SET("shiftStartTime=#{shiftStartTime}");
                if (e.getLocation() != null) SET("location=#{location}");
                if (e.getQualification() != null) SET("qualification=#{qualification}");
                SET("updateAt=#{updateAt}");
                WHERE("id=#{id}");
            }}.toString();
        }
    }
}

