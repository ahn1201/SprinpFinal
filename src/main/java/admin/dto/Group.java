package admin.dto;

import java.sql.Date;

public class Group {
	private int group_list_no;
	private int group_no;
	private String group_id;  //�����̸�
	private String location;
	private String manager_id;
	private String theme;  //ī�װ�
	private String intro; //���� �Ұ���
	private int personnel; //�ο���
	private Date regdate; //��ϳ�¥
	private String reason; //���� ����
	private Date blocked_at; //���� ���� ��¥
	private Date blocked_end; //���� ���� ��¥

	public Date getBlocked_at() {
		return blocked_at;
	}
	public void setBlocked_at(Date blocked_at) {
		this.blocked_at = blocked_at;
	}
	public Date getBlocked_end() {
		return blocked_end;
	}
	public void setBlocked_end(Date blocked_end) {
		this.blocked_end = blocked_end;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getGroup_list_no() {
		return group_list_no;
	}
	public void setGroup_list_no(int group_list_no) {
		this.group_list_no = group_list_no;
	}
	public int getGroup_no() {
		return group_no;
	}
	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	
	
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getPersonnel() {
		return personnel;
	}
	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "[ group_list_no = "+group_list_no
				+ "group_no = "+group_no+" , group_id = "+group_id
			+" , location = "+location+" , manager_id = "+manager_id
			+" , theme = "+theme + " , personnel = "+personnel + " , intro = "+intro
			+" , regdate = "+regdate+ ", reason ="+reason+" , block_at = "+blocked_at
			+" , block_end = "+blocked_end+" ] ";
			
	}
	
}
