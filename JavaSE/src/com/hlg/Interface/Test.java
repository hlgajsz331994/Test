package com.hlg.Interface;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			IA a = new Student();			/*
											 * �������ʵ�������൱������ת�ͣ����ʲ���Student�����½����ֶ�C
											 * ʵ�ֵķ�����Student����д�ķ���
											 * ��ʹ Studentʵ����IA���ӽӿ�IA1��
											 * ����aҲ���ʲ���IA1�����Ժͷ���
											 */
		
//		System.out.println(a.a);            //�̳е�IA IB�ӿ��ж���a����
											//�ӿ��еĳ�������ֱ�ӵ��� Ĭ��Ϊpublic  static��final
//		IA.Ia();							//�ӿ��еķ������ǳ��󷽷�
											//������ͽӿڵ�����������Կ��Է��ʺ��޸ģ�����������зǳ��󷽷�
											//�ӿ�û�й��캯��
											//�ӿڷ�����ǰ׺Ĭ��Ϊ public abstract
											//������ʵ������   �����ڲ����ͣ�
		Ic d =null;
		Ic e =new Ic() {
			
			@Override
			public void ic() {
				// TODO Auto-generated method stub
				
			}
		}; 
//		a.a =3;                   //�ӿڵ����Զ����գ����ܸı�
		
		
		
		
		
	}

}
