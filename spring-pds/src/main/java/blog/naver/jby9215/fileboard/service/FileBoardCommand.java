package blog.naver.jby9215.fileboard.service;

import org.springframework.web.multipart.MultipartFile;

public class FileBoardCommand {
	private String title;
	private String Auth;
	private MultipartFile multipartfile;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuth() {
		return Auth;
	}
	public void setAuth(String auth) {
		Auth = auth;
	}
	public MultipartFile getMultipartfile() {
		return multipartfile;
	}
	public void setMultipartfile(MultipartFile multipartfile) {
		this.multipartfile = multipartfile;
	}
	@Override
	public String toString() {
		return "FileBoardCommand [title=" + title + ", Auth=" + Auth + ", multipartfile=" + multipartfile + "]";
	}
	
}
