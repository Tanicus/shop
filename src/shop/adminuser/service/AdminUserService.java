package shop.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import shop.adminuser.dao.AdminUserDao;
import shop.adminuser.vo.AdminUser;

/**
 * ��̨��¼��ҵ�����
 * 
 * @author Programmer
 *
 */
@Transactional
public class AdminUserService {
	// ע��Dao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	// ��̨��¼��ҵ��㷽��
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}

}
