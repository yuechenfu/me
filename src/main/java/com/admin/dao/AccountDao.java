package com.admin.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import com.admin.entity.Account;
 

@Repository
@Mapper
public interface AccountDao {
    @Insert("insert into account(email, username, password, nickname, phone, company, location, gender, imgsrc, source, remark,  createAt, updateAt) "+
           " values(#{email}, #{username}, #{password},  #{nickname}, #{phone}, #{company}, #{location}, #{gender}, #{imgsrc}, #{source}, #{remark},  #{createAt}, #{updateAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Account e);

    @Delete("delete from account where id=#{id}")
    int delete(Account e);


    @UpdateProvider(type = Sql.class, method = "update")
    int update(Account e);

    @Update("update account set password=#{password}, updateAt=#{updateAt} where id=#{id}")
    int updatePassword(Account e);

    @Select("select * from account e where id=#{id}")
    Account findById(Account e);


    @Select("select count(*) from account e where username=#{username}")
    int countByUsername(Account e);
    
    @Select("select count(*) from account e where email=#{email}")
    int countByEmail(Account e);

    @Select("select * from account e where username=#{username} ")
    Account findByUsername(Account e);
    
    @Select("select * from account e where email=#{email} ")
    Account findByEmail(Account e);

    @Select("select * from account e where username=#{username} and password=#{password}")
    Account findByUsernameAndPassword(Account e);
    
    @Select("select * from account e where email=#{email} and password=#{password}")
    Account findByEmailAndPassword(Account e);
    
     

    class Sql {
        public static String update(final Account e) {
            return new SQL() {{
                UPDATE("account");
                if (e.getUsername() != null) SET("username=#{username}");
                if (e.getPassword() != null) SET("password=#{password}");
                if (e.getEmail() != null) SET("email=#{email}");
                if (e.getNickname() != null) SET("nickname=#{nickname}");
                if (e.getPhone() != null) SET("phone=#{phone}");
                if (e.getCompany() != null) SET("company=#{company}");
                if (e.getLocation() != null) SET("location=#{location}");
                if (e.getGender() != null) SET("gender=#{gender}");
                if (e.getImgsrc() != null) SET("imgsrc=#{imgsrc}");
                if (e.getSource() != null) SET("source=#{source}");
                if (e.getRemark() != null) SET("remark=#{remark}");
                SET("updateAt=#{updateAt}");
                WHERE("id=#{id}");
            }}.toString();
        }

    }
}

