package com.lianxun.util;

import java.text.SimpleDateFormat;
import java.util.Random;

public class RandomNumber {
	
	public static RandomNumber instance=null;
	
	private RandomNumber() {
		
	}
	public synchronized static RandomNumber getInstance(){
		if (instance==null){
			instance=new RandomNumber();
		}
		return instance;
	}
	public synchronized int getRandomNumber(){
		int[] array = {1,1,2,3,4,5,6,7,8,9};
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
		    int index = rand.nextInt(i);
		    int tmp = array[index];
		    array[index] = array[i - 1];
		    array[i - 1] = tmp;
		}
		int result = 0;
		for(int i = 0; i < 6; i++)
		    result = result * 10 + array[i];
		return result;
	}
	public static void main(String[] args) {
	    long now=System.currentTimeMillis();
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        for (int i=0;i<10000;i++){
            int s2=RandomNumber.getInstance().getRandomNumber();
            System.out.println(s2);
        }
        long end=System.currentTimeMillis();
        
    }
}
