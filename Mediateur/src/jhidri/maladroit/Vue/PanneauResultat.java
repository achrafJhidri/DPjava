package jhidri.maladroit.Vue;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextField;

/**
 * Panneau montrant le résultat d'une partie (c'est-à-dire après que les deux joueurs aient joué chacun une fois)
 * 
 * 
 * */
public class PanneauResultat extends Panel
{
private static final int LARGEUR_SORTIE = 12;
public static final String LIBELLE_GAGNANT = "Gagnant";
public static final String LIBELLE_PERDANT = "Perdant";

public Sortie sortieGagnant;

public Sortie sortiePerdant;

public Sortie sortieMontantGagne;

public Sortie sortieMontantPerdu;

public Sortie sortieBanque;

public Button boutonRejouer;

Panel panelGagnantPerdant, panelMontantGagnePerdu, panelBanque, panelboutonRejouer;


public PanneauResultat()
{
this.setLayout(new GridLayout(4, 1)); // grille à 4 lignes et une colonne

this.panelGagnantPerdant = new Panel();
this.add(this.panelGagnantPerdant);

this.panelMontantGagnePerdu = new Panel();
this.add(this.panelMontantGagnePerdu);

this.panelBanque = new Panel();
this.add(this.panelBanque);

this.panelboutonRejouer = new Panel();
this.add(this.panelboutonRejouer);

//-----------------------------------------------------------

this.sortieGagnant = new Sortie(LIBELLE_GAGNANT, LARGEUR_SORTIE, this.panelGagnantPerdant);
this.sortiePerdant = new Sortie(LIBELLE_PERDANT, LARGEUR_SORTIE, this.panelGagnantPerdant);

this.sortieMontantGagne = new Sortie("cagnotte",LARGEUR_SORTIE, this.panelMontantGagnePerdu);
this.sortieMontantPerdu = new Sortie("cagnotte",LARGEUR_SORTIE, this.panelMontantGagnePerdu);

this.sortieBanque = new Sortie( "Banque",LARGEUR_SORTIE, this.panelBanque);

this.boutonRejouer = new Button("Rejouer");
this.panelboutonRejouer.add(this.boutonRejouer);

}

void initLibelles(String gauche, String droite)
{
this.sortieGagnant.labelEntree.setText(gauche);
this.sortiePerdant.labelEntree.setText(droite);
}

public void vide()
{
this.remplitSaufBanque( LIBELLE_GAGNANT, "",  LIBELLE_PERDANT, "", 0, 0);
}

void remplitSaufBanque( String libelleGagnant, String pseudoGagnant, String libellePerdant, String pseudoPerdant,
              double cagnotteGagnant, double cagnottePerdant)
{
this.initLibelles(libelleGagnant, libellePerdant);
this.sortieGagnant.entree.setText(pseudoGagnant);
this.sortiePerdant.entree.setText(pseudoPerdant);
this.sortieMontantGagne.entree.setText(Double.toString(cagnotteGagnant));
this.sortieMontantPerdu.entree.setText(Double.toString(cagnottePerdant));
}

public void remplit( String libelleGagnant, String pseudoGagnant, String libellePerdant, String pseudoPerdant,
        double cagnotteGagnant, double cagnottePerdant, 
        double montantBanque)
{
this.remplitSaufBanque(libelleGagnant, pseudoGagnant, libellePerdant, pseudoPerdant, cagnotteGagnant, cagnottePerdant);
this.sortieBanque.entree.setText(Double.toString(montantBanque));
}

}


