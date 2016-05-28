package shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import shop.adminuser.service.AdminUserService;
import shop.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨��¼��action
 * 
 * @author Programmer
 *
 */
public class AdminUserAction extends ActionSupport implements
		ModelDriven<AdminUser> {

	// ģ������ʹ�õĶ���
	private AdminUser adminUser = new AdminUser();

	// ע��Service
	private AdminUserService adminUserService;
	
	public AdminUser getModel() {
		return adminUser;
	}

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	// ��̨��¼�ķ�����
	public String login() {
		// ����Service��ɵ�¼
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if (existAdminUser == null) {
			this.addActionError("�û������������");
			return "loginFail";
		} else {
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}

}
