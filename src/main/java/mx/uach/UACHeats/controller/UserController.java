package mx.uach.UACHeats.controller;

import mx.uach.UACHeats.model.User;
import mx.uach.UACHeats.service.api.UserServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserServiceAPI userServiceAPI;
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("list", userServiceAPI.getAll());
        return "index";
    }
    @GetMapping("/save/{id}")
    public String showSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0){
            model.addAttribute("user", userServiceAPI.get(id));
        }
        return "save";
    }
    @PostMapping("/save")
    public String save(User user, Model model){
        userServiceAPI.save(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model){
        userServiceAPI.delete(id);
        return "redirect:/";
    }
}
