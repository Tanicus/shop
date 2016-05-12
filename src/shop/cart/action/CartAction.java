package shop.cart.action;

import org.apache.struts2.ServletActionContext;

import shop.cart.vo.Cart;
import shop.cart.vo.CartItem;
import shop.product.service.ProductService;
import shop.product.vo.Product;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ﳵAction
 * 
 * @author Programmer
 *
 */
public class CartAction extends ActionSupport {
	// ����pid
	private Integer pid;
	// ��������count
	private Integer count;
	// ע����Ʒ��Service
	private ProductService productService;

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// ����������ӵ����ﳵ��ִ�з���
	public String addCart() {
		// ��װһ��CartItem����
		CartItem cartItem = new CartItem();
		// ��������
		cartItem.setCount(count);
		// ����pid��ѯ��Ʒ
		Product product = productService.findByPid(pid);
		// ������Ʒ
		cartItem.setProduct(product);
		// ����������ӵ����ﳵ
		Cart cart = getCart();
		cart.addCart(cartItem);

		return "addCart";
	}

	// ��չ��ﳵ��ִ�з���
	public String clearCart() {
		// ��ù��ﳵ����
		Cart cart = getCart();
		// ���ù��ﳵ�е���շ���
		cart.clearCart();
		return "clearCart";
	}

	// �ӹ��ﳵ���Ƴ�������ķ���
	public String removeCart() {
		// ��ù��ﳵ����
		Cart cart = getCart();
		// ���ù��ﳵ���Ƴ��ķ�����
		cart.removeCart(pid);

		return "removeCart";
	}
	
	// �ҵĹ��ﳵ��ִ�з���
	public String myCart() {
		return "myCart";
	}
	
	/**
	 * ��ù��ﳵ�ķ�������Session�л��
	 * 
	 */
	private Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			ServletActionContext.getRequest().getSession()
					.setAttribute("cart", cart);
		}
		return cart;
	}
}
