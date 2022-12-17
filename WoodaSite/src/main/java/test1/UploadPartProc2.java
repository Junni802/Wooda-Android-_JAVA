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
@WebServlet("/uploadPartProc2")
@MultipartConfig(
		fileSizeThreshold = 0,
		location = "D:/jun/jsp/work/errUploadMail/WebContent/upload"
		)
public class UploadPartProc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPartProc2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("name");
		String uploadFileNameList = "";

		for (Part part : request.getParts()) {
	    	// getParts() : ����ڰ� ���� ������(��Ʈ��)���� Collection<Part>�� ��� �����ϴ� �޼ҵ�
	    	// getParts()�� �޾ƿ� Part ��ü���� �ϳ��� ���ʴ�� Part�� �ν��Ͻ� part�� ��� ������ ��

	    		if (!part.getName().equals("name")) {
	    		// part�� �޾ƿ� ��Ʈ���� �̸��� 'name'�� �ƴϸ�(file ��Ʈ�Ѹ� �۾��ϰڴٴ� �ǹ�)
	    			String contentDisposition = part.getHeader("content-disposition");
	    			// ��) form-data; name="file1"; filename="���ε������ϸ�.Ȯ����"
	    			// file ��ü�� ������� form-data; name="file1"; filename="" �� ��µ�

	    			String uploadFileName = getUploadFileName(contentDisposition);
	    			// ���ε��� ������ �̸� �κи� ���� : ��) ���ε������ϸ�.Ȯ����
	    			if (!uploadFileName.equals("")) {
	    				uploadFileNameList += ", " + uploadFileName;
	        			part.write(uploadFileName);
	    			}
	    		}
	    	}
	    	if (!uploadFileNameList.equals("")) {
	    		uploadFileNameList = uploadFileNameList.substring(2);
	    	}
	    	out.println("���δ� " + name + "���� " + uploadFileNameList + " ���ϵ��� ���ε� �߽��ϴ�.")

		
		System.out.println("contentDisposition : " + contentDisposition);
		
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
