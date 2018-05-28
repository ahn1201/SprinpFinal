package admin.service;

import java.util.List;

import admin.dto.Company;
import admin.dto.Place;
import admin.util.Paging;

public interface CompanyService {

	/**
	 * 
	 * @param company
	 * @return boolean
	 *  ���� ��ü ���
	 */
	public boolean RegisterCom(Company company);

	/**
	 * 
	 * @return int
	 *  ���� ��ü ��û ��� ��ȸ
	 */
	public int getNoCompanyTotal();
	
	/**
	 * 
	 * @param paging
	 * @return List
	 *  ���� ��ü ��û ��� ����¡
	 */
	public List getNoCompanyPagingList(Paging paging);

	/**
	 * 
	 * @param company
	 * ���� ��ü ����
	 */
	public boolean companyApply(Company company);

	/**
	 * 
	 * @return
	 * ���� ��ü ��� ��������
	 */
	public int getCompanyTotal();
	
	/**
	 * 
	 * @param paging
	 * @return List
	 * ���� ��ü ��� ����¡
	 */
	public List getCompanyPagingList(Paging paging);

	/**
	 * 
	 * @param company
	 * @return company
	 * ���� ��ü �� ������
	 *
	 */
	public Company getCompanyDetail(Company company);

	/**
	 * 
	 * @param company
	 * @return boolean
	 * ���� ��ü �����ϱ�
	 */
	public boolean deleteCompanyList(Company company);

	/**
	 * 
	 * @param company
	 * ���� ��ü ����
	 */
	public void companyBlack(Company company);

	/**
	 * 
	 * @return int
	 * �ش� ���� ��ü ��� ���� 
	 */
	public int getPlaceTotal();

	/**
	 * 
	 * @param paging
	 * @return List
	 * �ش� ���� ��ü ����¡
	 */
	public List getPlacePagingList(Paging paging);

	/**
	 * 
	 * @param company
	 * @return List
	 * �ش� ���� ��ü�� ��ҵ��� �ҷ���.
	 */
	public List getCompanyPlace(Company company);

	/**
	 * 
	 * @param place
	 * @return company
	 * �Ķ���͸� place�� ���� ���޾�ü�� �ڼ��� 
	 */
	public Company getCompanyDetail2(Place place);

}
