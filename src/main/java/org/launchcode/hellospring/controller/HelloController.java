package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("hello")
public class HelloController {
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello,Spring!";
//    }

    // lives /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye,Spring!";
    }

    //lives /hello/hello
    //Handle request of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "hello")
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

    //lives /hello/name
    //Handle request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name,Model model) {
        String thegreeting="Hello, "+name+"!";
        model.addAttribute("greeting",thegreeting);
        return "hello";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloPost(@RequestParam String name, Model model) {
        String thegreeting="Hello, "+name+"!";
        model.addAttribute("greeting",thegreeting);
        return "hello";
    }

//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "hello")
//    @ResponseBody
//    public String helloPost(@RequestParam String name, @RequestParam String language) {
//        if (name == null) {
//            name = "World";
//        }
//
//        return createMessage(name, language);
//
//        // For a bonus mission, students can change this response text to look nicer.
//        // This is subjective, but students should be modifying the HTML of the response string.
//    }
//    @ResponseBody
//    public static String createMessage(String n, String l) {
//        String greeting = "";
//
//        if (l.equals("english")) {
//            greeting = "Hello";
//        }
//        else if (l.equals("mandarin")) {
//            greeting = "Ni Hua";
//        }
//        else if (l.equals("italian")) {
//            greeting = "Bonjourno";
//        }
//        else if (l.equals("spanish")) {
//            greeting = "Hola";
//        }
//        else if (l.equals("french")) {
//            greeting = "Bonjour";
//        }
//
//        return greeting + " " + n;
//    }

    //lives /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
//        return "<html>" +
//                "<body>" +
//                "<form action='hello' method='post'>" + //submit a request to /hello
//                "<input type='text' name='name'>" +
//                "<select name='language'>" +
//                "      <option value='english'>English</option>" +
//                "      <option value='mandarin'>Mandarin</option>" +
//                "      <option value='italian'>Italian</option>" +
//                "      <option value='spanish'>Spanish</option>" +
//                "      <option value='french'>French</option>" +
//                "</select>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
    }

    @GetMapping("hello-names")
    public String HelloNames(Model model){
        List<String> names=new ArrayList<>();
        names.add("Java");
        names.add("JavaScript");
        names.add("Html");
        model.addAttribute("names",names);
        return "hello-list";
    }
}
