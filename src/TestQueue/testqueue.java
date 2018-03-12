package TestQueue;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class testqueue {
	public static void main(String[] args) {
		
		int [] temp = randomArray(10,100,15);
		for(int i=0;i<15;i++)
		{
			System.out.println("+++"+temp[i]);
		}
	}
	/**
	 * ���ָ����Χ��N�����ظ����� �ڳ�ʼ�������ظ���ѡ�������������һ�����������У�
	 * ����ѡ���鱻������������ô�ѡ����(len-1)�±��Ӧ�����滻 Ȼ���len-2�����������һ����������������
	 * 
	 * @param max
	 *            ָ����Χ���ֵ
	 * @param min
	 *            ָ����Χ��Сֵ
	 * @param n
	 *            ���������
	 * @return int[] ����������
	 */
	public static int[] randomArray(int min, int max, int n) {
		int len = max - min + 1;//����

		if (max < min || n > len) {
			return null;
		}//�ж�min max n�Ƿ�����

		// ��ʼ��������Χ�Ĵ�ѡ����
		int[] source = new int[len];
		for (int i = min; i < min + len; i++) {
			source[i - min] = i;//���и���ֵ
			//System.out.println(i-min);
		}

		int[] result = new int[n];//�����������
		Random rd = new Random();//����һ�������
		System.out.println("��������"+rd.nextInt());//�����������
		int index = 0;//���������ֵΪ��
		System.out.println("������鳤��:"+result.length);//����������ĳ���
		for (int i = 0; i < result.length; i++) {
			// ��ѡ����0��(len-2)���һ���±�
			index = Math.abs(rd.nextInt() % len--);
			// �������������������
			result[i] = source[index];
			// ����ѡ�����б�������������ô�ѡ����(len-1)�±��Ӧ�����滻
			source[index] = source[len];
		}
		return result;//���ؽ������
	}
}