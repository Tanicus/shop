package shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.product.vo.Product;
import shop.utils.PageHibernateCallback;

/**
 * ��Ʒ�ĳ־ò����
 * 
 * @author Programmer
 *
 */
public class ProductDao extends HibernateDaoSupport {

	// ��ҳ��������Ʒ��ѯ
	public List<Product> findHot() {
		// ʹ������������ѯ
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// ��ѯ���ŵ���Ʒ����������is_hot=1
		criteria.add(Restrictions.eq("is_hot", 1));
		// �����������
		criteria.addOrder(Order.desc("pdate"));
		// ִ�в�ѯ
		List<Product> list = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 10);

		return list;
	}

	// ��ҳ��������Ʒ�Ĳ�ѯ
	public List<Product> findNew() {
		// ʹ������������ѯ:
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// �����ڽ��е�������:
		criteria.addOrder(Order.desc("pdate"));
		// ִ�в�ѯ��
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}

	// ������ƷID��ѯ��Ʒ
	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	// ���ݷ���ID��ѯ��Ʒ����
	public int findCountCid(Integer cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, cid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// ���ݷ���ID������Ʒ����
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// ���ݶ��������ѯ��Ʒ����
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// ���ݶ��������ѯ��Ʒ����
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
}