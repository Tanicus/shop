package shop.order.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import shop.cart.vo.Cart;
import shop.cart.vo.CartItem;
import shop.order.service.OrderService;
import shop.order.vo.Order;
import shop.order.vo.OrderItem;
import shop.user.vo.User;
import shop.utils.PageBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ���������Action
 * 
 * @author Programmer
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {

	// ģ������ʹ�õĶ���
	private Order order = new Order();

	public Order getModel() {
		return order;
	}

	// ע��OrderService
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	// ����page������
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// ���ɶ����ķ���
	public String save() {
		// 1.�������ݵ����ݿ�
		// �������ݲ�ȫ
		order.setOrdertime(new Date());
		order.setState(1); // 1��δ���2���Ѹ����û������3���ѷ�����ûȷ���ջ���4����ɽ���
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			this.addActionError("���ﳵ�ǿյģ���ȥ���ɣ�");
			return "msg";
		}
		order.setTotal(cart.getTotal());
		// ���ö����еĶ�����
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);

			order.getOrderItems().add(orderItem);
		}
		// ���ö��������û�
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if (existUser == null) {
			this.addActionError("����û�е�¼������ȥ��¼��");
			return "login";
		}
		order.setUser(existUser);
		orderService.save(order);
		// 2.������������ʾ��ҳ����
		// ͨ��ֵջ�ķ�ʽ��ʾ��
		return "saveSuccess";
	}
	
	// �ҵĶ����Ĳ�ѯ
	public String findByUid() {
		// �����û���ID��ѯ
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		PageBean<Order> pageBean = orderService.findByPageUid(user.getUid(), page);
	}
	
	
	
	
	
	
	
	
}
