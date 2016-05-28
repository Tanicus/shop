package shop.category.adminaction;

import java.util.List;

import shop.category.service.CategoryService;
import shop.category.vo.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨һ����������Action
 * 
 * @author Programmer
 *
 */
public class AdminCategoryAction extends ActionSupport implements
		ModelDriven<Category> {

	// ģ������ʹ�õ��ࣺ
	private Category category = new Category();

	// ע��һ�������Service��
	CategoryService categoryService;

	public Category getModel() {
		return category;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// ��ִ̨�в�ѯ����һ������ķ���
	public String findAll() {
		// ��ѯ����һ������
		List<Category> cList = categoryService.findAll();
		// �����ϵ�������ʾ��ҳ����
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	// ��̨����һ������ķ���
	public String save() {
		// ����Service���б���
		categoryService.save(category);
		// ҳ����ת
		return "saveSuccess";
	}
	
	// ��̨ɾ��һ������ķ���
	public String delete() {
		// ʹ��ģ����������cid��ͬʱɾ��һ����������Ķ�������
		category = categoryService.findByCid(category.getCid());
		// ɾ��
		categoryService.delete(category);
		// ҳ����ת
		return "deleteSuccess";
	} 
	
	// ��̨�༭һ������ķ���
	public String edit() {
		// ����һ������Ĺ����ѯһ������
		category = categoryService.findByCid(category.getCid());
		// ҳ����ת
		return "editSuccess";
	}
	
	// ��̨�޸�һ������ķ���
	public String update() {
		categoryService.update(category);
		// ҳ����ת
		return "updateSuccess";
	}
}
