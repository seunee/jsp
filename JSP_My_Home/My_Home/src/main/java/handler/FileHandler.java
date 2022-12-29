package handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandler {
	private static final Logger log=LoggerFactory.getLogger(FileHandler.class);
	
	public int deleteFile(String imageFileName, String savePath) {
		boolean isDel=true;
		
		File fileDir=new File(savePath);
		File removeFile=new File(fileDir+File.separator+imageFileName);
		File removeThumb=new File(fileDir+File.separator+"th_"+imageFileName);
		
		if(removeFile.exists() || removeThumb.exists()) {
			isDel=removeFile.delete();
			if(isDel) {
				isDel=removeThumb.delete();
			}
		}
		return isDel?1:0;
	}
}
