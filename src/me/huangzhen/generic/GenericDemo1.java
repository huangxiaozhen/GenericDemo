package me.huangzhen.generic;

//为什么要使用泛型以及泛型的基本使用

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
		
		
	}
	
	//使用泛型对于Map的测试
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
	
	
	
	
	//使用泛型对于list的测试
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
