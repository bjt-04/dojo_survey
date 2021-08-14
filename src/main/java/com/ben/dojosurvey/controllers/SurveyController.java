package com.ben.dojosurvey.controllers;

import javax.servlet.http.HttpSession;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SurveyController {

	@RequestMapping("/")
	public String index(Model model) {
//		model example:
		int xValue = 11;
		Date ii = new Date();
		model.addAttribute("myDate", ii);
		model.addAttribute("x", "<h1>hello</h1>");
		model.addAttribute("y", "<h1>hello</h1><script>alert('you are hacked')</script>");
		return "index.jsp";
	}

//	@RequestMapping(value="/process_form", method=RequestMethod.POST)

	@PostMapping("/process_form")
	public String doStuff(@RequestParam("name") String name, @RequestParam("language") String lang,
			@RequestParam("comment") String comment, RedirectAttributes rA, HttpSession sesh) {
		System.out.println("form!!!!!");
		System.out.println(name);
		System.out.println(lang);
		System.out.println(comment);

		rA.addFlashAttribute("name", name);
		sesh.setAttribute("lang", lang);
		sesh.setAttribute("comment", comment);

		if (name.length() < 2) {
			rA.addFlashAttribute("error", "you need more chars in name");
			return "redirect:/";
		}
		if (lang.equals("java")) {
			return "redirect:/secret";
		}
		return "redirect:/results";
	}

	@GetMapping("/results")
	public String showResults() {
		return "results.jsp";
	}

	@GetMapping("/secret")
	public String goToSecret() {
		return "secret.jsp";
	}

}