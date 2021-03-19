package com.dao;

import java.util.ArrayList;

public interface UtilisateurDao {

	ArrayList<String> afficheVilles();
	ArrayList<String> villes(String codePostal);
}
