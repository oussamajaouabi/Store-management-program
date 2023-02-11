package tpPOO_Examen;

public class Electromenager extends Article implements VendableParPiece{
	
	private int nbPiecesStock, qteVendue;
	
	public Electromenager(double prixAchat, double prixVente, String nom, String nomFournisseur) {
		super(prixAchat, prixVente, nom, nomFournisseur);
		nbPiecesStock = 0;
		
		qteVendue = 0;
	}
	
	@Override
	public double getQteVendue() {
		return qteVendue;
	}

	public double remplirStock(int qte) { /* qte => le nombre de pièces à remplir */
		nbPiecesStock += qte;
		return getPrixAchat() * qte;
	}
	
	/*Description des caractéristiques du produit */
		@Override
		public void afficherCaracteristiques() {
			super.afficherCaracteristiques();
			System.out.println("\t\t" + nbPiecesStock);
		}
	
	@Override
	public double vendre(int qteVendue) {
		if (qteVendue <= nbPiecesStock) {
			this.qteVendue += qteVendue; // Incrémentation du quantité vendue de l'article électroménager
			
			nbPiecesStock -= qteVendue;
			return super.getPrixVente()*qteVendue;
		} else {
			return -1;
		}
	}
	
}
