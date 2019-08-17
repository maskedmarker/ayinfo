package org.cjh.ayinfo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @GetMapping("/greeting.do")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @GetMapping("/json.do")
    @ResponseBody
    public Map<String, Object> json(@RequestParam Map<String, Object> requestParam) {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("response", new Date().toString());
        return resp;
    }
}
