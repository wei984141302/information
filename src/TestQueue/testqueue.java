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
	 * 随机指定范围内N个不重复的数 在初始化的无重复待选数组中随机产生一个数放入结果中，
	 * 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换 然后从len-2里随机产生下一个随机数，如此类推
	 * 
	 * @param max
	 *            指定范围最大值
	 * @param min
	 *            指定范围最小值
	 * @param n
	 *            随机数个数
	 * @return int[] 随机数结果集
	 */
	public static int[] randomArray(int min, int max, int n) {
		int len = max - min + 1;//长度

		if (max < min || n > len) {
			return null;
		}//判断min max n是否满足

		// 初始化给定范围的待选数组
		int[] source = new int[len];
		for (int i = min; i < min + len; i++) {
			source[i - min] = i;//数列赋初值
			//System.out.println(i-min);
		}

		int[] result = new int[n];//声明结果数组
		Random rd = new Random();//产生一个随机数
		System.out.println("输出随机数"+rd.nextInt());//输出这个随机数
		int index = 0;//定义变量赋值为零
		System.out.println("输出数组长度:"+result.length);//输出结果数组的长度
		for (int i = 0; i < result.length; i++) {
			// 待选数组0到(len-2)随机一个下标
			index = Math.abs(rd.nextInt() % len--);
			// 将随机到的数放入结果集
			result[i] = source[index];
			// 将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
			source[index] = source[len];
		}
		return result;//返回结果数组
	}
}