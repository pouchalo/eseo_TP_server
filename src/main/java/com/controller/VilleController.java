package com.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.DaoFactory;
import com.dao.UtilisateurDao;
@RestController
public class VilleController {
	
	//Methode GET
	
	/*@RequestMapping(value = "/ville/{codePostal}", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> appelGet(@PathVariable("codePostal") String codePostal) {
		UtilisateurDao utilisateurDao = DaoFactory.getInstance().getUtilisateurDao();
		ArrayList<String> ville = utilisateurDao.villes(codePostal);

		return ville;
	}*/
	
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> appelGet1(@RequestParam("codePostal") String codePostal) {
		UtilisateurDao utilisateurDao = DaoFactory.getInstance().getUtilisateurDao();
		ArrayList<String> ville = utilisateurDao.villes(codePostal);

		return ville;
	}


}
