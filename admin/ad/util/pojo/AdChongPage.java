package ad.util.pojo;

import java.util.List;

import ad.po.Chong;

public class AdChongPage {
	private int size;			//显示多少条
	private int start;			//当前页码
	private int index;			//偏移量
	private int totalPage;		//总页数
	private String keyword;		//关键字
	private int result;
	private List<Chong> allC;	//保存查询结果
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public List<Chong> getAllC() {
		return allC;
	}
	public void setAllC(List<Chong> allC) {
		this.allC = allC;
	}
	
}
