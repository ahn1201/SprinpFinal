package admin.service;

import java.util.List;

import admin.dto.Group;
import admin.util.Paging;

public interface GroupService {

	/**
	 * 
	 * @return int
	 * ���� �� ���� ��������
	 */
	public int getGroupTotal();
	
	/**
	 * 
	 * @param paging
	 * @return list
	 * ���� ����Ʈ ����¡ ó��
	 */
	public List getGroupPagingList(Paging paging);

	/**
	 * 
	 * @param group
	 * @return group
	 *  ���� �ڼ��� ��������
	 */
	public Group getGroupDetail(Group group);

	/**
	 * 
	 * @param group
	 * @return list
	 * �ش� ������ ������� ��������
	 */
	public List getMeetList(Group group);

	/**
	 * 
	 * @param group
	 * �ش� ���� �����ϱ�
	 */
	public Boolean deleteGroup(Group group);

	/**
	 * 
	 * @param group
	 * �ش� ���� �����ϱ�
	 */
	public void blockGroup(Group group);

	/**
	 * 
	 * @param group
	 * �ش� ���� ���� Ǯ��
	 */
	public void noBlockGroup(Group group);


}
