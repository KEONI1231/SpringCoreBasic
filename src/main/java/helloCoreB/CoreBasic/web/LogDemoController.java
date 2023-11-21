package helloCoreB.CoreBasic.web;
import helloCoreB.CoreBasic.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor //스프링 컨테이너가 뜰때, 아래 컨트롤러를 스프링 빈에 등록, 그때 의존관계 주입이 일어남.
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {

        String requestUrl = request.getRequestURL().toString();
        System.out.println("mylogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestUrl);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
