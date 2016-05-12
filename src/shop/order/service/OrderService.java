package shop.order.service;

import org.springframework.transaction.annotation.Transactional;

import shop.order.dao.OrderDao;
import shop.order.vo.Order;
import shop.utils.PageBean;

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

	// ��ѯ�ҵĶ�����ҵ������
	public PageBean<Order> findByPageUid(Integer uid, Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		// ���õ�ǰҳ����
		pageBean.setPage(page);
		// ����ÿҳ��ʾ�ļ�¼����
		Integer limit = 5;
		pageBean.setLimit(limit);
		
		return pageBean;
	}
}
