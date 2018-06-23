package xaut.wjh.entity;

import java.io.Serializable;
import java.util.List;

public class PageBean<T extends Serializable> implements java.io.Serializable{
	 
	private static final long serialVersionUID = -2326228060099652462L;
	private List<T> datas;//当前页面数据
	private int firstPage=1;//首页，默认为1
	private int previousPage;//上一页
	private int nextPage;//下一页
	private int totalPages;//末页，总页数
	private int currentPage=1;//当前页
	private int totalRecords;//总记录条数
	private int pageSize=5;//每页显示的总记录数默认为5，后期可修改
	
	public PageBean() {
		super();
	}
	
	public PageBean(List<T> datas, int firstPage, int previousPage, int nextPage, int totalPages, int currentPage,
			int totalRecords, int pageSize) {
		super();
		this.datas = datas;
		this.firstPage = firstPage;
		this.previousPage = previousPage;
		this.nextPage = nextPage;
		this.totalPages = totalPages;
		this.currentPage = currentPage;
		this.totalRecords = totalRecords;
		this.pageSize = pageSize;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PageBean [datas=" + datas + ", firstPage=" + firstPage + ", previousPage=" + previousPage
				+ ", nextPage=" + nextPage + ", totalPages=" + totalPages + ", currentPage=" + currentPage
				+ ", totalRecords=" + totalRecords + ", pageSize=" + pageSize + "]";
	}

	
	
	
	
}
