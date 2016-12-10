package com.ganhong.common.pojo;

public class EasyUITreeNode {

	private long id;//主键
	private String text;//名称
	private String state;//打开还是关闭，是叶子节点还是父节点
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
