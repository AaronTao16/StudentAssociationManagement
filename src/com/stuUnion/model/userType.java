package com.stuUnion.model;

public enum userType {

	ADMIN("ָ����ʦ/��ϯ��",0),MINISTER("����",1),MEMBER("����",2),OLDMEMBER("�����Ա",3);

	private String type;
	private int index;
	private userType(String type, int index) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.index = index;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public String toString() {
		return this.type;
	}
}
