package shop.product.adminaction;

import shop.product.service.ProductService;
import shop.product.vo.Product;
import shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨��Ʒ�����Action
 * 
 * @author Programmer
 *
 */
public class AdminProductAction extends ActionSupport implements
		ModelDriven<Product> {

	// ģ������ʹ�õĶ���
	private Product product = new Product();

	public Product getModel() {
		return product;
	}

	// ע����Ʒ��Service
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// ����page����
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// ����ҳ�Ĳ�ѯ��Ʒ��ִ�з���
	public String findAll() {
		// ����Service����ɲ�ѯ����
		PageBean<Product> pageBean = productService.findByPage(page);
		// �����ݴ��ݵ�ҳ����
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
}
