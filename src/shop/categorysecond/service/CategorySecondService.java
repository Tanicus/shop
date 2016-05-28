package shop.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import shop.categorysecond.dao.CategorySecondDao;
import shop.categorysecond.vo.CategorySecond;
import shop.utils.PageBean;

/**
 * ��̨�������������ҵ������
 * 
 * @author Programmer
 *
 */
@Transactional
public class CategorySecondService {
	// ע����������DAO
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	// ҵ����ҳ��ѯ��������ķ���
	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		// ���õ�ǰҳ����
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼����
		int limit = 10;
		pageBean.setLimit(limit);
		// �����ܵļ�¼����
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		// ������ҳ����
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ����ÿҳ��ʾ���ݼ��ϣ�
		int begin = (page - 1) * limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// ҵ��㱣���������ķ���
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond); 
	}

	// ҵ�����ݶ�������ID��ѯ��������
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}
	
	// ҵ���ɾ����������ķ���
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	// ҵ����޸Ķ�������ķ���
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}
	
}