package admin.service;

import java.util.List;

import admin.dto.User;
import admin.util.Paging;

public interface UserService {
	
	/**
	 * 
	 * @return List 
	 * ��� User ��ü ������
	 */
	public List selectAllUser();

	/**
	 * 
	 * @param user
	 * @return user
	 * USER ��ü �ڼ��� ������
	 */
	public User getDetail(User user);
	
	/**
	 * 
	 * @param user
	 * @return boolean
	 * USER ���� ������
	 */

	public boolean deleteUser(User user);

	/**
	 * 
	 * @return int
	 * USER�� �� ������ ����
	 */
	public int getUserTotal();
	
	/**
	 * 
	 * @return List
	 * USER�� ����¡
	 */
	public List getUserPagingList(Paging paging);

	/**
	 * 
	 * @param user
	 * USER ���� ����
	 */
	public void changeStopUser(User user);

	/**
	 * 
	 * @param paging 
	 * @return List
	 * ����� ����� �ҷ�����
	 */
	public List getBlackList(Paging paging);

	/**
	 * 
	 * @return int
	 * ����� ������� ��
	 */
	public int getBlackTotal();
}
