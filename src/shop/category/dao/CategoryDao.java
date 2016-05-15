package shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.category.vo.Category;

public class CategoryDao extends HibernateDaoSupport {

	// DAO���ѯ����һ������ķ���
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// DAO�㱣��һ������ķ���
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}

	// DAO�����cid��ѯһ������
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	// DAO��ɾ��һ������ķ���
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
	}

}
