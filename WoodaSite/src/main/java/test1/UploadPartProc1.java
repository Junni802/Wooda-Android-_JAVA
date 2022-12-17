package test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class UploadPartProc1
 */
@WebServlet("/uploadPartProc1")
@MultipartConfig(
		fileSizeThreshold = 0,
		location = "D:/jun/jsp/work/errUploadMail/WebContent/upload"
		)
public class UploadPartProc1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPartProc1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		// cos.jar�� �̿��� ����� �ٸ��� request��ü�� �̿��Ͽ� �Ϲ� ���ڿ� �����͸� ���� �� ����
		Part part = request.getPart("file1");
		// ���ε�Ǵ� ������ Part�� �ν��Ͻ��� ����
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// �������� ȭ�鿡 ��½�Ű�� ����� ����ϱ� ���� ��ü ����
		
		String contentDisposition = part.getHeader("content-disposition");
		// ��) form-data; name="file1"; filename="���ε������ϸ�.Ȯ����"
		System.out.println("contentDisposition : " + contentDisposition);
		
		String uploadFileName = getUploadFileName(contentDisposition);
		
		part.write(uploadFileName);
		out.println("���δ�" + name + "����" + uploadFileName + "������ ���ε� �߽��ϴ�.");
	}
	private String getUploadFileName(String contentDisposition) {
		String uploadFileName = null;
		String[] contentSplitStr = contentDisposition.split(";");
		
		int fIdx = contentSplitStr[2].indexOf("\"");
		int sIdx = contentSplitStr[2].lastIndexOf("\"");
		
		uploadFileName = contentSplitStr[2].substring(fIdx + 1, sIdx);
		return uploadFileName;
	}
}
