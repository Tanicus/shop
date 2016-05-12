package shop.cart.vo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ���ﳵ����
 * 
 * @author Programmer
 *
 */
public class Cart {
	// ������ϣ�Map��key����ƷID��value�ǹ�����
	Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	public Collection<CartItem> getCartItems() {
		return map.values();
	}
	// �����ܼƣ�
	private double total;

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	// ���ﳵ�Ĺ��ܣ�
	// 1.����������ӵ����ﳵ
	public void addCart(CartItem cartItem) {
		Integer pid = cartItem.getProduct().getPid();
		if (map.containsKey(pid)) {
			CartItem _cartItem = map.get(pid);
			_cartItem.setCount(_cartItem.getCount() + cartItem.getCount());
		} else {
			map.put(pid, cartItem);
		}
		total += cartItem.getSubtotal();
	}

	// 2.�ӹ��ﳵ�Ƴ�������
	public void removeCart(Integer pid) {
		// ���������Ƴ����ﳵ
		CartItem cartItem = map.remove(pid);
		// �ܼ� = �ܼ�-�Ƴ��Ĺ�����С��
		total -= cartItem.getSubtotal();
	}

	// 3.��չ��ﳵ
	public void clearCart() {
		// �����й��������
		map.clear();
		// ���ϼ�����Ϊ0
		total = 0;
	}
}
