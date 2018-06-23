package xaut.wjh.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import xaut.wjh.biz.IBookServ;
import xaut.wjh.dao.IBookDao;
import xaut.wjh.entity.PageBean;
import xaut.wjh.entity.TBooks;
import xaut.wjh.util.DaoFactory;
import xaut.wjh.util.ServiceFactory;

public class BookAction extends ActionSupport implements ModelDriven<TBooks>,
SessionAware,ApplicationAware{
	 
	private static final long serialVersionUID = -760782140063295619L;
	PageBean<TBooks> page=new PageBean<TBooks>();
	ActionContext ac=ActionContext.getContext();//ActionContext对象本身就是request范围的存储空间。
	private Map<String,Object> session=ac.getSession();
	private Map<String,Object> request=(Map)ac.get("request");
	private TBooks book=new TBooks();
	private IBookServ bookServ=ServiceFactory.getBookServ();
	private int currentPage=1;//当前页
	//根据书名或作者名进行查询
	public String queryBook() {
		page.setCurrentPage(currentPage);
		List<TBooks> bookList=bookServ.qBookByNameOrAuth(book, page);
		System.out.println("bookListSize"+bookList.size());
		if(book.getName()!=null) {
			String nameUrl="";
			try {
				nameUrl=URLEncoder.encode(book.getName(),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			request.put("nameUrl",nameUrl);
		}
		request.put("bookList", bookList);
		request.put("page", page);
		return "toBookList";
	}
	
	//展示图书细节
	public String bookDetail() {
		TBooks tbook=bookServ.bookDetail(book);
		System.out.println("bookDetail"+tbook);
		request.put("bookDetail",tbook);
		return "showBookDetail";
	}
	
	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		
	}

	
	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	@Override
	public TBooks getModel() {
		System.out.println(page);
		System.out.println(book);
		return book;
	}


	public PageBean<TBooks> getPage() {
		return page;
	}


	public void setPage(PageBean<TBooks> page) {
		this.page = page;
	}
	
	

}
