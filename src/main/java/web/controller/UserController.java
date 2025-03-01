package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.hiber.dao.UserDao;
import web.hiber.model.User;
import web.hiber.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    UserService userSv;
    @Autowired
    public UserController(UserService userSv){
        this.userSv = userSv;
    }

    @GetMapping("")
    public String listUsers(ModelMap model){
//        List<User> users = new ArrayList<>();
//        users.add(new User("Ayub", "Rajabzoda"));
        model.addAttribute("listOfUsers", userSv.listUsers());
        return "showAllUsers";

    }

    @GetMapping("deleteUser")
    public String deleteUser(@RequestParam("id") int id){
        userSv.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("new")
    public String addUser(ModelMap model){
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("add")
    public String create(@ModelAttribute("user") User user){
        userSv.addUser(user);
        return "redirect:/";
    }

    @GetMapping("update")
    public String updateUser(ModelMap model, @RequestParam("id") int id){
        model.addAttribute("user", userSv.getUserById(id));
        return "updateUser";
    }

    @PostMapping("updateChanges")
    public String update(@ModelAttribute("user") User user){
        if(user==null){
            throw new RuntimeException("The object from the model is NULL!!!");
        }
        userSv.updateUser(user);
        return "redirect:/";
    }

}
