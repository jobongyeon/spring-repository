package blog.naver.jby9215.fileboard.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileBoardService {
	private static final Logger logger = LoggerFactory.getLogger(FileBoardService.class);

	public int addFileBoard(FileBoardCommand fileBoardCommand) {
		//1 디렉토리에 저장
		String path = "";
		String fileName = "";
		File destFile = null;
		String extention = "";
		try {
			path = "D:\\jobongyeon\\workspace-sts-JBY\\spring-pds\\src\\main\\resources\\upload\\";
			MultipartFile multipartFile = fileBoardCommand.getMultipartfile();
			UUID uuid = UUID.randomUUID();
			fileName = uuid.toString().replace("-", "");
			//getOriginalFilename 업로드한 파일의 실제 이름을 구함
			//
			int index = multipartFile.getOriginalFilename().lastIndexOf(".");
			extention = multipartFile.getOriginalFilename().substring(index+1);
			fileName = fileName+"."+extention;
			destFile = new File(path+fileName);
			//transferTo 업로드한 파일 데이터를 지정한 파일에 저장
			multipartFile.transferTo(destFile);
			//2 FileBoardCommand >> FileBoard >> Dao
			FileBoard fileBoard = new FileBoard();
			fileBoard.setTitle(fileBoardCommand.getTitle());
			fileBoard.setAuth(fileBoardCommand.getAuth());
			fileBoard.setFilePath(path);
			fileBoard.setFileName(fileName);
			fileBoard.setExtention(extention);
			logger.info("{}", fileBoard.toString());
		} catch (IllegalStateException e) {
			destFile.delete();
			e.printStackTrace();
		} catch (IOException e) {
			destFile.delete();
			e.printStackTrace();
		}
		return 0;
	}
}
