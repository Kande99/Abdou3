package com.saraya.SpringBoot1;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("UserName")
public class ScooterController {

	@Autowired
	ScooterService ss;
	@RequestMapping(value="/list-scooter", method=RequestMethod.GET)
	public String ShowList(ModelMap model) {
		model.addAttribute("scooters", ss.getAllScooters());
		return "scooterList";
	}
	
	//------------------ADDING METHOD----------------------------
	
	@RequestMapping(value="/add-scooter", method=RequestMethod.GET)
			public String addScooterForm(ModelMap model) {
		model.addAttribute("speeder", new Scooter());
		return "addScooter";
	}
	
	@RequestMapping(value="/add-scooter", method=RequestMethod.POST)
	public String scooterAdded(ModelMap model, @Valid @ModelAttribute("speeder") Scooter s, BindingResult result) {
		if(result.hasErrors()) {
			return "addScooter";
		}
		ss.addScooter(s.getYear(), s.getMake(), s.getModel(), s.getImage());
		model.clear();
		return "redirect:/list-scooter";
	}
	
	
	//----------------------------------------------------------------
	
	
	
	//--------------UPDATE METHOD-----------------------------
	
	@RequestMapping(value="/update-scooter", method=RequestMethod.GET)
	public String updateScooterForm(ModelMap model, @RequestParam int id) {
		model.addAttribute("speeder", ss.findById(id));
		return "addScooter";
	}
	//-------------------------------------------------
	@RequestMapping(value="/update-scooter", method=RequestMethod.POST)
	public String scooterListUpdate(ModelMap model, @Valid @ModelAttribute("vehicle") Scooter s,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "addScooter";
		}
		
		ss.updateByScooter(s);
		model.clear();
		return "redirect:/list-scooter";
	}
	//-----------------------------------------------------
	
	@RequestMapping(value="/delete-scooter", method=RequestMethod.GET)
	public String deleteList(ModelMap model, @RequestParam int id ) {
		ss.deleteScooter(id);
		model.clear();
		return "redirect:/list-scooter";
		
	}
}