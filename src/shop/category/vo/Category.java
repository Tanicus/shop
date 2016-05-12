package shop.category.vo;

import java.util.HashSet;
import java.util.Set;

import shop.categorysecond.vo.CategorySecond;

/**
 * һ�������ʵ�������
 * 
 * @author Programmer
 *
 */
public class Category {
	private Integer cid;
	private String cname;
	
	// һ�������д�ŵ� ��������ļ��ϣ�
	private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	
}
