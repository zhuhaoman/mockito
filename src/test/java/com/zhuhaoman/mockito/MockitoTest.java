package com.zhuhaoman.mockito;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author zhuhaoman
 * @description: mockito test demo
 * @date 2019-03-24 23:18
 **/
public class MockitoTest {
    /**
     * 1.验证某些行为
     */
    @Test
    public void testMock() {
        //创建mock对象
        List list = mock(List.class);

        //使用mock对象
        list.add("one");
        list.clear();

        //验证
        verify(list).add("one");
        verify(list).clear();
        //一旦mock 对象被创建，mock对象会记住所有的交互，可通过verity进行验证
        verify(list).add("two");
    }

    /**
     * 2.如何做一些测试桩
     */
    @Test
    public void testStub() {
        LinkedList mockList = mock(LinkedList.class);

        //测试桩
        when(mockList.get(0)).thenReturn("first");
        when(mockList.get(1)).thenReturn(new RuntimeException());

        //输出"first"
        System.out.println(mockList.get(0));
        //输出RuntimeException
        System.out.println(mockList.get(1));

        //默认情况下，所有的函数都有返回值，mock函数默认返回是null

        //因为get(999)没打桩，故输出null
        System.out.println(mockList.get(999));
        //验证get(1)被调用的次数
        verify(mockList).get(1);
//        verify(mockList).get(14);
    }
}
