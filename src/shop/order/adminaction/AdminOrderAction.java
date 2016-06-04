package shop.order.adminaction;

import java.util.List;

import org.hibernate.ejb.criteria.OrderImpl;

import shop.order.service.OrderService;
import shop.order.vo.Order;
import shop.order.vo.OrderItem;
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
	
	// ���ݶ���ID��ѯ������
	public String findOrderItem() {
		// ���ݶ���ID��ѯ������
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		// ͨ��ֵջ��ʾ��ҳ����
		ActionContext.getContext().getValueStack().set("list", list);
		return "findOrderItem";
	}
	
	// �޸Ķ���״̬�ķ���
	public String updateState() {
		// 1.���ݶ���ID��ѯ����
		Order currOrder = orderService.findByOid(order.getOid());
		// 2.�޸Ķ���״̬
		currOrder.setState(3);
		orderService.update(currOrder);
		// 3.ҳ����ת
		return "updateStateSuccess";
	}
}
