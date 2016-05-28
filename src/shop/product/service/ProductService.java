package shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import shop.product.dao.ProductDao;
import shop.product.vo.Product;
import shop.utils.PageBean;

/**
 * ��Ʒ��ҵ������
 * 
 * @author Programmer
 *
 */
@Transactional
public class ProductService {
	// ע��ProductDao
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	// ��ҳ��������Ʒ�Ĳ�ѯ
	public List<Product> findHot() {
		return productDao.findHot();
	}

	// ��ҳ��������Ʒ�Ĳ�ѯ
	public List<Product> findNew() {
		return productDao.findNew();
	}

	// ������ƷID��ѯ��Ʒ
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	// ����һ�������cid����ҳ��ѯ��Ʒ
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// ���õ�ǰҳ����
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼����
		int limit = 8;
		pageBean.setLimit(limit);
		// �����ܼ�¼����
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		// ������ҳ����
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ÿҳ��ʾ�����ݼ���
		int begin = (page - 1) * limit;

		List<Product> list = productDao.findByPageCid(cid, begin, limit);
		pageBean.setList(list);

		return pageBean;
	}

	public PageBean<Product> findByCsid(Integer csid, int page) {
		// ���ݶ��������ѯ��Ʒ
		PageBean<Product> pageBean = new PageBean<Product>();
		// ���õ�ǰҳ����
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼����
		int limit = 8;
		pageBean.setLimit(limit);
		// �����ܼ�¼����
		int totalCount = 0;
		totalCount = productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		// ������ҳ����
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ÿҳ��ʾ�����ݼ���
		int begin = (page - 1) * limit;

		List<Product> list = productDao.findByPageCsid(csid, begin, limit);
		pageBean.setList(list);

		return pageBean;
	}

	// ҵ������ҳ��ѯ��Ʒ�ķ���
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// ���õ�ǰҳ����
		pageBean.setPage(page);
		// ����ÿҳ��ʾ�ļ�¼��
		int limit = 10;
		pageBean.setLimit(limit);
		// �����ܵü�¼��
		int totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		// ������ҳ��
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ������ʾ��ҳ������ݼ���
		int begin = (page - 1) * limit; 
		List<Product> list = productDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// ҵ��㱣����Ʒ�ķ���
	public void save(Product product) {
		productDao.save(product);
	}

	// ҵ���ɾ����Ʒ�ķ���
	public void delete(Product product) {
		productDao.delete(product);
	}

}
