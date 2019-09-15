package com.pib.admin.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import com.pib.admin.entity.SecurityCode;
import com.pib.admin.model.SearchCondition;

import java.util.List;

@Repository
public interface SecurityCodeDao {
    @Insert("insert into securityCode(id, name, code, type, status, updateAt, createAt) VALUES(#{id}, #{name}, #{code}, #{type}, #{status}, #{updateAt}, #{createAt})")
    @SelectKey(statement = "select SEQ_LOG_ID.NEXTVAL from dual ", keyProperty = "id", before = true, resultType = long.class)
    int save(SecurityCode e);

    @Delete("delete from securityCode where id=#{id}")
    int delete(SecurityCode e);

    @UpdateProvider(type = Sql.class, method = "update")
    int update(SecurityCode e);

    @Select("select * from securityCode where id=#{id}")
    SecurityCode findById(SecurityCode e);

    @SelectProvider(type = Sql.class, method = "count")
    int count(@Param("searchCondition") SearchCondition searchCondition);

    @SelectProvider(type = Sql.class, method = "find")
    List<SecurityCode> find(@Param("searchCondition") SearchCondition searchCondition);

    class Sql {
        public static String update(final SecurityCode e) {
            return new SQL() {{
                UPDATE("securityCode");
                if (e.getName() != null) SET("name=#{name}");
                if (e.getCode() != null) SET("code=#{code}");
                if (e.getType() != null) SET("type=#{type}");
                if (e.getStatus() != null) SET("status=#{status}");
                SET("updateAt=#{updateAt}");
                WHERE("id=#{id}");
            }}.toString();
        }
        public static String count(@Param("searchCondition") final SearchCondition searchCondition) {
            return new SQL() {{
                SELECT("count(*)"); FROM("securityCode e");
                if (searchCondition.getName() != null) WHERE("name=#{searchCondition.name}");
                if (searchCondition.getStatus() != null) WHERE("status=#{searchCondition.status}");
                if (searchCondition.getType() != null) WHERE("type=#{searchCondition.type}");
            }}.toString();
        }
        public static String find(@Param("searchCondition") final SearchCondition searchCondition) {
            return new SQL() {{
                SELECT("*"); FROM("securityCode e");
                if (searchCondition.getName() != null) WHERE("name=#{searchCondition.name}");
                if (searchCondition.getStatus() != null) WHERE("status=#{searchCondition.status}");
                if (searchCondition.getType() != null) WHERE("type=#{searchCondition.type}");
            }}.toString().concat(searchCondition.getSqlOrder()).concat(searchCondition.getSqlLimit());
        }
    }
}
