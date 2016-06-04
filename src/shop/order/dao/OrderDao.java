package shop.order.dao;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.order.vo.Order;
import shop.user.vo.User;
import shop.utils.PageHibernateCallback;

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

	// DAO���ҵĶ�������ͳ��
	public Integer findByCountUid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.uid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return null;
	}
	

	// DAO���ҵĶ�����ѯ
	public List<Order> findByPageUid(Integer uid, Integer begin, Integer limit) {
		String hql = "from Order o where o.user.uid = ? order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{uid}, begin, limit));
		return list;
	}

	// ���ݶ���ID��ѯ����DAO�����
	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	// Dao����޸Ķ����Ĳ���
	public void update(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);
	}

	// DAO��ͳ�ƶ��������ķ���
	public int findByCount() {
		String hql = "select count(*) from Order";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// DAO��Ĵ���ҳ��ѯ�ķ���
	public List<Order> findByPage(int begin, int limit) {
		String hql = "from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, null, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
