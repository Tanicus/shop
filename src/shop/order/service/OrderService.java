package shop.order.service;

import java.util.List;

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
		// �����ܼ�¼����
		Integer totalCount = null;
		totalCount = orderDao.findByCountUid(uid);
		pageBean.setTotalCount(totalCount);
		// ������ҳ����
		Integer totalPage =null;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ����ÿҳ��ʾ���ݼ���
		Integer begin = (page -1 ) * limit;
		List<Order> list = orderDao.findByPageUid(uid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// ���ݶ���ID��ѯ����ҵ������
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}

	// ҵ����޸Ķ����Ĳ���
	public void update(Order currOrder) {
		orderDao.update(currOrder);
	}
}
