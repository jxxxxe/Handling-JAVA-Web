package sec01.ex01;

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
	
	public void addMember(MemberBean memberBean) {
		try { 
			con=dataFactory.getConnection();
			String query="insert into t_member(id,pwd,email,name) values(?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, memberBean.getId());
			pstmt.setString(2, memberBean.getPwd());
			pstmt.setString(3, memberBean.getEmail());
			pstmt.setString(4, memberBean.getName());
			//joinDate는 table에서 디폴트 값이 sysDate로 지정되어있기 때문에 알아서 지정 됨
			pstmt.executeUpdate();
			
			pstmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listMember() {

		List members=new ArrayList();
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
				
				MemberBean memberBean=new MemberBean(id,pwd,name,email);
				memberBean.setJoinDate(joinDate);
				members.add(memberBean);
			}
			con.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return members;
	}
}
