package com.pib.property.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.pib.property.entity.Account;
import com.pib.property.model.SearchCondition;
 

@Repository
@Mapper
public interface AccountDao {
    @Insert("insert into account(id, username, password,  type, status,  createAt, updateAt) values(#{id}, #{username}, #{password},  #{type}, #{status},  #{createAt}, #{updateAt})")
    @SelectKey(statement = "select SEQ_ACCOUNT_ID.NEXTVAL from dual ", keyProperty = "id", before = true, resultType = long.class)
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

    @Select("select * from account e where username=#{username} ")
    Account findByUsername(Account e);

    @Select("select * from account e where username=#{username} and password=#{password}")
    Account findByUsernameAndPassword(Account e);

    class Sql {
        public static String update(final Account e) {
            return new SQL() {{
                UPDATE("account");
                if (e.getUsername() != null) SET("username=#{username}");
                if (e.getPassword() != null) SET("password=#{password}");
                if (e.getType() != null) SET("type=#{type}");
                SET("updateAt=#{updateAt}");
                WHERE("id=#{id}");
            }}.toString();
        }

    }
}

