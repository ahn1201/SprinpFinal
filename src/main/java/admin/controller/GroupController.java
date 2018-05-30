package admin.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import admin.dto.Group;
import admin.dto.Meet;
import admin.service.GroupService;
import admin.util.Paging;

@Controller
public class GroupController {

	private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
	
	@Autowired GroupService groupService;
	
	/**
	 *  ���� ��� 
	 */
	@RequestMapping(value="/admin/group/groupList.do",method=RequestMethod.GET)
	public void groupList(@RequestParam(defaultValue="0") int curPage,Model model,Paging search) {
		
		//�˻��� �� �� ������ �˻��� ���� ���������� �˻� paging�� ������ (daoImpl���� ������ if������ ����)
		int total = groupService.getGroupTotal(search);
		
		//����¡ ��ü ������ ����
		Paging paging = new Paging(total,curPage);
		
		//�⺻ ����¡ ��ü���ٰ� �˻��� ���� �Է�����
		paging.setSearch(search.getSearch());
		model.addAttribute("paging", paging);
		//������ search �����߱� ������ ������ -> daoImpl���� ������.
		List groupList = groupService.getGroupPagingList(paging);
		//paging.jsp���� ��� �� ���� ������ �־�� �ؼ� search ���� ������.
		model.addAttribute("search", search.getSearch());
		model.addAttribute("groupList", groupList);

	}
	/**
	 * 
	 * @param group
	 * ���� �ڼ��� 
	 * + ������ ����鵵 ������
	 */
	@RequestMapping(value="/admin/group/groupDetail.do")
	public void groupDetail(Group group,Meet meet,Model model) {
		group = groupService.getGroupDetail(group);
		model.addAttribute("group", group);
		List meetList = groupService.getMeetList(group);
		model.addAttribute("meetList", meetList);
	}
	
	/**
	 *  ���� ����
	 */
	@RequestMapping(value="/admin/group/groupModify.do")
	public void groupModify(Group group,Model model) {
		group  = groupService.getGroupDetail(group);
		model.addAttribute("group", group);
		
	}
	
	/**
	 *  ���� ����
	 */
	@RequestMapping(value="/admin/group/groupDelete.do")
	public String groupDelete(Group group,Model model,@RequestParam("pw") String pw) {
		if(!pw.equals("1234")) {
			model.addAttribute("msg", "���������� ������ �����Ͽ����ϴ�.");
			model.addAttribute("url", "/admin/group/groupList.do");
			return "admin/util/alert";
		}

	
		boolean res = groupService.deleteGroup(group);
		if(res) {
			model.addAttribute("msg", "���������� ������ �Ϸ�Ǿ����ϴ�.");
			model.addAttribute("url", "/admin/group/groupList.do");
		}else{
			model.addAttribute("msg", "���������� ������ �����Ͽ����ϴ�.");
			model.addAttribute("url", "/admin/group/groupList.do");
		}
		
		return "admin/util/alert";
	}
	
	/**
	 *  ���� ���� ������ (ȫ���� ����)
	 */
	@RequestMapping(value="/admin/group/groupBlack.do",method=RequestMethod.GET)
	public void groupBlack(Group group, Model model) {
		model.addAttribute("group", group);
		
	}
	
	/**
	 *  ���� ���� ���
	 */
	@RequestMapping(value="/admin/group/groupBlock.do",method=RequestMethod.POST)
	public String groupBlockDo(Group group) {
		groupService.blockGroup(group);
		return "redirect:/admin/group/groupDetail.do?group_no="+group.getGroup_no();
	}
	
	/**
	 *  ���� ���� Ǯ��
	 */
	@RequestMapping(value="/admin/group/groupNoBlock.do",method=RequestMethod.GET)
	public String groupNoBlock(Group group, Model model) {
		groupService.noBlockGroup(group);
		model.addAttribute("msg", "���� Ǯ����.");
		model.addAttribute("url", "/admin/group/groupDetail.do?group_no="+group.getGroup_no());
		return "admin/util/alert";
	}
}
