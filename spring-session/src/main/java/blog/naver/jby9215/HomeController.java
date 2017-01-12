package blog.naver.jby9215;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes(value="loginMember")//model타입의 SessionAttribute
public class HomeController {
	
	/*private static final Logger logger = LoggerFactory.getLogger(HomeController.class);*/
	//logger : log4j 객체
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {//model에 저장하면 view에서 읽어낼수 있다. locale : 웹서버 시간 지역 읽어낼수 있음 서버의 로컬정보
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();//Date : 날짜만드는 클래스 캘린더도 date참조함. 글자 뿌릴때 포멧팅해야함 외부 라이브러리가 쓰기편함.
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/
	public String signin(Model model) {
		model.addAttribute("loginMember","로그인정보");
		return "redirect:/";
	}
	public String signout(SessionStatus status) {
		status.isComplete();
		return "redirect:/";
	}
	
	public String login(HttpSession session, Member member){
		// id,pw >> service >> Dao >> is >> save the session
		boolean result = false;
		if(!result) {
			return "login";
		} else {
			//Member was saved the session!
			session.setAttribute("loginMember", member);
		}
		return "redirect:/";
	}
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
class Member {}
}
