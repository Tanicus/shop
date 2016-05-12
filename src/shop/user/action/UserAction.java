package shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import shop.user.service.UserService;
import shop.user.vo.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * �û�ģ��Action����
 * 
 * @author Programmer
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

	// ģ������Ҫʹ�õĶ���
	private User user = new User();

	public User getModel() {
		return user;
	}
	
	// ������֤��
	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	// ע��UserService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * ��ת��ע��ҳ���ִ�з���
	 */
	public String registPage() {

		return "registPage";
	}

	/**
	 * Ajax�����첽У���û�����ִ�з���
	 * 
	 * @throws IOException
	 */
	public String findByName() throws IOException {
		// ����Service���в�ѯ
		User existUser = userService.findByUsername(user.getUsername());
		// ���response������ ҳ�����
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// �ж�
		if (existUser != null) {
			response.getWriter().println("<font color='red'>�û����Ѿ�����</font>");
		} else {
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		return NONE;
	}

	/**
	 * �û�ע��ķ���
	 */
	public String regist() {
		// �ж���֤�����
		// ��sessio�л����֤������ֵ��
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if (!checkcode.equalsIgnoreCase(checkcode1)) {
			this.addActionError("��֤���������");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("ע��ɹ�����ȥ���伤�");
		return "msg";
	}

	/**
	 * �û�����ķ���
	 * 
	 */
	public String active() {
		// ���ݼ������ѯ�û�
		User existUser = userService.findByCode(user.getCode());
		if (existUser == null) {
			this.addActionMessage("����ʧ�ܣ����������");
		} else {
			existUser.setState(1);
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("����ɹ������¼��");
		}
		return "msg";
	}

	/**
	 * ��ת����¼ҳ��
	 * 
	 * @return
	 */
	public String loginPage() {
		return "loginPage";
	}

	/**
	 * ��¼�ķ���
	 * 
	 * @return
	 */
	public String login() {
		User existUser = userService.login(user);
		if (existUser == null) {
			this.addActionError("��¼ʧ�ܣ��û��������������û�δ���");
			return LOGIN;
		} else {
			// ���û�����Ϣ���뵽session��
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			// ���ҳ�����ת
			return "loginSuccess";
		}
	}
	
	/**
	 * �û��˳��ķ���
	 * @return
	 */
	public String quit() {
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
