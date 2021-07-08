package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import technicalblog.model.Category;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.service.PostService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    // this will return all the posts of the logged in user
    @RequestMapping("/posts")
    public String getUserPosts(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

    // this is to go to posts/create page to create the post
    @RequestMapping("/posts/newpost")
    public String newPost() {
        return "posts/create";
    }

    // this is to create a new post when the user is logged in
    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost, HttpSession session) {
        User user = (User) session.getAttribute("loggeduser");
        newPost.setUser(user);

        if(newPost.getSpringBlog() != null) {
            Category springBlogCategory = new Category();
            springBlogCategory.setCategory(newPost.getSpringBlog());
            newPost.getCategories().add(springBlogCategory);
        }

        if(newPost.getJavaBlog() != null) {
            Category javaBlogCategory = new Category();
            javaBlogCategory.setCategory(newPost.getJavaBlog());
            newPost.getCategories().add(javaBlogCategory);
        }

        postService.createPost(newPost);

        return "redirect:/posts";
    }

    // this is to edit the post
    @RequestMapping("/editPost")
    public String editPost(@RequestParam(name="postId") Integer postId, Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);

        return "posts/edit";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.PUT)
    public String editPostSubmit(@RequestParam(name="postId") Integer postId, Post updatedPost, HttpSession session) {
        User user = (User) session.getAttribute("loggeduser");
        updatedPost.setUser(user);
        updatedPost.setId(postId);

        if(updatedPost.getSpringBlog() != null) {
            Category springBlogCategory = new Category();
            springBlogCategory.setCategory(updatedPost.getSpringBlog());
            updatedPost.getCategories().add(springBlogCategory);
        }

        if(updatedPost.getJavaBlog() != null) {
            Category javaBlogCategory = new Category();
            javaBlogCategory.setCategory(updatedPost.getJavaBlog());
            updatedPost.getCategories().add(javaBlogCategory);
        }

        postService.updatePost(updatedPost);

        return "redirect:/posts";
    }

    @RequestMapping(value = "/deletePost", method = RequestMethod.DELETE)
    public String deletePostSubmit(@RequestParam(name="postId") Integer postId) {
        postService.deletePost(postId);

        return "redirect:/posts";
    }
}
