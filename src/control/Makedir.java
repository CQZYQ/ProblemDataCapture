
package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Makedir {
/*	public boolean makedir(String str) {
		String strDirectory="E:\\SaveCase\\";
		String filePath=strDirectory+str;
	File file=new File(filePath);
	if(file.exists())
		return false;
	file.mkdirs();
	return true;
	}*/
	public boolean makedir(String str, String incontent, String outcontent) throws IOException {
		String strDirectory = "E:\\SaveCase\\";
		String filePath = strDirectory + str;
		File file = new File(filePath);
		if (file.exists()) {
			return false;
		} else {
			file.mkdirs();
			String newfilepathin = filePath + "\\in.txt";
			String newfilepathout = filePath + "\\out.txt";
			File filein = new File(newfilepathin);
			File fileout = new File(newfilepathout);
			filein.createNewFile();
			fileout.createNewFile();
			FileWriter fwin = new FileWriter(newfilepathin, true);
			fwin.write(incontent);
			fwin.close();
			FileWriter fwout = new FileWriter(newfilepathout, true);
			fwout.write(outcontent);
			fwout.close();
			return true;
		}
	}

}
