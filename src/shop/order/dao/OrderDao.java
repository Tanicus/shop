package shop.order.dao;

import java.util.Date;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.order.vo.Order;
import shop.user.vo.User;

/**
 * ����ģ��־ò����
 * 
 * @author Programmer
 *
 */
public class OrderDao extends HibernateDaoSupport {

	// ���涩����DAO�㷽��
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

}
