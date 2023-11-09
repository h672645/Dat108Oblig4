package no.hvl.dat108.webshop.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.webshop.objects.Deltager;

public class LoginUtil {

	private final static int MAX_INTERACTIVE_INTERVAL = 300;

	public static void loggUtBruker(HttpSession session) {
		session.invalidate();
		System.err.println("bruker force-logget ut");
	}

	public static void loggInnBruker(HttpServletRequest request, String mobil, String fornavn, String etternavn) {

		loggUtBruker(request.getSession());
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
		session.setAttribute("mobil", mobil);
		session.setAttribute("fornavn", fornavn);
		session.setAttribute("etternavn", etternavn);
		
		System.err.println("bruker pålogget");
	}

	public static void loggInnBruker(HttpServletRequest request, String mobil) {
		
		loggUtBruker(request.getSession());
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
		session.setAttribute("mobil", mobil);
		
		//Slå opp ekstra informasjon om fornavn/etternavn/evt passordsjekk
		
		System.err.println("bruker pålogget");
	}

	public static boolean erBrukerInnlogget(HttpSession session) {
		if(session != null && session.getAttribute("mobil") != null) {
			System.err.println("brukersjekk: pålogget");
		} else {
			System.err.println("brukersjekk: ikke pålogget");
		}
		return session != null && session.getAttribute("mobil") != null;
	}

}
