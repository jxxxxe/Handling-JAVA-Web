package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		
		String encoding="utf-8";
		
		File currentDirPath =new File("C:\\file_repo"); //���� ���ε� �� ��ġ(���� ���� �ʿ�)
		
		DiskFileItemFactory factory=new DiskFileItemFactory(); //���̺귯������ �����ϴ� Ŭ����1
		factory.setRepository(currentDirPath); //���� ���ε� ��ġ ����
		factory.setSizeThreshold(1024*1024); //���ε� ������ ���� �ִ� ũ�� ����
		
		ServletFileUpload upload =new ServletFileUpload(factory); //���̺귯������ �����ϴ� Ŭ����2
		try {
			List items=upload.parseRequest(request); //��û �Ű������� ����Ʈ�� �Ľ�
			for(int i=0;i<items.size();i++) {
				FileItem fileItem=(FileItem)items.get(i);
				
				if(fileItem.isFormField()) { //�Ű������� ���ʵ�(text,,)�̸� �Ű������̸�=��(encoding�ؼ� ������)�� ���
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
				}else { //�� �ʵ尡 �ƴϸ�(file) ���� ���ε� ��� ����
					System.out.println("�Ķ���͸�:" + fileItem.getFieldName()); //�Ű����� �̸�
					System.out.println("���ϸ�:" + fileItem.getName()); //�����̸�
					System.out.println("����ũ��:" + fileItem.getSize() + "bytes"); //����ũ��
					
					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\"); // ���� �̸� �߿��� \\�� �� �ε���
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/"); // ���� �̸� �߿��� \\�� ������ /�� �ε���
						}
						String fileName = fileItem.getName().substring(idx + 1); // \\�� / �ڿ� �ִ� ���� �̸��� ������
						File uploadFile = new File(currentDirPath + "\\" + fileName); // �������ġ\\�����̸��� �����
						fileItem.write(uploadFile); //����ҿ� ���� ���ε�
					}
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
