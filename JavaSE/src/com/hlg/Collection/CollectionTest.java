package com.hlg.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/*
 *   Collection接口：
 *   	 |----List接口：元素有序，可重复
 *   		 |----ArrayList(主要的实现类)(数组实现)
 *   		 |----LinkedList（用于频繁的插入、删除操作） (链表实现)
 *   	 |----Set接口：元素无序（存储的位置是无序的），不可重复            （根据hash值来存）
 *   		 |----HashSet(主要的实现类)
 *   		 |----LinkedSet（添加慢，遍历快）：  使用链表维护了一个对象添加进集合的顺序，导致遍历集合时的
 *   		 				   顺序，是按照添加进去的顺序遍历
 *   		 |----TreeSet：①向TreeSet中添加的元素必须是同一个类。
 *   					        ②可以按照添加进集合中的元素的指定的顺序遍历。向String.包装类等默认按照从小到
 *   						  大的顺序遍历
 *   					       ③类必须实现comparable接口，来制定排序的规则
 *   					       ④向TreeSet中添加元素时，首先按照conpareTo()进行比较，一旦返回0，虽然仅是两个对象的
 *   						此属性相同，但是程序会认为这两个对象是相同的，进而后一个对象不能添加进来。
 *   					      ⑤之后再进行hashcode（）方法，最好保证compareto（）、hashcode（）、equals（），三者一致。
 *   
 *   说明：要求添加进Set中的元素所在的类，要重写equals（）方法和hashcode方法（），来保证不可重复性
 *   
 *   Set中的元素的存储过程？ 哈希算法
 *   		当向Set中添加对象时，首先调用此对象对应的类中的hashCode（）方法，计算此对象的
 *   	 哈希值.这个哈希值决定了次对象在Set中的存储位置.若此位置没有对象存储,则这个对象
 *   	直接存储到此位置.若此位置已有对象存储，在通过equals()方法比较这两个对象是否相同。
 *   
 */
public class CollectionTest {
	@Test
	public void TreeSetTest() {
		Set set = new TreeSet();
		Person p1 = new Person("图图", 23);
		Person p2 = new Person("兔兔", 21);
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
		Person p1 = new Person("图图", 23);
		Person p2 = new Person("兔兔", 21);
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
		 * contains()方法 判断根据对象所对应类型中的equals()方法进行判断 如果存入自定义的元素对象，
		 * 需要重写对应类中的equals()方法。
		 */
		Collection col1 = new ArrayList();
		col1.add(new Person("图图", 23));
		col1.add(new Person("兔兔", 21));
		boolean a = col1.contains(new Person("图图", 23));
		System.out.println(a);
		// collection中重写了 equals 方法来判断两个集合是否相同

		// 遍历

		// ①：iterator()迭代器 返回一个Iterator接口的实现类的对象，实现集合的遍历
		// .next():移动指针 .hasNext()：不移动指针
		Iterator ite = col1.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		// ②：for循环遍历
		for (Object b : col1) {
			System.out.println(b);
		}
	}
}
