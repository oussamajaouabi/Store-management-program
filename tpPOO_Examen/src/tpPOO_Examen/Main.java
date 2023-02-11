package tpPOO_Examen;

import java.util.Scanner;

public class Main {
	
	public static void menu() {
		System.out.print(
			"\n\t1. Ajouter un article\n"	
			+ "\t2. Remplir le stock\n"
			+ "\t3. Vendre un article\n"
			+ "\t4. Afficher l'état du magasin\n"
			+ "\t5. Afficher des statistiques\n"
			+ "\t━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"
			+ "\nEntrez un numéro (tapez -1 si vous voulez arrêter le programme): "
		);
	}
	
	public static void main(String[] args) {
		System.out.print("\t\t⭓ Application Console pour la gestion de stock d'un magasin ⭓\n");	
		Scanner scanner = new Scanner(System.in);	
		Magasin magasin = new Magasin();	
		menu();
		int operation = scanner.nextInt();
		while (true) {
			switch (operation) {
				case 1: {
					System.out.print(
							"\n\ta. Ajouter un article éléctroménager\n"	
							+ "\tb. Ajouter un article primeur\n"
					);
					System.out.print("\nEntrez a ou b: ");
					String choix = scanner.next();
					switch (choix) {
						case "a": {
							System.out.print("\n Entrez le nom de l'article: ");
							String nom = scanner.next();
							System.out.print(" Entrez le prix d'achat (en DT): ");
							double pa = scanner.nextDouble();
							System.out.print(" Entrez le prix de vente (en DT): ");
							double pv = scanner.nextDouble();
							System.out.print(" Entrez le nom du fournisseur: ");
							String nomf = scanner.next();
							
							Electromenager articleElectromenager = new Electromenager(pa, pv, nom, nomf);
							magasin.getElectromenagers().add(articleElectromenager);
							
							System.out.println("\n  ➔ L'article éléctroménager a bien été ajouté dans le magasin.");
							break;
						}
						case "b": {
							System.out.print("\n Entrez le nom de l'article: ");
							String nom = scanner.next();
							System.out.print(" Entrez le prix d'achat (en DT): ");
							double pa = scanner.nextDouble();
							System.out.print(" Entrez le prix de vente (en DT): ");
							double pv = scanner.nextDouble();
							System.out.print(" Entrez le nom du fournisseur: ");
							String nomf = scanner.next();	
							
							Primeur articlePrimeur = new Primeur(pa, pv, nom, nomf);
							magasin.getPrimeurs().add(articlePrimeur);
							
							System.out.println("\n  ➔ L'article primeur a bien été ajouté dans le magasin.");	
							break;
						}
							default:
								System.out.println("\n  ➔ Erreur d'entrée.");
					}
					break;
				}
				case 2: {
					System.out.print(
							"\n\ta. Remplir un article éléctroménager\n"	
							+ "\tb. Remplir un article primeur\n"
					);
					System.out.print("\nEntrez a ou b: ");
					String choix = scanner.next();
					switch (choix) {
						case "a": {
							System.out.print("\n Saisir l'indice de l'article: ");
							int i = scanner.nextInt();
							try {
								Electromenager articleElectromenager = magasin.getElectromenagers().get(i);
								if(articleElectromenager != null) {
									System.out.print(" Saisir le nombre de pièces à remplir dans le stock: ");
									int nbp = scanner.nextInt();
									magasin.setDepenses(magasin.getDepenses() + articleElectromenager.remplirStock(nbp));
									
									System.out.println("\n  ➔ Le remplissage du stock a bien été effectué.");
								} 
							} catch (Exception e) {
								System.out.println("\n  ➔ Erreur! " + e.toString());
							}
							break;
						}
						case "b": {
							System.out.print("\n Saisir l'indice de l'article: ");
							int i = scanner.nextInt();
							try {
								Primeur articlePrimeur = magasin.getPrimeurs().get(i);
								if (articlePrimeur != null) {
									System.out.print(" Saisir la quantité à remplir dans le stock: ");
									int qte = scanner.nextInt();
									magasin.setDepenses(magasin.getDepenses() + articlePrimeur.remplirStock(qte));
									
									System.out.println("\n  ➔ Le remplissage du stock a bien été effectué.");
								}
							} catch (Exception e) {
								System.out.println("\n  ➔ Erreur! " + e.toString());
							}
							break;
						}
							default:
								System.out.println("\n  ➔ Erreur d'entrée.");
					}
					break;
				}
				case 3: {
					System.out.print(
							"\n\ta. Vendre un article éléctroménager\n"	
							+ "\tb. Vendre un article primeur\n"
					);
					System.out.print("\nEntrez a ou b: ");
					String choix = scanner.next();
					switch (choix) {
						case "a": {
							System.out.print("\n Saisir l'indice de l'article: ");
							int i = scanner.nextInt();
							try {
								Electromenager articleElectromenager = magasin.getElectromenagers().get(i);
								if(articleElectromenager != null) {
									System.out.print(" Saisir le nombre de pièces à vendre: ");
									int nbp = scanner.nextInt();
									double revenuVente = articleElectromenager.vendre(nbp);
									if(revenuVente != -1) {
										magasin.setRevenus(magasin.getRevenus() + revenuVente);
										System.out.println("\n  ➔ Le vente de l'article a été bien effectué.");
									} else {
										System.out.println("\n  ➔ Échec, stock insuffisant.");
									}
								}
							} catch (Exception e) {
								System.out.println("\n  ➔ Erreur! " + e.toString());
							}
							break;
						}
						case "b": {
							System.out.print("\n Saisir l'indice de l'article: ");
							int i = scanner.nextInt();
							try {
								Primeur articlePrimeur = magasin.getPrimeurs().get(i);
								System.out.print(" Saisir la quantité à vendre: ");
								int qte = scanner.nextInt();
								double revenuVente = articlePrimeur.vendre(qte);
								if(revenuVente != -1) {
									magasin.setRevenus(magasin.getRevenus() + revenuVente);
									System.out.println("\n  ➔ Le vente de l'article a été bien effectué.");
								} else {
									System.out.println("\n  ➔ Erreur, stock insuffisant.");
								}	
							} catch (Exception e) {
								System.out.println("\n  ➔ Erreur! " + e.toString());
							}
							break;
						}
							default:
								System.out.println("\n  ➔ Erreur d'entrée.");
					}
					break;
				}
				case 4: {
					magasin.etat();
					break;
				}
				case 5: {
					try {
						Article meilleurArticleVendu = magasin.meilleurProduitVendu();
						System.out.println(
								"\n  ➔ Meilleur Article Vendu : " + meilleurArticleVendu.getNom() +
								"\n   ↳ Quantité vendue : " + meilleurArticleVendu.getQteVendue() + " pièce(s) /ou KG." /* */
						);
					} catch (Exception e) {
						System.out.println("\n  ➔ Erreur! " + e.toString());
					}	
					break;
				}
				case -1: {
					System.out.println("\n  ➔ Fin du programme.");
					scanner.close();
					System.exit(0);
				}
				default:
					System.out.println("\n  ➔ Erreur d'entrée! opération échouée, essayez à nouveau.");
			}	
			menu();
			operation = scanner.nextInt();
		}
	}
	
}