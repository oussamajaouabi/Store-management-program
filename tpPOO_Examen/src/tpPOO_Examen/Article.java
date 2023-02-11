package tpPOO_Examen;

public abstract class Article {
	
	private double prixAchat, prixVente;
	private String nom, fournisseur;
	
	public Article(double prixAchat, double prixVente, String nom, String fournisseur) {
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.nom = nom;
		this.fournisseur = fournisseur;
	}

	/* Getters */
		public double getPrixAchat() {
			return prixAchat;
		}
	
		public double getPrixVente() {
			return prixVente;
		}
	
		public String getNom() {
			return nom;
		}
	
	/* Calculateur du taux du rendement */
		public double tauxRendement() {
			try {
				return (prixVente - prixAchat)/prixAchat * 100;
			} catch (ArithmeticException e) {
				System.out.println(e.toString());
				return -1;
			}
		}
	
	/* Description des caractéristiques du produit */
		public void afficherCaracteristiques() {
			System.out.print(nom + "\t\t" + prixAchat + "\t\t" + prixVente + "\t\t" + fournisseur + "\t\t" + Math.round(tauxRendement() * 100.0) / 100.0 + "%");
		}
		
	/* Méthode abstraite qui retourne la quantité vendue de l'article */
		public abstract double getQteVendue();
	
}
