package sec03.ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class EncoderFilter implements Filter {

	ServletContext context;

	public void destroy() {
		System.out.println("destroy() 호출");
	}


	//브라우저에서 요청하면 호출
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		System.out.println("Context 정보 : "+((HttpServletRequest)request).getContextPath()+
				"\n URI 정보 : "+((HttpServletRequest)request).getRequestURI()+"\n 물리적 경로 : "
				+request.getRealPath(((HttpServletRequest)request).getRequestURI()));
		long begin=System.currentTimeMillis();
		chain.doFilter(request, response); //다음 필터로 넘김. 밑에 코드는 응답 하면서 실행
		long end=System.currentTimeMillis();
		System.out.println("작업 시간 : "+(end-begin)+"ms");
	}

	//브라우저에 주소 입력하면 호출
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init() 호출");

		context=fConfig.getServletContext();
	}

}
