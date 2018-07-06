package control;

import java.util.Random;

public class RandomUtil {
	public static final int len=32;
	static String generate() {
	 String str="";
	 for(int i=0;i< len;i++) {
		 Random rand=new Random();
		 int r=rand.nextInt()%36;
		 if(r<10) {
			 str+='0'+r;
		 }
		 else {
			 str+=(char)('a'+r-10);
		 }
		 
	 }
	 return str;
	}
	/* public static void main(String[] args){
		String str= RandomUtil.generate();
		 System.out.println(str);
	 }*/


}
