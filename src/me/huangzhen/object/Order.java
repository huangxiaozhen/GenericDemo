package me.huangzhen.object;

import java.util.ArrayList;
import java.util.List;

//自定义泛型类

public class Order<T>
{
	private String orderName;
	private int orderId;
	
	private T t;
	public List<T> list  = new ArrayList<T>();
	
	
	// 在泛型类 Order 中定义一个泛型的方法
	public  <E> E getE(E e)
	{
		return e ;
	}
	
	//定义的泛型方法 将一个数组转换成list
	public <E>  List<E> arrayToList( E[] e , List<E> list )
	{
		for( E e1 : e )
		{
			list.add(e1);
		}
		
		return list;
	}
	
	public void add()
	{
		list.add(t);
	}
	
	
	public T getT()
	{
		return t;
	}

	public void setT(T t)
	{
		this.t = t;
	}
	
	@Override
	public String toString()
	{
		return "Order [orderName=" + orderName + ", orderId=" + orderId
				+ ", t=" + t + "]";
	}


	public String getOrderName()
	{
		return orderName;
	}

	public void setOrderName(String orderName)
	{
		this.orderName = orderName;
	}

	public int getOrderId()
	{
		return orderId;
	}

	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}

}


class SubOrder extends Order<Integer>{
	
}




