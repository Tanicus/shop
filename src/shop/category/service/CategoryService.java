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
	
}
