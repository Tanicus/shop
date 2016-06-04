package shop.interceptor;

import org.apache.struts2.ServletActionContext;

import shop.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * ��̨Ȩ��У�����������û�е�¼���û������Է���
 * 
 * @author Programmer
 *
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {

	// ִ�����صķ���
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// �ж�Session���Ƿ񱣴��˺�̨�û�����Ϣ
		AdminUser existAdminUser = (AdminUser) ServletActionContext.getRequest().getSession().getAttribute("existAdminUser");
		if (existAdminUser == null) {
			// û�е�¼
			ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
			actionSupport.addActionError("���ȵ�¼��");
			return "loginFail";
		} else {
			return actionInvocation.invoke();
		}
	}
}
