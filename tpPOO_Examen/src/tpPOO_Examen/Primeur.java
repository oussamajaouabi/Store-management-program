package tpPOO_Examen;

public class Primeur extends Article implements VendableParKilogramme{
	
	private double qteStock, qteVendue;
	
	public Primeur(double prixAchat, double prixVente, String nom, String nomFournisseur) {
		super(prixAchat, prixVente, nom, nomFournisseur);
		qteStock = 0;
		qteVendue = 0;
	}

	@Override
	public double getQteVendue() {
		return qteVendue;
	}
	
	public double remplirStock(double qte) { /* qte => la quantité à remplir */
		qteStock += qte;
		return getPrixAchat() * qte;
	}
	
	/* Description des caractéristiques du produit */
		@Override
		public void afficherCaracteristiques() {
			super.afficherCaracteristiques();
			System.out.println("\t\t" + qteStock + " KG");
		}
	
	@Override
	public double vendre(double qteVendue) {
		if (qteVendue <= qteStock) {
			this.qteVendue += qteVendue; // Incrémentation du quantité vendue de l'article primeur
			
			qteStock -= qteVendue;
			return super.getPrixVente()*qteVendue;
		} else {
			return -1;
		}
	}
	
}
