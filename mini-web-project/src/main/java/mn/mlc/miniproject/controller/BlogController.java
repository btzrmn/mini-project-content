package mn.mlc.miniproject.controller;

import mn.mlc.miniproject.entity.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    public Blog item = new Blog();

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("blog", item);
        return "home";
    }

    @GetMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("blog") Blog blog) {
        item.setTitle(blog.getTitle());
        item.setAuthor(blog.getAuthor());
        item.setContent(blog.getContent());
        return "redirect:/";
    }
}
