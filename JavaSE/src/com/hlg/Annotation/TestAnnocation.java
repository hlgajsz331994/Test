package com.hlg.Annotation;
/*
 *     @override   ������д
 *     @Deprecated 		���������ѹ�ʱ
 *     @SuppressWarnings		���Ʊ���������
 *     
 */
public class TestAnnocation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		int a ;
	}

}
//�Զ���ע��
@interface my{
	String [] value();
}

