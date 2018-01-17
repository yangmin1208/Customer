package com.ym.customer.domain;

import java.util.List;

public class PageBean<T> {
	private int totalRecord;
	private int pageSize;//每页大小（记录数）
	//private int totalPage;//总页数
	private int pageCode;//当前页码
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
