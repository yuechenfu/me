package com.pib.admin.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.pib.admin.entity.Account;
import com.pib.admin.entity.Job;
import com.pib.admin.model.SearchCondition;
 

@Repository
@Mapper
public interface JobDao {
	
	public   String  Columns = "id, title, employer_id employerId, employer_name employerName, contact_name contactName, contact_phone contactPhone, location, hires_per_year hiresPerYear, know_us knowUs, recevie_type recevieType, recevie_email recevieEmail,need_resume needResume, createAt, updateAt";
	
    @Insert(" insert into job(id, title, employer_id, employer_name, contact_name, contact_phone, location, hires_per_year, know_us, recevie_type, recevie_email, need_resume, createat, updateat) "+
            " values(#{id},#{title},#{employerId},#{employerName},#{contactName},#{contactPhone},#{location},#{hiresPerYear},#{knowUs},#{recevieType},#{recevieEmail},#{needResume},#{createAt}, #{updateAt} )")
    @SelectKey(statement = "select SEQ_JOB_ID.NEXTVAL from dual ", keyProperty = "id", before = true, resultType = long.class)
    int save(Job e);

    @Delete("delete from Job where id=#{id}")
    int delete(Job e);


    @UpdateProvider(type = Sql.class, method = "update")
    int update(Job e);


    @Select("select "+Columns+" from job e where id=#{id}")
    Job findById(Job e);
    
    @Select("select "+Columns+" from job e where employer_id=#{employerId}")
    List<Job> findByEmployerId(Job e);
    
    @SelectProvider(type = Sql.class, method = "findByTitleAndAddress")
    List<Job> findByTitleAndAddress(Job job);

   

    class Sql {
        public static String update(final Job e) {
            return new SQL() {{
                UPDATE("Job");
                if (e.getTitle() != null) SET("title=#{title}");
                if (e.getEmployerId() != null) SET("employer_id=#{employerId}");
                if (e.getEmployerName() != null) SET("employer_name=#{employerName}");
                if (e.getContactName() != null) SET("contact_name=#{contactName}");
                if (e.getContactPhone() != null) SET("contact_phone=#{contactPhone}");
                if (e.getLocation() != null) SET("location=#{location}");
                if (e.getHiresPerYear() >0) SET("hires_per_year=#{hiresPerYear}");
                if (e.getKnowUs() != null) SET("know_us=#{knowUs}");
                if (e.getRecevieType() != null) SET("recevie_type=#{recevieType}");
                if (e.getRecevieEmail() != null) SET("recevie_email=#{recevieEmail}");
                if (e.getNeedResume() != null) SET("need_resume=#{needResume}");
                SET("updateAt=#{updateAt}");
                WHERE("id=#{id}");
            }}.toString();
        }
        
        public static String findByTitleAndAddress(final Job job) {
            return new SQL() {{
                SELECT(Columns);
                FROM("Job ");  
                WHERE("title like #{title} and location like #{location}  ");
            }}.toString();
        }

        
    }
}

