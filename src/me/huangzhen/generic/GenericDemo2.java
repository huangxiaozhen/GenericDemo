package me.huangzhen.generic;

import java.lang.reflect.Array;

public class GenericDemo2<E>
{
	private E[] a;

	public GenericDemo2(Class<E> c, int s)
	{
		@SuppressWarnings("unchecked")
		final E[] a = (E[]) Array.newInstance(c, s);
		this.a = a;
	}

	E get(int i)
	{
		return a[i];
	}

}
