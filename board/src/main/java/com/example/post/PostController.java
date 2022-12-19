package com.example.post;

import com.example.user.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/addpost")
    public String viewAddPostPage(Model model) {
        model.addAttribute("postname", "新增");
        model.addAttribute("post", new PostModel());
        return "addpost";
    }

    @PostMapping("/addpost")
    public String addpostProcess(PostModel post) {
        postService.addPost(post);
        return "redirect:/";
    }
}
