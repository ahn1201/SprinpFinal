package admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admin.dto.User;
import admin.service.UserService;
import admin.util.Paging;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired UserService userService;
	
	
	/*
	 *  userList
	 *  ȸ�� ���� ����
	 */
	@RequestMapping(value="/admin/user/userList.do")
	public void userList(@RequestParam(defaultValue="0")int curPage,Model model) {
		int total = userService.getUserTotal();
		
		Paging paging = new Paging(total,curPage);
		model.addAttribute("paging", paging);
		
		List userList = userService.getUserPagingList(paging);
		model.addAttribute("userList", userList);
	}
	
	/*
	 *  userDetail
	 *  ȸ�� ���� �ڼ���
	 */
	@RequestMapping(value="/admin/user/userDetail.do")
	public void userDetail(User user,Model model){
		user = userService.getDetail(user);
		System.out.println(user);
		model.addAttribute("user", user);
		
	}
	
	/*
	 *  userDelete
	 *  ȸ�� ���� ����
	 */
	@RequestMapping(value="/admin/user/userDelete.do")
	public String userDelete(@RequestParam("pw") String pw,User user, HttpSession session,Model model) {
		if(!pw.equals("1234")) {
			model.addAttribute("msg", "������ ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
			model.addAttribute("url", "/admin/user/userDetail.do?u_no="+user.getU_no());
			return "admin/util/alert";
		}
			boolean result;

			result = userService.deleteUser(user);
			if(result) {
				model.addAttribute("msg", "������ ���������� �����Ǿ����ϴ�.");
				model.addAttribute("url", "/admin/user/userList.do");
			}else {
				model.addAttribute("msg", "���� ������ �����Ͽ����ϴ�.");
				model.addAttribute("url", "/admin/user/userDetail.do?u_no="+user.getU_no());
			}

		return "admin/util/alert";
	}
	
	/*
	 *  userAsk
	 *  ä�� ����
	 */
	@RequestMapping(value="/admin/user/userMessage.do")
	public void userMessage() {
		
	}
	
	/*
	 *  userBlack
	 *  ȸ�� ����
	 */
	@RequestMapping(value="/admin/user/userBlack.do")
	public String userBlack(@RequestParam("pw") String pw, User user,Model model) {
		if(!pw.equals("1234")) {
			model.addAttribute("msg", "������ ��й�ȣ�� ����� Ȯ�����ּ���.");
			model.addAttribute("url", "/admin/user/userList.do");
			return "admin/util/alert";
		}
		
		userService.changeStopUser(user);
		model.addAttribute("msg", "����Ǿ����ϴ�.");
		model.addAttribute("url", "/admin/user/userDetail.do?u_no="+user.getU_no());
		return "admin/util/alert";
		
	}
	
	
	/**
	 *  userBlackList
	 *  ȸ�� ���� ����Ʈ
	 */
	@RequestMapping(value="/admin/user/userBlackList.do")
	public void userBlackList(@RequestParam(defaultValue="0") int curPage,Model model) {
		int total = userService.getBlackTotal();
		System.out.println("����� ������� �� : "+total);
		
		Paging paging = new Paging(total,curPage);
		
		List userBlackList = userService.getBlackList(paging);
		model.addAttribute("paging", paging);
		model.addAttribute("userBlackList", userBlackList);
	}
}
