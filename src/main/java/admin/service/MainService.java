package admin.service;

import java.util.List;

import admin.dto.Board;
import admin.util.Paging;

public interface MainService {

	/**
	 * 
	 * @param board
	 * �������� �ۼ�
	 */
	public Boolean mainNoticeInsert(Board board);
	public void mainNoticeDelete(Board board);
	
	/**
	 * 
	 * @param board
	 * @return 
	 * �������� ����
	 */
	public void mainNoticeModify(Board board);
	
	/**
	 * 
	 * @param search 
	 * @return int
	 * �������� �� ���� ��������
	 */
	public int getNoticeTotal(Paging search);
	/**
	 * 
	 * @param paging
	 * @return List
	 *  �������� ����¡ �ϱ�
	 */
	public List getPagingNoticeList(Paging paging);
	/**
	 * 
	 * @param board
	 * @return board
	 *  �������� �� ������
	 */
	public Board getNoticeDetail(Board board);
}
