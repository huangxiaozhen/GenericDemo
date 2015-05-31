package me.huangzhen.generic;

//ΪʲôҪʹ�÷����Լ����͵Ļ���ʹ��

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import me.huangzhen.object.Order;

import org.junit.Test;

public class GenericDemo1
{
	
	//ʹ��ͨ��������� List���ǿ��Ա�����
	@Test
	public void test9()
	{
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("BB");
		
		List<?> list1  = list ;
		
		Iterator<?> iterator = list1.iterator();
		while(iterator.hasNext())
		{
			System.out.println(  iterator.next() ); //����Ϊ��Object����
		}
		//��������ʹ��ͨ���д��
		
		//list1.add("CC"); //��֪�� �� ����ʲô����
		
		//����Ͱ �� ��ʲô���Ͳ�֪��  Ψһ����д����null 
		list1.add(null); 
		
		
	}
	
	
	//8. ? extends A ���Դ�� A�Լ� A������
	// ? super B ���Դ�� B �Լ� B �ĸ���
	@Test
	public void test8()
	{
		List<? extends Number> list = null;
		List<Integer> list2 = null;
		List<Number> list3 = null;
		List<String> list4 =null;
		list = list2;
		list = list3;
		//list = list4;
	}
	
	//7 ͨ����ĸ���
	//list<?> ������list<> �ĸ���
	public void test7()
	{
		List<?> list = null;
		List<Object> list1 = new ArrayList<Object>();
		List<String> list2 = new ArrayList<String>();
		
		list = list1;
		list = list2;
		
		show(list1);
		show(list2);
		
	}
	
	public void show( List<?> list)
	{
		
	}
	
	
	
	//6.������̳еĹ�ϵ
	//����A �� ��B �����࣬��ô List<A> ���� List<B> ������
	@Test
	public void test6()
	{
		List<Object> list = new ArrayList<Object>();
		List<String> list2 = new ArrayList<String>();
		
		//list = list2;
		//��list2 ���Ը��� list
		//��ô list.add(Object) ���� list ָ��� ArrayLIst<String> ȴ���ܹ����obejct����
	} 
	
	
	//5.�Զ��巽���Ĳ���
	@Test
	public void tets5()
	{
		//���������Լ�������εļ��ϵ��÷��͵ķ���
		Integer[] integer = new Integer[]{1,2,3,4};
		List<Integer> list = new ArrayList<Integer>();
		Order order = new Order();
		list = order.arrayToList(integer, list);
		System.out.println(list);
		
		//String ���͵������Լ����String���͵ļ��ϵ��÷��͵ķ���
		String[] strings = new String[3];
		strings[0] = "AA";
		strings[1] = "BB";
		strings[2] = "CC";
		List<String> list2 = new ArrayList<String>();
		order.arrayToList(strings, list2);
		System.out.println(list2);
		
	}
	
	//4.�Զ��巺����Ĳ���
	@Test
	public void test4()
	{
		//Order������һ������Ϊboolean����
		//order�е�T�ͱ�����Ϊboolean���͡� 
		//��������Զ��˷��ͣ�����û��ʹ�ã�Ĭ����object���� 
		Order<Boolean> order = new Order<Boolean>();
		order.setT(true);
		
		System.out.println( order.getT() );
		
		order.add();
		System.out.println( order.list );
		
		int i = order.getE(123);
		double d = order.getE(2.45);
		System.out.println( i + " --" + d );
		
		
		
		
	}
	
	//3. ʹ�÷��Ͷ���Map�Ĳ���
	@Test
	public void test3()
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("AA", 123);
		map.put("BB", 456);
		map.put("CC", 111);
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for( Map.Entry<String, Integer> mapEntry : set )
		{
			System.out.println( mapEntry.getKey() + "-->" + mapEntry.getValue() );
		}
}
	
	
	
	
	//2. ʹ�÷��Ͷ���list�Ĳ���
	@Test
	public void test2()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(456);
		
		//ע�⣺��ʱlist��ֻ�ܹ����뷺�����Ƶ�����
		//list.add("AA");
		for(int i : list)
		{
			System.out.println(i);
		}
	}
	

	//1. ΪʲôҪʹ�÷���
	@Test
	public void test()
	{
		List list = new ArrayList();
		list.add(88);
		list.add(77);
		list.add(66);
		// û�м��뷺��ʱ�����ܻ���ֵ�����
		//1. ���벻���������ͣ�score ֻ����� int ������������ȫ���Լ��� String ����
		list.add(new String("AA"));

		for (int i = 0; i < list.size(); i++)
		{
			// ����������ǿ������ת���Ĵ���
			int score = (int) list.get(i);
			System.out.println(score);
		}

	}
}
