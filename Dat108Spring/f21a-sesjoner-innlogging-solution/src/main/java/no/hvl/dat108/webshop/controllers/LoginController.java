package no.hvl.dat108.webshop.controllers;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.webshop.util.InputValidator;
import no.hvl.dat108.webshop.util.LoginUtil;

@Controller
@RequestMapping("/${app.url.login}")
public class LoginController {
	
	@Value("${app.message.invalidUsername}") private String INVALID_USERNAME_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.deltagerliste}") private String DELTAGERLISTE_URL;
	
	/* 
	 * GET /login er forespørselen for å hente login-skjema.
	 */
	
	@GetMapping
    public String hentLoginSkjema() {
		return "innlogging_med_melding";
    }

	/* 
	 * POST /login er forespørselen for å logge inn.
	 */
	@PostMapping
    public String provAaLoggeInn(@RequestParam String mobil,
    		HttpServletRequest request,	RedirectAttributes ra) {
		
		if (!InputValidator.isValidUsername(mobil)) {
			ra.addFlashAttribute("redirectMessage", INVALID_USERNAME_MESSAGE);
			System.err.println("provAvLoggeInn feilet");
			return "redirect:" + LOGIN_URL;
		}
		
		LoginUtil.loggInnBruker(request, mobil);
		
		return "redirect:" + DELTAGERLISTE_URL;
    }
}
