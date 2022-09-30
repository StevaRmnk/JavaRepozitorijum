package com.example.SpringProjekat.Kontroleri;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringProjekat.api.ApiClass;

@Controller
@RequestMapping("/api")
@Profile("test")
public class ApiKontroler {
	
	@PostMapping("/prevedi")
	public String prevediSaSajta() {
		return ApiClass.nadjiPrevodPrekoAPIA("de");
	}

}
