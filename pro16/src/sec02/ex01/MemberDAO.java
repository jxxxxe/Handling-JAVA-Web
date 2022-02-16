package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	private DataSource dataFactory;
	private PreparedStatement pstmt;
	private Connection con;
	
	public MemberDAO() {
		try {
			Context ctx=new InitialContext();
			Context envContext=(Context)ctx.lookup("java:/comp/env");
			dataFactory=(DataSource)envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

	public boolean overlappedID(String id) {
		boolean result=false;
		try {
			con=dataFactory.getConnection();
			String query="select decode(count(*),1,'true','false') as result from t_member where id=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, id);
			
			ResultSet rs=pstmt.executeQuery();
			
			rs.next();
			
			result=Boolean.parseBoolean(rs.getString("result"));
			pstmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
