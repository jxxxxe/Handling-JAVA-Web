package com.spring.ex02;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex01.MemberVO;

public class MemberDAO {
	
	private static SqlSessionFactory sqlMapper=null;
	
	public static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try {
				String resource="mybatis/SqlMapConfig.xml";
				Reader reader=Resources.getResourceAsReader(resource);
				sqlMapper=new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}

	public List selectAllMemberList() {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		List<MemberVO> memList=null;
		memList=session.selectList("mapper.member.selectAllMemberList");
		return memList;
	}
	
	public String selectName() {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		String name=session.selectOne("mapper.member.selectName");
		
		return name;
	}
	
	public int selectPwd() {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		return session.selectOne("mapper.member.selectPwd");
	}
	
	public MemberVO selectMemberById(String id) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		return session.selectOne("mapper.member.selectMemberById",id);
		
	}
	
	public List selectMemberByPwd(String pwd) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		List<MemberVO> membersList=session.selectList("mapper.member.selectMemberByPwd",pwd);
		
		return membersList;
	}



}
