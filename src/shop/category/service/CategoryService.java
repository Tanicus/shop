package shop.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import shop.category.dao.CategoryDao;
import shop.category.vo.Category;

/**
 * һ�������ҵ������
 * 
 * @author Programmer
 *
 */
@Transactional
public class CategoryService {
	
	// ע��CategoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	// ҵ����ѯ����һ������ķ���
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	// ҵ��㱣��һ������ķ���
	public void save(Category category) {
		categoryDao.save(category);
	}

	// ҵ������cid��ѯһ������
	public Category findByCid(Integer cid) {
		return categoryDao.findByCid(cid);
	}

	// ҵ���ɾ��һ������ķ���
	public void delete(Category category) {
		categoryDao.delete(category);
	}
	
}
