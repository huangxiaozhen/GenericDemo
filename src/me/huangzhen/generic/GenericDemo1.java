package me.huangzhen.generic;

//ΪʲôҪʹ�÷����Լ����͵Ļ���ʹ��

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import me.huangzhen.object.Order;

import org.junit.Test;

public class GenericDemo1
{
	
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
		
		
	}
	
	//ʹ�÷��Ͷ���Map�Ĳ���
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
	
	
	
	
	//ʹ�÷��Ͷ���list�Ĳ���
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
