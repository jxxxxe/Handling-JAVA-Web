package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List selectAllMembers() {
		String query="select id, pwd, name, email, joinDate from t_member order by joinDate desc";
		List membersList=new ArrayList();
		
		membersList=jdbcTemplate.query(query, new RowMapper<MemberVO>() {

			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new MemberVO(rs.getString("id"), rs.getString("pwd"), rs.getString("name"), rs.getString("email"), rs.getDate("joinDate"));
			
		}});
		
		return membersList;
	}

	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException{
		
		String query="insert into t_member(id,pwd,name,email) values('"
					+memberVO.getId()+"','"+memberVO.getPwd()+"','"+memberVO.getName()+"','"+memberVO.getEmail()+"')";
		
		return jdbcTemplate.update(query);
	}

}
