package com.katwdojo.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.katwdojo.dojosandninjas.models.Dojo;
import com.katwdojo.dojosandninjas.models.Ninja;
import com.katwdojo.dojosandninjas.services.DojoService;
import com.katwdojo.dojosandninjas.services.NinjaService;

@Controller
public class MainController {

	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/")
	public String dashboard(Model allDojos){
		allDojos.addAttribute("allDojos",dojoService.getAllDojos());
		return "dashboard.jsp";
	}
	
	@GetMapping("/newdojo")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo, Model allDojos) {
		allDojos.addAttribute("allDojos",dojoService.getAllDojos());
		return "newdojo.jsp";
	}
	
	@PostMapping("/createdojo")
	public String addDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result, Model allDojos) {
		if (result.hasErrors()) {
			allDojos.addAttribute("allDojos", dojoService.getAllDojos());
			return "newdojo.jsp";
		}else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/newninja")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model allDojos) {
		allDojos.addAttribute("allDojos", dojoService.getAllDojos());
		return "newninja.jsp";
	}
	
	@PostMapping("/createninja")
	public String addNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model allDojos) {
		if(result.hasErrors()) {
			allDojos.addAttribute("allDojos", dojoService.getAllDojos());
			return "newninja.jsp";
		}else {
			ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojoshow/{id}")
		public String showNinjas(@PathVariable Long id, Model viewDojo) {
			viewDojo.addAttribute("dojo", this.dojoService.findDojo(id));
			return "dojoshow.jsp";
	}
	
}
