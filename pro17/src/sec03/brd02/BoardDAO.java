package sec03.brd02;

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

public class BoardDAO {

	private Connection con;
	private DataSource dataFactory;
	private PreparedStatement pstmt;
	
	public BoardDAO() {
		try {
			Context ctx=new InitialContext();
			Context envContext=(Context) ctx.lookup("java:/comp/env");
			dataFactory=(DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<ArticleVO> selectAllArticles() {

		List<ArticleVO> articlesList=new ArrayList();
		try {
			con=dataFactory.getConnection();
			String query="SELECT LEVEL, articleNO, parentNO, title, content, writeDate, id " + 
					"FROM t_board " + 
					"START WITH parentNO=0 " + 
					"CONNECT BY PRIOR articleNO=parentNO " + 
					"ORDER SIBLINGS BY articleNO DESC";
			pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int level=rs.getInt("level");
				int articleNO=rs.getInt("articleNO");
				int parentNO=rs.getInt("parentNO");
				String title=rs.getString("title");
				String content=rs.getString("content");
				Date writeDate=rs.getDate("writeDate");
				String id=rs.getString("id");
				
				ArticleVO articleVO=new ArticleVO(level,articleNO,parentNO,title,content,null,id);
				articleVO.setWriteDate(writeDate);
				
				articlesList.add(articleVO);
			}
			con.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return articlesList;
	}

	private int getNewArticleNO() {
		try {
			con=dataFactory.getConnection();
			String query="select max(articleNO) from t_board";
			pstmt=con.prepareStatement(query);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				return (rs.getInt(1)+1);
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void isertNewArticle(ArticleVO articleVO) {
		int articleNO=getNewArticleNO();
		try {
			con=dataFactory.getConnection();
			String query="insert into t_board(articleNO, parentNO, title, content, imageFileName, id)"
					+"values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.setInt(2, articleVO.getParentNO());
			pstmt.setString(3, articleVO.getTitle());
			pstmt.setString(4, articleVO.getContent());
			pstmt.setString(5, articleVO.getImageFileName());
			pstmt.setString(6, articleVO.getId());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
