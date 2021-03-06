package hvcntt.org.shoppingweb.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import hvcntt.org.shoppingweb.dto.CommentDto;
import hvcntt.org.shoppingweb.model.Comment;
import hvcntt.org.shoppingweb.model.Image;
import hvcntt.org.shoppingweb.model.Product;
import hvcntt.org.shoppingweb.model.User;
import hvcntt.org.shoppingweb.service.CommentService;
import hvcntt.org.shoppingweb.service.ImageService;
import hvcntt.org.shoppingweb.service.ProductService;
import hvcntt.org.shoppingweb.service.UserService;

@Controller
public class CommentController {
	@Autowired
	CommentService commentService;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	@Autowired
	ImageService imageservice;
//	@RequestMapping(value="/comments")
//	public String comment(Model model){
//		model.addAttribute("comments",commentService.getAll() );
//		return "detailpage";
//	}
	@RequestMapping(value="/comment/{idproduct}",produces={"application/x-www-form-urlencoded; charset=UTF-8"})
	public String createComment(Model model, @PathVariable("idproduct")String idproduct,
			@ModelAttribute CommentDto cm, Principal principal, HttpServletRequest request){
		Product product= productService.findOne(idproduct);
		String username=principal.getName();
		User user=userService.findByUsername(username);
		Comment comment= new Comment();
		comment.setUser(user);
		comment.setProduct(product);
		comment.setTitle(cm.getTitle());
		comment.setContent(cm.getContent());
		comment.setCreatedate(new Date());
		comment.setLastupdate(new Date());
		commentService.create(comment);
		List<Image> imgs= imageservice.findByProduct(product);
		model.addAttribute("image", imgs);
		model.addAttribute("singleProduct", product);
		return "redirect:/detail?idproduct=".concat(String.valueOf(idproduct));
	}
}
