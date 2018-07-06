package control;

import java.io.File;

public class Makedir {
	public boolean makedir(String str) {
		String strDirectory="E:\\SaveCase\\";
		String filePath=strDirectory+str;
	File file=new File(filePath);
	if(file.exists())
		return false;
	file.mkdirs();
	return true;
	}
}
