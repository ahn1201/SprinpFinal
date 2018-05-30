package admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import admin.dto.Board;
import admin.service.MainService;
import admin.service.MeetService;
import admin.util.Paging;
import lombok.Builder.Default;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired MainService mainService;
	@Autowired MeetService meetService;
	
	
	/**
	 * ���� ������
	 * 
	 */
	@RequestMapping(value="/admin/main.do", method=RequestMethod.GET)
	public void main() {
		
	}
	
	/**
	 *  �������� ����
	 */
	@RequestMapping(value="/admin/main/mainNotice.do",method=RequestMethod.GET)
	public void mainNotice(@RequestParam(defaultValue="0")int curPage, Model model,Paging search) {
		int total = mainService.getNoticeTotal(search);
		
		Paging paging = new Paging(total,curPage);
		
		paging.setSearch(search.getSearch());
		List mainNoticeList = mainService.getPagingNoticeList(paging);
		
		model.addAttribute("search", search.getSearch());
		model.addAttribute("paging", paging);
		model.addAttribute("mainNoticeList",mainNoticeList);
	}
	
	
	/**
	 *  �������� �ۼ� ������
	 */
	@RequestMapping(value="/admin/main/mainNoticeWrite.do",method=RequestMethod.GET)
	public void mainNoticeWrite() {
		
	}
	
	/**
	 *  �������� �ۼ� POST
	 */
	@RequestMapping(value="/admin/main/mainNoticeWrite.do",method=RequestMethod.POST)
	public String mainNoticeWriteDo(Board board,Model model) {
		System.out.println(board);
		boolean result = mainService.mainNoticeInsert(board);
		if(result) {
			model.addAttribute("msg", "�������� ���� �ۼ��Ǿ����ϴ�.");
			model.addAttribute("url", "/admin/main/mainNotice.do");
		}else {
			model.addAttribute("msg", "�������� ���� �ۼ��Ǿ����ϴ�.");
			model.addAttribute("url", "/admin/main/mainNoticeWrite.do");
		}
		return "admin/util/alert";
	}
	
	/**
	 * 
	 * @param board
	 * @param model
	 * �������� �ڼ��� 
	 */
	@RequestMapping(value="/admin/main/mainNoticeDetail.do")
	public void mainNoticeDetail(Board board, Model model) {
		board = mainService.getNoticeDetail(board);
		System.out.println(board);
		model.addAttribute("board", board);
	}
	
	
	/**
	 *  �������� ����
	 */
	@RequestMapping(value="/admin/main/mainNoticeDelete.do")
	public String mainNoticeDelete(Board board) {
		mainService.mainNoticeDelete(board);
		return "redirect:/admin/main/mainNotice.do";
	}
	
	/**
	 *  �������� ����
	 */
	@RequestMapping(value="/admin/main/mainNoticeModify.do", method=RequestMethod.GET)
	public void mainNoticeModify(Board board, Model model){
		board = mainService.getNoticeDetail(board);
		System.out.println("��¥ ������ : "+board);
		model.addAttribute("board", board);
	}
	
	@RequestMapping(value="/admin/main/mainNoticeModify.do", method=RequestMethod.POST)
	public String mainNoticeModifyDo(Board board) {
		System.out.println("����~");
		System.out.println("��¥ board = "+board);
		mainService.mainNoticeModify(board);
		return "redirect:/admin/main/mainNoticeDetail.do?board_no="+board.getBoard_no();
	}
	
	/**
	 *  ���� ����
	 */
	@RequestMapping(value="/admin/main/mainAdver.do")
	public void mainAdver() {
		
	}

}
