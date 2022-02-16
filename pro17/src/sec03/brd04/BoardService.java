package sec03.brd04;

import java.util.List;

public class BoardService {

	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO=new BoardDAO();
	}
	
	
	public List<ArticleVO> listArticles() {
		List<ArticleVO> articleList=boardDAO.selectAllArticles();
		return articleList;
	}


	public int addArticle(ArticleVO articleVO) {
		return boardDAO.isertNewArticle(articleVO);
	}


	public ArticleVO viewArticle(int articleNO) {
		ArticleVO article=boardDAO.selectArticle(articleNO);
		return article;
	}

}
