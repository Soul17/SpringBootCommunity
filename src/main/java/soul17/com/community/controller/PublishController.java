package soul17.com.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import soul17.com.community.mapper.QuestionMapper;
import soul17.com.community.mapper.UserMapper;
import soul17.com.community.model.Question;
import soul17.com.community.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(@RequestParam(value = "title", required = false) String title,
                            @RequestParam(value = "description", required = false) String description,
                            @RequestParam(value = "tag", required = false) String tag,
                            HttpServletRequest request,
                            Model model) {

        if ((title == null) || (title == "")) {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }

        if ((description == null) || (description == "")) {
            model.addAttribute("error", "描述信息不能为空");
            return "publish";
        }

        if ((tag == null) || (tag == "")) {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }

        User user = null;
        Cookie cookies[] = request.getCookies();
        Question question = new Question();

        System.out.println("test1");

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                user = userMapper.findByToken(token);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }

        System.out.println("test2");
        if (user == null) {
            System.out.println("test3");
            model.addAttribute("error", "用户未登录");
            return "publish";
        }

        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.create(question);

        return "redirect:/";
    }
}
