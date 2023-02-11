package tpPOO_Examen;

import java.util.ArrayList;

public class Magasin {
	
	private double depenses, revenus;
	private ArrayList<Electromenager> electromenagers;
	private ArrayList<Primeur> primeurs;
	
	public Magasin() {
		this.depenses = 0;
		this.revenus = 0;
		electromenagers = new ArrayList<>();
		primeurs = new ArrayList<>();
	}

	/* Getters & Setters */
	
		public double getDepenses() {
			return depenses;
		}
	
		public void setDepenses(double depenses) {
			this.depenses = depenses;
		}
	
		public double getRevenus() {
			return revenus;
		}
		
		public void setRevenus(double revenus) {
			this.revenus = revenus;
		}
		
		public ArrayList<Electromenager> getElectromenagers() {
			return electromenagers;
		}
	
		public ArrayList<Primeur> getPrimeurs() {
			return primeurs;
		}

	/* Description de l'état du magasin */
		public void etat() { 
			System.out.println("\n\t\t⭔ L'état du magasin ⭔\n");
			System.out.println("  ◈ Les dépenses du magasin: " + depenses + " DT");
			System.out.println("  ◈ Les revenus du magasin: " + revenus + " DT");
			System.out.println("  ◈ Le taux de rendement du magasin: " + Math.round(tauxRendement() * 100.0) / 100.0 + "%");
			
			System.out.println("\n  ◈ Liste des articles:");
			
			System.out.println("\n  ◇ Articles électroménagers:\n");
			System.out.println("\tIndice\t\tNom d'article\tPrix d'achat\tPrix de vente\tFournisseur\tRendement\tNombre de Pièces en stock");
			System.out.println("\t-------------   -------------   -------------   -------------   -------------   -------------   -------------------------");
			int i = 0;
			for (Electromenager electromenager : electromenagers) {
				System.out.print("\t" + i + "\t\t");
				electromenager.afficherCaracteristiques();
				i++;
			}
			
			System.out.println("\n  ◇ Articles primeurs:\n");
			System.out.println("\tIndice\t\tNom d'article\tPrix d'achat\tPrix de vente\tFournisseur\tRendement\tQuantité en stock");
			System.out.println("\t-------------   -------------   -------------   -------------   -------------   -------------   -----------------");
			int j = 0;
			for (Primeur primeur : primeurs) {
				System.out.print("\t" + j + "\t\t");
				primeur.afficherCaracteristiques();
				j++;
			}
		}
	
	/* Calculateur du taux de rendement */
		public double tauxRendement() {
			try {
				return (revenus - depenses)/depenses * 100;
			} catch (ArithmeticException e) {
				System.out.println(e.toString());
				return -1;
			}
		}
	
	/* Amélioration: Meilleur produit vendu */
		public Article meilleurProduitVendu() {
			int qteVendueMaxE = 0;
			double qteVendueMaxP = 0;
			Electromenager meilleurAeVendu = null;
			Primeur meilleurApVendu = null;
			
			/* 
			  * On fait une recherche du meilleur article électroménager vendu (en bouclant sur la table electromenagers)
			  * Ensuite, on fait une recherche du meilleur article primeur vendu (en bouclant sur la table primeurs)
			  * Puis, on compare la quantité vendue de chacun des 2 articles afin de déterminer le meilleur produit vendu dans le magasin.   
			*/
			
			if(electromenagers.size() != 0 || primeurs.size() != 0) {		
				if(electromenagers.size() != 0) {
					qteVendueMaxE = (int) electromenagers.get(0).getQteVendue();
					meilleurAeVendu = electromenagers.get(0);	
					for (Electromenager ae : electromenagers) {
						if(qteVendueMaxE < ae.getQteVendue()) {
							qteVendueMaxE = (int) ae.getQteVendue();
							meilleurAeVendu = ae;
						}
					}
				}
				if (primeurs.size() != 0) {
					qteVendueMaxP = primeurs.get(0).getQteVendue();
					meilleurApVendu = primeurs.get(0);	
					for (Primeur ap : primeurs) {
						if(qteVendueMaxP < ap.getQteVendue()) {
							qteVendueMaxP = ap.getQteVendue();
							meilleurApVendu = ap;
						}
					}
				}
				if (qteVendueMaxE > qteVendueMaxP) {
					return meilleurAeVendu;
				} else {
					return meilleurApVendu;
				}
			} else {
				return null;
			}
		}
		
}
