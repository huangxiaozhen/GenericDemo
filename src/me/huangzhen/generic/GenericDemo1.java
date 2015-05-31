package me.huangzhen.generic;

//为什么要使用泛型以及泛型的基本使用

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
	
	//使用通配符声明的 List，是可以遍历的
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
			System.out.println(  iterator.next() ); //都认为是Object类型
		}
		//不可以向使用通配符写入
		
		//list1.add("CC"); //不知道 ？ 代表什么类型
		
		//垃圾桶 ？ 是什么类型不知道  唯一可以写入是null 
		list1.add(null); 
		
		
	}
	
	
	//8. ? extends A 可以存放 A以及 A的子类
	// ? super B 可以存放 B 以及 B 的父类
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
	
	//7 通配符的概念
	//list<?> 是所有list<> 的父类
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
	
	
	
	//6.泛型与继承的关系
	//若类A 是 类B 的子类，那么 List<A> 不是 List<B> 的子类
	@Test
	public void test6()
	{
		List<Object> list = new ArrayList<Object>();
		List<String> list2 = new ArrayList<String>();
		
		//list = list2;
		//若list2 可以付给 list
		//那么 list.add(Object) 但是 list 指向的 ArrayLIst<String> 却不能够添加obejct类型
	} 
	
	
	//5.自定义方法的测试
	@Test
	public void tets5()
	{
		//整形数组以及存放整形的集合调用泛型的方法
		Integer[] integer = new Integer[]{1,2,3,4};
		List<Integer> list = new ArrayList<Integer>();
		Order order = new Order();
		list = order.arrayToList(integer, list);
		System.out.println(list);
		
		//String 类型的数组以及存放String类型的集合调用泛型的方法
		String[] strings = new String[3];
		strings[0] = "AA";
		strings[1] = "BB";
		strings[2] = "CC";
		List<String> list2 = new ArrayList<String>();
		order.arrayToList(strings, list2);
		System.out.println(list2);
		
	}
	
	//4.自定义泛型类的测试
	@Test
	public void test4()
	{
		//Order中声明一个泛型为boolean类型
		//order中的T就被声明为boolean类型。 
		//如果我们自定了泛型，但是没有使用，默认了object类型 
		Order<Boolean> order = new Order<Boolean>();
		order.setT(true);
		
		System.out.println( order.getT() );
		
		order.add();
		System.out.println( order.list );
		
		int i = order.getE(123);
		double d = order.getE(2.45);
		System.out.println( i + " --" + d );
		
		
		
		
	}
	
	//3. 使用泛型对于Map的测试
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
	
	
	
	
	//2. 使用泛型对于list的测试
	@Test
	public void test2()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(456);
		
		//注意：此时list中只能够加入泛型限制的类型
		//list.add("AA");
		for(int i : list)
		{
			System.out.println(i);
		}
	}
	

	//1. 为什么要使用泛型
	@Test
	public void test()
	{
		List list = new ArrayList();
		list.add(88);
		list.add(77);
		list.add(66);
		// 没有加入泛型时，可能会出现的问题
		//1. 加入不想加入的类型，score 只想加入 int ，但是这里面全可以加入 String 类型
		list.add(new String("AA"));

		for (int i = 0; i < list.size(); i++)
		{
			// 这里面会出现强制类型转换的错误
			int score = (int) list.get(i);
			System.out.println(score);
		}

	}
}
