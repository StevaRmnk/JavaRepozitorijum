package com.example.SpringProjekat.Kontroleri;

import java.awt.PageAttributes.MediaType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.example.SpringProjekat.Model.Jezik;
import com.example.SpringProjekat.Model.Korisnik;
import com.example.SpringProjekat.Model.Uloga;
import com.example.SpringProjekat.Servis.JezikServis;
import com.example.SpringProjekat.api.ApiClass;

import okhttp3.*;

@Controller
@RequestMapping("/jezici")
public class JezikKontroler {
	
	@Autowired
	JezikServis jezikServis;
	
	@GetMapping("")
	public ModelAndView stranicaSvihJezika(HttpSession sesija) {
		sesija.removeAttribute("ulogovan");
		List<Jezik> sviJezici = jezikServis.nadjiSveJezike();
		ModelAndView rezultat = new ModelAndView("sviJezici");
		rezultat.addObject("sviJezici",sviJezici);
		return rezultat;
	}
	
	@GetMapping("/StranicaJednogJezika")
	public ModelAndView stranicaJednogJezika(@RequestParam String imeJezika) {
		Jezik zeljeni =  jezikServis.nadjiJedanJezikPrekoImena(imeJezika);
		ModelAndView rezultat = new ModelAndView("jedanJezik");
		rezultat.addObject("mojJezik",zeljeni);
		return rezultat;
	}
	
	@GetMapping("/StranicaDodavanjaJezika")
	public ModelAndView stranicaDodavanjaJezika(HttpSession sesija) {
		Korisnik ulogovan = (Korisnik) sesija.getAttribute("korisnik");
		if(ulogovan.getUloga().equals(Uloga.Administrator)) {
			ModelAndView rezultat = new ModelAndView("dodavanjeJezika");
			return rezultat;
		}
		return null;
	}
	
	@PostMapping("/DodajJezik")
	public String upisivanjeJezikaUBazu(@RequestParam String imeJezika,@RequestParam String vrednost,HttpSession sesija) {
		Jezik noviJezik = new Jezik();
		noviJezik.setImeJezika(imeJezika);
		noviJezik.setVrednost(vrednost);
		jezikServis.sacuvajJezik(noviJezik);
		sesija.removeAttribute("ulogovan");
		return "redirect:/jezici";
	}
	
	@GetMapping("/secure/svi")
	public ModelAndView sigurnaStranicaSvihJezika() {
		List<Jezik> sviJezici = jezikServis.nadjiSveJezike();
		boolean ulogovan = true;
		ModelAndView rezultat = new ModelAndView("sviJezici");
		rezultat.addObject("sviJezici",sviJezici);
		rezultat.addObject("ulogovan",ulogovan);
		return rezultat;
	}
	
	@PostMapping("/prevedi")
	public String prevediSaSajta() {
		return ApiClass.nadjiPrevodPrekoAPIA("de");
	}

	

}
