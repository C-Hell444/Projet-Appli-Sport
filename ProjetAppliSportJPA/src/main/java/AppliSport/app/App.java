package AppliSport.app;

import java.util.Scanner;

public class App {
	
	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	//==========================================================//
	// ==================  MENUS DEMARRAGE  =================== //
	//==========================================================//
	
	public static void menuPrincipal() {

		System.out.println("Menu principal");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Cr�er un compte");
		System.out.println("3 - Fermer l'appli");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : connexion();break;
		case 2 : creationCompte();break;
		case 3 : System.exit(0);break;
		}
		menuPrincipal();
	}

	public static void creationCompte() {
		
		
	}
	
	public static void connexion() {
		
	}
	
	//==========================================================//
	// ===================  MENU ADMIN  ======================= //
	//==========================================================//
	
	public static void menuAdmin() {

		//	notifications de validation des clubs / evenements  								
		//## SELECT * (validation admin attribut table OU nouvelle table_tampon OU acc�s java)
		//	ajouter un sport / valider un sport			
		//## INSERT INTO sport SPORT	## DELETE from table_tampon SPORT
		// 	afficher les infos de clubs / utilisateurs / evenements / equipes (historique ?)
		//## findALL ----------		## findById ------------	## UPDATE		## DELETE 
	}
	
	//==========================================================//
	// ===================  MENU USER  ======================== //
	//==========================================================//
	
	public static void menuUtilisateur() {

		// 	modifs des stats / profil
		//## UPPDATE
		//	demande d'inscription aux clubs / evenements / equipes
		//## SELECT id from equipe/club/eve 	##	INSERT INTO table_tampon 
		//	rechercher avec des FILTRES ! (partenaires/localisation/sports...)
		// 	afficher son historique
		//	notifications de propositions d'evenement
		
	}
	
	public static void menuEquipeU() {
		
		//	afficher les membres de l'equipe
		// 	infos de l'equipe (club, sport, categorie, classement)
		//	chat de groupe (coach, membres)
		
	}

	public static void menuEvenementU() {
		
	}
	
	//==========================================================//
	// ===================  MENU CLUB  ======================== //
	//==========================================================//
	
	public static void menuClub() {
		
			//	modifs profil
			// 	cr�er equipes + FILTRES par s�lection par crit�res joueurs
			// 	cr�er evenements avec des param�tres
			//	demande d'inscription � l'admin (evenements, sports)
			//	rechercher avec des FILTRES ! (partenaires/localisation/sports...)
			// 	afficher son historique avec FI5LTRES ! (evenements, equipes, joueurs)
			//	notifications de demande d'inscription
		
	}

	public static void menuEquipeC() {
		
		//	afficher les equipes
		//	ajouter / supprimer des membres 
		//	modifier caracs equipe
		//	Inscription � �v�nements
		
	}

	public static void menuEvenementC() {
		
		//	configurer 
		//	ajouter / supprimer des membres 
		//	modifier caracs evenement
		
	}

	//==========================================================//
	// ======================  MAIN  ========================== //
	//==========================================================//
	
	public static void main(String[] args) {
		

		menuPrincipal();
		
	}


}
