package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List selectAllMembers() {
		return sqlSession.selectList("mapper.member.selectAllMemberList");
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		return sqlSession.insert("mapper.member.insertMember",memberVO);
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		return sqlSession.delete("mapper.member.deleteMember",id);
	}


}
