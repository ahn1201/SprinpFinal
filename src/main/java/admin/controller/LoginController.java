package admin.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * ������ �α��� ������
	 * id : jimin
	 * pw : 1234
	 * -> ������ ���� ���� ���� ���� �� ������.
	 * 
	 * /admin/login/login.do
	 * /admin/login/loginProc.do
	 */
	@RequestMapping(value="/admin/login/login.do", method=RequestMethod.GET)
	public void login() {
		
	}
	
	@RequestMapping(value="/admin/login/loginProc.do", method=RequestMethod.POST)
	public String loginProc(@RequestParam(value="adminId") String adminId, 
			@RequestParam(value="adminPw") String adminPw, HttpSession session  ) {

		if(adminId!=null&&adminPw!=null) {
			System.out.println("11");
			if(adminId.equals("jimin")&&adminPw.equals("1234")) {
				System.out.println("�����ڷ� �α���");
				session.setAttribute("login", true);
				session.setAttribute("id", "������");
				return "redirect:/admin/main.do";
			}else {
				//���̵�� ��й�ȣ�� Ʋ�� ���
				System.out.println("12");
				return "redirect:/admin/login/login.do";
			}
		}
		System.out.println("13");
		return "redirect:/admin/login/login.do";
		
	}
	
	/**
	 * /admin/login/loginError.do
	 * �����ڷ� �α��� �� ���� ��
	 * ���ͼ��� �ߵ�
	 * 
	 */
	@RequestMapping(value="/admin/login/loginError.do")
	public void loginError() {
		
	}
	
	/**
	 * /admin/login/logout.do
	 * �α׾ƿ�
	 */
	@RequestMapping(value="/admin/login/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/login/login.do";
	}
}
