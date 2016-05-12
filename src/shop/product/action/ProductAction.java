package shop.product.action;

import shop.category.service.CategoryService;
import shop.product.service.ProductService;
import shop.product.vo.Product;
import shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��Ʒ��Action����
 * 
 * @author Programmer
 *
 */
public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {

	// ���ڽ������ݵ�ģ������
	private Product product = new Product();

	public Product getModel() {
		return product;
	}

	// ע����Ʒ��Service
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// ���շ���cid
	private Integer cid;

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return cid;
	}

	// ���ն�������csid
	private Integer csid;

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	// ���յ�ǰҳ��
	private int page;

	public void setPage(int page) {
		this.page = page;
	}

	// ע��һ�������Service
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// ������Ʒid������Ʒ��ѯ
	public String findByPid() {
		// ����Service�ķ�����ɵ���
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}

	// ���ݷ����ID��ѯ��Ʒ
	public String findByCid() {
		PageBean<Product> pageBean = productService.findByPageCid(cid, page); // ����һ�������ѯ��Ʒ������ҳ�Ĳ�ѯ
		// ��pageBean���뵽ֵջ�У�
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}

	// ���ݶ�������
	public String findByCsid() {
		// ���ݶ��������ѯ��Ʒ
		PageBean<Product> pageBean = productService.findByCsid(csid, page);
		// ��pageBean���뵽ֵջ�У�
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}

}
