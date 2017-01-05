package blog.naver.jby9215.service;

import java.util.Map;

public interface BoardService {
	public int AddBoard(Board board);
	Map<String, Object> getBoardListPerCurrentPage(int currentPage);
	Board boardView(int boardNo);
}
