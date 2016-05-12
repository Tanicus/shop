package shop.index.action;

import java.util.List;

import shop.category.service.CategoryService;
import shop.category.vo.Category;
import shop.product.service.ProductService;
import shop.product.vo.Product;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ������ҳ��Action
 * 
 * @author Programmer
 *
 */
public class IndexAction extends ActionSupport {
	
	// ע��һ�������Service
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	// ע����Ʒ��Service
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * ִ�з�����ҳ�ķ���
	 */
	public String execute() {
		// ��ѯ����һ�����༯��
		List<Category> cList = categoryService.findAll();
		// ��һ��������Ϣ���뵽Session��Χ��
		ActionContext.getContext().getSession().put("cList", cList);
		
		// ��ѯ������Ʒ
		List<Product> hList = productService.findHot();
		// ���浽ֵջ�У�
		ActionContext.getContext().getValueStack().set("hList", hList);
		
		// ��ѯ������Ʒ
		List<Product> nList = productService.findNew();
		// ���浽ֵջ��
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
	
}
