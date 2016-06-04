package shop.order.adminaction;

import shop.order.service.OrderService;
import shop.order.vo.Order;
import shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨���������Action
 * 
 * @author Programmer
 *
 */
public class AdminOrderAction extends ActionSupport implements
		ModelDriven<Order> {

	// ����ģ��������order����
	private Order order = new Order();

	public Order getModel() {
		return order;
	}

	// ע�붩�������Service
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	// ����page����
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}
	
	// ����ҳ��ѯ��ִ�з���
	public String findAll() {
		// ��ҳ��ѯ
		PageBean<Order> pageBean = orderService.findByPage(page);
		// ͨ��ֵջ�������ݵ�ҳ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ҳ����ת
		return "findAll";
	}
}
