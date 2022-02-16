package sec02.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	private Connection con;
	private DataSource dataFactory;
	private PreparedStatement pstmt;
	
	public MemberDAO() {
		try {
			Context ctx=new InitialContext();
			Context envContext=(Context) ctx.lookup("java:/comp/env");
			dataFactory=(DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<MemberVO> listMembers() {

		List<MemberVO> members=new ArrayList();
		try {
			con=dataFactory.getConnection();
			String query="select * from t_member order by joinDate desc";
			pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String id =rs.getString("id");
				String pwd=rs.getString("pwd");
				String name=rs.getString("name");
				String email=rs.getString("email");
				Date joinDate=rs.getDate("joinDate");
				
				MemberVO memberVO=new MemberVO(id,pwd,name,email,joinDate);
				members.add(memberVO);
			}
			con.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return members;
	}
	

	public void addMember(MemberVO memberVO) {
		try { 
			con=dataFactory.getConnection();
			String query="insert into t_member(id,pwd,email,name) values(?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getEmail());
			pstmt.setString(4, memberVO.getName());
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO findMember(String id) {
		MemberVO memInfo=null;
		try {
			con=dataFactory.getConnection();
			String query="select * from t_member where id=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, id);

			ResultSet rs=pstmt.executeQuery();
			
			rs.next();
			
			String name=rs.getString("name");
			String pwd=rs.getString("pwd");
			String email=rs.getString("email");
			Date joinDate=rs.getDate("joinDate");
			
			memInfo=new MemberVO(id,pwd,name,email,joinDate);
			pstmt.close();
			con.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memInfo;
	}
	
	public void modMember(MemberVO memberVO) {
		try {
			con=dataFactory.getConnection();
			String query="update t_member set pwd=?, name=?, email=? where id=?";
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, memberVO.getPwd());
			pstmt.setString(2, memberVO.getName());
			pstmt.setString(3, memberVO.getEmail());
			pstmt.setString(4, memberVO.getId());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void delMember(String id) {
		try {
			con=dataFactory.getConnection();
			String query="delete from t_member where id=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
