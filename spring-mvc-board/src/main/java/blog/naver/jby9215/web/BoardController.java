package blog.naver.jby9215.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import blog.naver.jby9215.service.Board;
import blog.naver.jby9215.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	//Controller 객체에서 Model은 Map
	@RequestMapping(value="/board/boardList")
	public String boardList(Model model,
		@RequestParam(value="currentPage", defaultValue="1") int currentPage) {
		System.out.println(this.getClass()+" test boardList 실행");
		
		Map<String, Object> returnMap = boardService.getBoardListPerCurrentPage(currentPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalRowCount", returnMap.get("totalRowCount"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("list", returnMap.get("list"));
		return "/board/boardList";
	}
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.POST)
	public String boardAdd(Board board) {
		System.out.println(this.getClass()+" test boardAdd Post 실행");
		System.out.println("test 한글 인코딩 : "+board);
		boardService.AddBoard(board);
		return "redirect:/board/boardList";
	}
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.GET)
	public String boardAdd() {
		System.out.println(this.getClass()+" test boardAdd Get 실행");
		return "/board/boardAdd"; //forward
	}
	@RequestMapping(value="/board/boardView")
	public String boardView(Model model, @RequestParam(value="boardNo")int boardNo) {
		System.out.println(this.getClass()+" test boardView 실행");
		model.addAttribute("board", boardService.boardView(boardNo));
		return "/board/boardView";
	}
	@RequestMapping(value="/board/boardRemove", method=RequestMethod.GET)
	public String boardRemove(Model model, @RequestParam(value="boardNo")int boardNo){
		System.out.println(this.getClass()+" test boardRemove Get 실행");
		model.addAttribute("boardNo", boardNo);
		return "/board/boardRemove";
	}
	@RequestMapping(value="/board/boardRemove", method=RequestMethod.POST)
	public String boardRemove(Model model, Board board){
		System.out.println(this.getClass()+" test boardRemove Post 실행");
		if(boardService.boardRemove(board) != 1) {
			model.addAttribute("boardNo", board.getBoardNo());
			return "/board/boardRemove";
		}
		return "redirect:/board/boardList";
	}
	@RequestMapping(value="/board/boardModify", method=RequestMethod.GET)
	public String boardUpdate(Model model, @RequestParam(value="boardNo")int boardNo){
		System.out.println(this.getClass()+" test boardUpdate GET 실행");
		Board board = boardService.boardView(boardNo);
		model.addAttribute("board", board);
		return "/board/boardModify";
	}
	@RequestMapping(value="/board/boardModify", method=RequestMethod.POST)
	public String boardUpdate(Model model, Board board) {
		System.out.println(this.getClass()+" test boardUpdate POST 실행");
		if(boardService.boardUpdate(board) != 1) {
			model.addAttribute("board", board);
				return "/board/boardModify";
		}
		return "redirect:/board/boardList";
	}
}
