package com.pib.property.dao;


import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import com.pib.property.entity.Person;
import com.pib.property.model.SearchCondition;
import com.pib.util.StringUtil;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface PersonDao {
	@Insert("insert into person(id, accountId, firstName, lastName, phone, email,  type, imgsrc, location, jobTitle, createAt, updateAt) "
            + "VALUES(#{id},#{accountId}, #{firstName}, #{lastName}, #{phone}, #{email}, #{type}, #{imgsrc}, #{location}, #{jobTitle}, #{createAt}, #{updateAt})")
	@SelectKey(statement = "select SEQ_PERSON_ID.NEXTVAL from dual ", keyProperty = "id", before = true, resultType = long.class)
	int save(Person e);

    @Delete("delete from person where id=#{id}")
    int delete(Person e);

    @UpdateProvider(type = Sql.class, method = "update")
    int update(Person e);

    @Select("select * from person where id=#{id}")
    Person findById(Person e);
    
    @Select("select * from person where accountId=#{accountId}")
    Person findByAccountId(Person e);

    @SelectProvider(type = Sql.class, method = "count")
    int count(@Param("searchCondition")SearchCondition searchCondition);
    
    @SelectProvider(type= Sql.class, method = "find")
    List<Person> find(@Param("searchCondition")SearchCondition searchCondition);

    @Select("select count(*) from person where email=#{email}")
    int countByEmail(@Param("email")String email);

    @Select("select count(*) from person where phone=#{phone}")
    int countByPhone(@Param("phone")String phone);


    class Sql {
        public static String update(final Person e) {
            return new SQL() {{
                UPDATE("person");
                if (e.getFirstName() != null) SET("firstName=#{firstName}");
                if (e.getLastName() != null) SET("lastName=#{lastName}");
                if (e.getPhone() != null) SET("phone=#{phone}");
                if (e.getEmail() != null) SET("email=#{email}");
                if (e.getImgsrc() != null) SET("imgsrc=#{imgsrc}");
                if (e.getType() != null) SET("type=#{type}");
                if (e.getLocation() != null) SET("location=#{location}");
                if (e.getJobTitle() != null) SET("jobTitle=#{jobTitle}");
                SET("updateAt=#{updateAt}");
                WHERE("id=#{id}");
            }}.toString();
        }
        public static String count(@Param("searchCondition") final SearchCondition searchCondition) {
            return new SQL() {{
                SELECT("count(*)"); FROM("person");
                if (searchCondition.getType() != null) WHERE("type=#{searchCondition.type}");
                if (searchCondition.getTypeList() != null) WHERE("type in ("+searchCondition.getTypeList().stream().map(e->"'"+e.toString()+"'").collect(Collectors.joining(","))+")");
                if (searchCondition.getMinDate() != null) WHERE("createAt >= #{searchCondition.minDate}");
                if (searchCondition.getMaxDate() != null) WHERE("createAt <= #{searchCondition.maxDate}"); 
                if (searchCondition.getName() != null) {
                    WHERE("firstName like #{searchCondition.like.name}");
                    OR().WHERE("lastName like #{searchCondition.like.name}");
                    OR().WHERE("phone like #{searchCondition.like.name}");
                    OR().WHERE("email like #{searchCondition.like.name}");
                    OR().WHERE("location like #{searchCondition.like.name}");
                    OR().WHERE("jobTitle like #{searchCondition.like.name}");
                }                
            }}.toString();
        }
        public static String find(@Param("searchCondition") final SearchCondition searchCondition) {
            return new SQL() {{
                SELECT("*"); FROM("person e");
                if (searchCondition.getType() != null) WHERE("type=#{searchCondition.type}");  
                if (searchCondition.getName() != null) {
                    WHERE("( firstName like #{searchCondition.name}");
                    OR().WHERE("lastName like #{searchCondition.name}");
                    OR().WHERE("jobTitle like #{searchCondition.name}  )");
                }
            }}.toString().concat(searchCondition.getSqlOrder()).concat(searchCondition.getSqlLimit());
        }
    }
}
