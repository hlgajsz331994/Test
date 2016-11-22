package com.hlg.Io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;
/*
 * RandomAccessFile :��������ļ�
 * 1.�ȿ��Ե�һ����������Ҳ���Ե�һ�������
 * 2.֧�ִ��ļ��Ŀ�ͷ��ȡ��д��
 * 3.֧�ִ�����λ�õĶ�ȡ��д�루���룩
 * Mode��
		"r" ��ֻ����ʽ�򿪡����ý��������κ� write �������������׳� IOException��  
		"rw" ���Ա��ȡ��д�롣������ļ��в����ڣ����Դ������ļ���  
		"rws" ���Ա��ȡ��д�룬���� "rw"����Ҫ����ļ������ݻ�Ԫ���ݵ�ÿ�����¶�ͬ��д�뵽�ײ�洢�豸��  
		"rwd"   ���Ա��ȡ��д�룬���� "rw"����Ҫ����ļ����ݵ�ÿ�����¶�ͬ��д�뵽�ײ�洢�豸�� 

 */
public class TestRandomAccessFile {
	//ʵ�ֲ����Ч���� ��readLIne����                            ������������ˣ�������                    
	@Test
	public void test2() {
		RandomAccessFile stream1 = null;
		try {
			stream1 = new RandomAccessFile("random1", "rw");
			stream1.seek(4);
			int len;
			StringBuffer sb = null;
			byte a[] = new byte[10];
			while((len = stream1.read(a)) != -1){
				sb = new StringBuffer(new String(a,0,len));
				System.out.print(sb.toString());
			}
			stream1.seek(4);
			stream1.write("xy".getBytes());
			stream1.write(sb.toString().getBytes());
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stream1!=null){
				try {
					stream1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	@Test
	public void test1() throws IOException{
		RandomAccessFile stream1 = new RandomAccessFile("random1", "rw");
		RandomAccessFile stream2 = new RandomAccessFile("random2", "rw");
		stream1.seek(2);                   //����λ�ÿ�ʼ��
		byte a[] = new byte[5];
		int len;
		while((len = stream1.read(a))!=-1){
			stream2.write(a,0,len);
		}
		
	}
	@Test
	public void test() throws IOException{
		RandomAccessFile stream1 = new RandomAccessFile("random1", "rw");
		RandomAccessFile stream2 = new RandomAccessFile("random1", "rw");
		byte a[] = "һ��λ��".getBytes();
		stream1.seek(1);            //��0��ʼ���嵽��һ�ſ�ʼд��   1234567890
		stream1.write(a);			//����� 1һ��λ��0     ʵ�ֵ��Ǹ���Ч��
		
		
		
		
	
		
		
	}
}
