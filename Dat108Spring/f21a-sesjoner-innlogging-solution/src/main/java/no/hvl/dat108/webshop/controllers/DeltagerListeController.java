package no.hvl.dat108.webshop.controllers;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.webshop.objects.Deltager;
import no.hvl.dat108.webshop.services.DeltagerService;
import no.hvl.dat108.webshop.util.LoginUtil;

@Controller
@RequestMapping("/${app.url.deltagerliste}")
public class DeltagerListeController {
	
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.deltagerliste}") private String DELTAGERLISTE_URL;

	@Autowired
	private DeltagerService service;
	
	/* 
	 * GET /deltagerliste er forespørselen for å vise deltagerliste-siden.
	 */
	
	@GetMapping
    public String visDeltagerListe(HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		System.err.println(service.finnDeltagerMedMobil("12345678"));
		
		return "deltagerliste";
    }
}
