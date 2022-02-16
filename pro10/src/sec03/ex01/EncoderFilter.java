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
		System.out.println("destroy() ȣ��");
	}


	//���������� ��û�ϸ� ȣ��
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		System.out.println("Context ���� : "+((HttpServletRequest)request).getContextPath()+
				"\n URI ���� : "+((HttpServletRequest)request).getRequestURI()+"\n ������ ��� : "
				+request.getRealPath(((HttpServletRequest)request).getRequestURI()));
		long begin=System.currentTimeMillis();
		chain.doFilter(request, response); //���� ���ͷ� �ѱ�. �ؿ� �ڵ�� ���� �ϸ鼭 ����
		long end=System.currentTimeMillis();
		System.out.println("�۾� �ð� : "+(end-begin)+"ms");
	}

	//�������� �ּ� �Է��ϸ� ȣ��
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init() ȣ��");

		context=fConfig.getServletContext();
	}

}
