package SpringBootApplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Registrering {

	@RequestMapping("/reg")
	public String regSkjema(Model model) {
		return "hilsen";
	}
	
	@PostMapping("/registrer")
	public String paamelding(Model model,
			@RequestParam(name = "fornavn") String fornavn,
			@RequestParam(name = "etternavn") String etternavn,
			@RequestParam(name = "mobil") int mobil,
			@RequestParam(name = "passord") String passord,
			@RequestParam(name = "kjonn") Kjonn kjonn
			) {
		
		Deltager deltager = new Deltager(fornavn, etternavn, mobil, passord, kjonn);
		model.addAttribute("d", deltager);
		System.err.println(deltager);
		return "hilsen";
	}
	
	@PostMapping("/lagrePerson")
	public String lagrePerson(@ModelAttribute("deltager") Deltager deltager) {
		System.err.println(deltager);
		System.err.println("Lagrer i database...");
		return "paameldt";
	}
	
}
