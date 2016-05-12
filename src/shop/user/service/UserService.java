package shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import shop.user.dao.UserDao;
import shop.user.vo.User;
import shop.utils.MailUtils;
import shop.utils.UUIDUtils;

/**
 * �û�ģ��ҵ�����룺
 * 
 * @author Programmer
 *
 */
@Transactional
public class UserService {

	// ע��UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// ���û�����ѯ�û��ķ���
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	// ҵ�������û�ע��Ĵ���
	public void save(User user) {
		// �����ݴ��뵽���ݿ�
		user.setState(0); // 0�����û�δ���1�����û��Ѽ���
		String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);

		// ���ͼ����ʼ�
		MailUtils.sendMail(user.getEmail(), code);
	}

	// ҵ��� ���ݼ������ѯ�û�
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	// �޸��û�״̬�ķ���
	public void update(User existUser) {
		userDao.update(existUser);
	}

	// �û���¼�ķ���
	public User login(User user) {
		return userDao.login(user);
	}
}
