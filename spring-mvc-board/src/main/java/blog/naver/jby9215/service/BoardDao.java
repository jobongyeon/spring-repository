package blog.naver.jby9215.service;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	int insertBoard(Board board);
	int selectTotalBoardCount();
	List<Board> selectBoardListPerPage(Map<String, Integer> map);
	Board selectBoardByKey(int boardNo);
}
