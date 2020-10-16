package com.stuUnion.model;

public enum userType {

	ADMIN("指导老师/主席团",0),MINISTER("部长",1),MEMBER("干事",2),OLDMEMBER("往届成员",3);

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
