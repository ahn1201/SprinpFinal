package admin.service;

import java.util.List;

import admin.dto.Meet;
import admin.util.Paging;

public interface MeetService {

	/**
	 * 
	 * @return int
	 * ���� ���� ��� �� ���� ������
	 */
	public int getMeetReservTotal();

	/**
	 * 
	 * @return List
	 *  ���� ���� ��� ����¡
	 */
	public List getMeetReservPagingList(Paging paging);

	/**
	 * 
	 * @param meet
	 * @return meet
	 * ���� ���� �ڼ��� ��ü ������
	 */
	public Meet getMeetDetail(Meet meet);

	/**
	 * 
	 * @return List
	 * ����� ���� ����� ������
	 */
	public List getEndMeetList(Paging paging);

	/**
	 * 
	 * @return int
	 * ����� ���� ������ ������
	 */
	public int getEndMeetCount();

	/**
	 * ���� ����� ��� ���¸� �ٲ��� (����->����)
	 */
	public void updateMeetList();

	/**
	 * 
	 * @param meet
	 * @return boolean
	 *  ���� ����
	 */
	public boolean meetDelete(Meet meet);

}
