package com.ym.customer.domain;

import java.util.List;

public class PageBean<T> {
	private int totalRecord;
	private int pageSize;//ÿҳ��С����¼����
	//private int totalPage;//��ҳ��
	private int pageCode;//��ǰҳ��
	private List<Customer> beanList;
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(int totalRecord, int pageSize, int pageCode,
			List<Customer> beanList) {
		super();
		this.totalRecord = totalRecord;
		this.pageSize = pageSize;
	//	this.totalPage = totalPage;
		this.pageCode = pageCode;
		this.beanList = beanList;
	}
	@Override
	public String toString() {
		return "PageBean [totalRecord=" + totalRecord + ", pageSize="
				+ pageSize + ", pageCode=" + pageCode + ", beanList="
				+ beanList + "]";
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		int tp = totalRecord/pageSize;
		return totalRecord%pageSize==0 ? tp :tp+1;
	}
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	public List<Customer> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<Customer> beanList) {
		this.beanList = beanList;
	}
	
	
}
