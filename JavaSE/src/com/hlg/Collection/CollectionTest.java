package com.hlg.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/*
 *   Collection�ӿڣ�
 *   	 |----List�ӿڣ�Ԫ�����򣬿��ظ�
 *   		 |----ArrayList(��Ҫ��ʵ����)(����ʵ��)
 *   		 |----LinkedList������Ƶ���Ĳ��롢ɾ�������� (����ʵ��)
 *   	 |----Set�ӿڣ�Ԫ�����򣨴洢��λ��������ģ��������ظ�            ������hashֵ���棩
 *   		 |----HashSet(��Ҫ��ʵ����)
 *   		 |----LinkedSet��������������죩��  ʹ������ά����һ��������ӽ����ϵ�˳�򣬵��±�������ʱ��
 *   		 				   ˳���ǰ�����ӽ�ȥ��˳�����
 *   		 |----TreeSet������TreeSet����ӵ�Ԫ�ر�����ͬһ���ࡣ
 *   					        �ڿ��԰�����ӽ������е�Ԫ�ص�ָ����˳���������String.��װ���Ĭ�ϰ��մ�С��
 *   						  ���˳�����
 *   					       �������ʵ��comparable�ӿڣ����ƶ�����Ĺ���
 *   					       ����TreeSet�����Ԫ��ʱ�����Ȱ���conpareTo()���бȽϣ�һ������0����Ȼ�������������
 *   						��������ͬ�����ǳ������Ϊ��������������ͬ�ģ�������һ����������ӽ�����
 *   					      ��֮���ٽ���hashcode������������ñ�֤compareto������hashcode������equals����������һ�¡�
 *   
 *   ˵����Ҫ����ӽ�Set�е�Ԫ�����ڵ��࣬Ҫ��дequals����������hashcode��������������֤�����ظ���
 *   
 *   Set�е�Ԫ�صĴ洢���̣� ��ϣ�㷨
 *   		����Set����Ӷ���ʱ�����ȵ��ô˶����Ӧ�����е�hashCode��������������˶����
 *   	 ��ϣֵ.�����ϣֵ�����˴ζ�����Set�еĴ洢λ��.����λ��û�ж���洢,���������
 *   	ֱ�Ӵ洢����λ��.����λ�����ж���洢����ͨ��equals()�����Ƚ������������Ƿ���ͬ��
 *   
 */
public class CollectionTest {
	@Test
	public void TreeSetTest() {
		Set set = new TreeSet();
		Person p1 = new Person("ͼͼ", 23);
		Person p2 = new Person("����", 21);
		set.add(p1);
		set.add(p2);
		Iterator ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
	}

	@Test
	public void HashSetTest() {
		Set set = new HashSet();
		Person p1 = new Person("ͼͼ", 23);
		Person p2 = new Person("����", 21);
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		set.add(p1);
		set.add(p2);
		System.out.println(set.size());
	}

	@Test
	public void test1() {

		// Collection col = new ArrayList();
		// boolean a = col.add("a");
		// System.out.println(a);
		/*
		 * contains()���� �жϸ��ݶ�������Ӧ�����е�equals()���������ж� ��������Զ����Ԫ�ض���
		 * ��Ҫ��д��Ӧ���е�equals()������
		 */
		Collection col1 = new ArrayList();
		col1.add(new Person("ͼͼ", 23));
		col1.add(new Person("����", 21));
		boolean a = col1.contains(new Person("ͼͼ", 23));
		System.out.println(a);
		// collection����д�� equals �������ж����������Ƿ���ͬ

		// ����

		// �٣�iterator()������ ����һ��Iterator�ӿڵ�ʵ����Ķ���ʵ�ּ��ϵı���
		// .next():�ƶ�ָ�� .hasNext()�����ƶ�ָ��
		Iterator ite = col1.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		// �ڣ�forѭ������
		for (Object b : col1) {
			System.out.println(b);
		}
	}
}
