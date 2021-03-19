package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UtilisateurDaoImpl implements UtilisateurDao {
	
	
	private DaoFactory daoFactory;
	
	public UtilisateurDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	

	public ArrayList<String> afficheVilles() {
		ArrayList<String> ville = new  ArrayList<String>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM ville_france;");
			System.out.println(resultat);
			while(resultat.next()) {
				System.out.println(resultat.getString("Nom_commune"));
				ville.add(resultat.getString("Nom_commune"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ville;
	}


	@Override
	public ArrayList<String> villes(String codePostal) {
		ArrayList<String> ville = new  ArrayList<String>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT Nom_commune FROM ville_france WHERE Code_postal = (?);");
			preparedStatement.setString(1, codePostal);
			resultat = preparedStatement.executeQuery();
			while(resultat.next()) {
				ville.add(resultat.getString("Nom_commune"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ville;
	}

	
}
