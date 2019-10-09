package com.pib.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import com.pib.admin.entity.Account;
import com.pib.admin.entity.Agent;
 

@Repository
@Mapper
public interface AgentDao {
    @Insert("insert into agent(email, firstname, lastname, password, phone, company, location, gender, photo,photourl, aboutme, city, state, postcode,  createAt, updateAt) "+
           " values(#{email},  #{firstname}, #{lastname}, #{password}, #{phone}, #{company}, #{location}, #{gender}, #{photo}, #{photoUrl}, #{aboutme} , #{city}, #{state},  #{postcode},  #{createAt}, #{updateAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Agent e);

    @Delete("delete from agent where id=#{id}")
    int delete(Agent e);


    @UpdateProvider(type = Sql.class, method = "update")
    int update(Agent e);

    @Select("select * from agent limit #{begRow}, #{rows} ")
    List<Agent> find(int begRow,int rows);

    @Select("select * from agent e where id=#{id}")
    Agent findById(Agent e);

  

    @Select("select * from agent e where username=#{username} ")
    Agent findByUsername(Agent e);
    
    @Select("select * from agent e where email=#{email} ")
    Agent findByEmail(Agent e);
    
    @Select("select count(1) from agent  ")
    int   count();
 
     
    class Sql {
        public static String update(final Agent e) {
            return new SQL() {{
                UPDATE("agent");
                if (e.getFirstname() != null) SET("firstname=#{firstname}");
                if (e.getLastname() != null) SET("lastname=#{lastname}");
                if (e.getPassword() != null) SET("password=#{password}");
                if (e.getEmail() != null) SET("email=#{email}");
                if (e.getPhone() != null) SET("phone=#{phone}");
                if (e.getAboutme() != null) SET("aboutme=#{aboutme}");
                if (e.getCompany() != null) SET("company=#{company}");
                if (e.getLocation() != null) SET("location=#{location}");
                if (e.getPhoto() != null) SET("photo=#{photo}");
                if (e.getPhotoUrl() != null) SET("photourl=#{photoUrl}");
                if (e.getGender() != null) SET("gender=#{gender}");
                if (e.getCity() != null) SET("city=#{city}");
                if (e.getState() != null) SET("state=#{state}");
                if (e.getPostcode() != null) SET("postcode=#{postcode}");
                SET("updateAt=#{updateAt}");
                WHERE("id =#{id}");
            }}.toString();
        }

    }
}

