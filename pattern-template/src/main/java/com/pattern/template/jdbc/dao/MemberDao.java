package com.pattern.template.jdbc.dao;

import com.pattern.template.jdbc.JdbcTemplate;
import com.pattern.template.jdbc.Member;
import com.pattern.template.jdbc.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class MemberDao extends JdbcTemplate {
    //构造方法引入dataSource
    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll(){
        String sql = "select * from t_member";
        return super.executeQuery(sql, new RowMapper<Member>(){
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                //当字段较多时，可以使用原型模式
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAddr(rs.getString("addr"));
                member.setAge(rs.getInt("age"));
                return member;
            }
        },null);
    }
}
