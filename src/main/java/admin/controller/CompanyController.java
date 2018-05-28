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

import admin.dto.Company;
import admin.dto.Place;
import admin.service.CompanyService;
import admin.util.Paging;

@Controller
public class CompanyController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired CompanyService companyService;

	/**
	 *  ���� ��ü ���
	 */
	@RequestMapping(value="/admin/company/companyList.do")
	public void companyList(@RequestParam(defaultValue="0")int curPage,Model model) {
		int total = companyService.getCompanyTotal();
		System.out.println(total);
		
		Paging paging = new Paging(total,curPage);
		System.out.println(paging);
		model.addAttribute("paging", paging);
		
		List companyList = companyService.getCompanyPagingList(paging);
		model.addAttribute("companyList", companyList);
	}
	
	/**
	 * ���� ��ü �� ������
	 */
	@RequestMapping(value="/admin/company/companyListDetail.do")
	public void companyListDetail(Company company,Model model) {
		
		company = companyService.getCompanyDetail(company);
		
		
		List placeList = companyService.getCompanyPlace(company);
		
		
		System.out.println("place : "+placeList);
		System.out.println("company : "+company);
		
		model.addAttribute("company", company);
		model.addAttribute("placeList", placeList);
	}
	
	@RequestMapping(value="/admin/company/companyListDetail2.do")
	public void companyListDetail2(Place place, Model model) {
		Company company = companyService.getCompanyDetail2(place);
		model.addAttribute("company", company);
		List placeList = companyService.getCompanyPlace(company);
		model.addAttribute("placeList", placeList);
		System.out.println("�̾߿� : "+company);
		
		
	}
	
	
	/**
	 * ���� ��ü ����
	 *
	 */
	@RequestMapping(value="/admin/company/companyListDelete.do")
	public String companyListDelete(@RequestParam("pw") String pw,Company company,Model model) {
		if(!pw.equals("1234")) {
			model.addAttribute("msg", "������ ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
			model.addAttribute("url", "/admin/company/companyList.do");
			return "admin/util/alert";
		}
		boolean result = companyService.deleteCompanyList(company);
		if(result) {
			model.addAttribute("msg", "������ �Ϸ�Ǿ����ϴ�.");
			model.addAttribute("url", "/admin/company/companyList.do");
		}
		return "admin/util/alert";
		
	}
	
	/**
	 *  ���� ��ü ��û ���
	 */
	@RequestMapping(value="/admin/company/companyApp.do")
	public void companyApp(@RequestParam(defaultValue="0")int curPage,Model model) {
		int total = companyService.getNoCompanyTotal();
		System.out.println(total);
		
		Paging paging = new Paging(total,curPage);
		model.addAttribute("paging", paging);
		
		List noCompanyList = companyService.getNoCompanyPagingList(paging);
		System.out.println(noCompanyList);
		model.addAttribute("noCompanyList", noCompanyList);
		
	}
	
	/**
	 * ���� ��ü ��û �� ������
	 */
	@RequestMapping(value="/admin/company/companyAppDetail.do")
	public void companyAppDetail(Company company,Model model) {
		company = companyService.getCompanyDetail(company);
		model.addAttribute("company", company);
	}
	
	/**
	 * 
	 *  ���� ��ü ���� ���
	 */
	@RequestMapping(value="/admin/company/companyApply.do")
	public String companyApply(@RequestParam("pw") String pw,Company company,Model model) {
		if(!pw.equals("1234")) {
			model.addAttribute("msg","������ ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
			model.addAttribute("url", "/admin/company/companyApp.do");
			return "admin/util/alert";
		}
		
		boolean result = companyService.companyApply(company);
		if(result) {
			model.addAttribute("msg","������ �Ϸ�Ǿ����ϴ�.");
			model.addAttribute("url", "/admin/company/companyApp.do");
		}else {
			model.addAttribute("msg","���� �����Ͽ����ϴ�.");
			model.addAttribute("url", "/admin/company/companyApp.do");
		}
		return "admin/util/alert";
			
	}
	
	/**
	 *  ���� ��û ����
	 */
	@RequestMapping(value="/admin/company/companyAsk.do")
	public void companyAsk() {
		
	}
	
	/**
	 *  ���� ��ü ���
	 */
	@RequestMapping(value="/admin/company/companyReg.do")
	public void companyReg() {
		
	}
	
	@RequestMapping(value="/admin/company/companyReg.do", method=RequestMethod.POST)
	public String companyRegProc(Company company,Model model) {
		boolean result = companyService.RegisterCom(company);
		if(result) {
			model.addAttribute("msg", "��� �Ϸ�Ǿ����ϴ�.");
			model.addAttribute("url", "/admin/company/companyReg.do");
		}else {
			model.addAttribute("msg", "�ٽ� ������ּ���.");
			model.addAttribute("url", "/admin/company/companyReg.do");
		}
		return "admin/util/alert";
	}
	
	/**
	 *  ���� ��ü ��� ����Ʈ
	 */
	@RequestMapping(value="/admin/company/companyBoard.do")
	public void companyBoard(@RequestParam(defaultValue="0")int curPage, Model model) {
		int total = companyService.getPlaceTotal();
		System.out.println("place ���� = "+total);
		
		
		Paging paging = new Paging(total,curPage);
		List placeList = companyService.getPlacePagingList(paging);
		System.out.println(placeList);
		model.addAttribute("paging", paging);
		model.addAttribute("placeList", placeList);
	}
	
	/**
	 *  ���� ��ü ����
	 */
	@RequestMapping(value="/admin/company/companyBlack.do")
	public String companyBlack(@RequestParam("pw") String pw,Company company,Model model) {
		if(!pw.equals("1234")) {
			model.addAttribute("msg", "������ ��й�ȣ�� �ٽ� Ȯ�����ּ���");
			model.addAttribute("url", "/admin/company/companyList.do");
			return "admin/util/alert";
		}
		
		companyService.companyBlack(company);
		return "redirect:/admin/company/companyListDetail.do?com_no="+company.getCom_no();
	}
	
}
