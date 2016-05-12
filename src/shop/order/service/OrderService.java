package shop.order.service;

import org.springframework.transaction.annotation.Transactional;

import shop.order.dao.OrderDao;
import shop.order.vo.Order;

/**
 * ����ģ��ҵ������
 * 
 * @author Programmer
 *
 */
@Transactional
public class OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	// ���涩����ҵ������
	public void save(Order order) {
		orderDao.save(order);
	}
}
