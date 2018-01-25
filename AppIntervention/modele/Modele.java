package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controler.Client;

public class Modele 
{
	public static String verifConnexion(String login, String mdp)
	{
		String droits ="";
		String requete ="select count(*) as nb, droits from user where login='"+login +"' and mdp = '"+mdp +"';";
		Bdd uneBdd = new Bdd ("localhost", "intervention", "root", "");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				int nb = unRes.getInt("nb");
				if (nb>0){
					droits = unRes.getString("droits");
				}
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
		System.out.println("Erreur :"+ requete);
		}
		catch (NullPointerException exp)
		{
			System.out.println("Erreur Connexion BDD non fonctionnelle");
		}
		return droits;
	}
	
	/******************** Model Client *********/
	
	public static ArrayList<Client> selectAllClients(){
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete="select * from client";
	
		Bdd uneBdd = new Bdd ("localhost", "intervention", "root", "");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next()) {
				int idClient = unRes.getInt("idClient");
				String nom = unRes.getString("nom");
				String adresse = unRes.getString("adresse");
				String typeClient = unRes.getString("typeClient");
				Client unClient = new Client(idClient, nom, adresse, typeClient);
				lesClients.add(unClient);
									
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
			
		}catch (SQLException e) {
			
			System.out.println("Erreur fetch client");
		}
			return lesClients;
	}
	
	public static Client selectWhereClient (Client unClient) {
		
		Client leClient = null;
		
		String requete = "select idclient from client where nom='"+unClient.getNom()+
				"' AND adresse = '"+unClient.getAdresse()+
				"' AND typeclient = '"+unClient.getTypeClient()+"');";
		
		Bdd uneBdd = new Bdd ("localhost", "intervention", "root", "");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				int idClient = unRes.getInt("idclient");
				leClient = new Client (idClient, unClient.getNom(), unClient.getAdresse(), unClient.getTypeClient());
				
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
		}catch (SQLException e) {
			System.out.println("Erreur : "+requete);
		}
		return leClient;
	}
	
	public static void insertClient (Client unClient) {
		String requete = "insert into client values (null, '"+unClient.getNom()+
				"','"+unClient.getAdresse()+
				"','"+unClient.getTypeClient()+"');";
		
		execRequete(requete);

			
		
	}
	
	public static void updateClient (Client unClient) {

		String requete = "update into client set nom='"+unClient.getNom()+
				"', adresse = '"+unClient.getAdresse()+
				"', typeClient = '"+unClient.getTypeClient()+
				"', idClient = '"+unClient.getIdClient()+"');";
		execRequete(requete);

		
			
		
	}
	
	public static void deleteClient (Client unClient) {

		String requete = "delete from client where idClient = "+unClient.getIdClient()+" ;";
		
		execRequete(requete);
			
		
	}
	
	private static void execRequete (String requete) {
		
		Bdd uneBdd = new Bdd ("localhost", "intervention", "root", "");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
			
		}catch (SQLException e) {
			
			System.out.println("Erreur" +requete);
		}
	}

}
