package jhidri.maladroit.Controlleurs;

import jhidri.maladroit.Model.PartieShifumi;
import jhidri.maladroit.Model.jeu.Arbitre;
import jhidri.maladroit.Vue.PanneauResultat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Calcul et affichage des r�sultats de la partie et
 * r�ponse � la requ�te "clic sur le bouton rejouer"
 * */
public class EcouteurArbitre implements ActionListener
{
PanneauResultat panneauResultat;
PartieShifumi partieShifumi;
public EcouteurCoupJoue ecouteurCoupJoue0;
public EcouteurCoupJoue ecouteurCoupJoue1;

public EcouteurArbitre(PanneauResultat panneauResultat,
        PartieShifumi partieShifumi, EcouteurCoupJoue ecouteurCoupJoue0,
        EcouteurCoupJoue ecouteurCoupJoue1)
{
this.panneauResultat = panneauResultat;
this.partieShifumi = partieShifumi;
this.ecouteurCoupJoue0 = ecouteurCoupJoue0;
this.ecouteurCoupJoue1 = ecouteurCoupJoue1;
}

void init()
{
/* 
 * ici, on fait les calculs pour savoir qui a gagn�, qui a perdu (ou si c'est match nul)  et les calculs de gain et on  affiche tout sur le panneauResultat
 * 
 * on utilise les donn�es contenues dans partieShifumi
*/

int verdict = Arbitre.arbitrage(this.partieShifumi.coupShifumi);

// le gagnant est � pr�sent dans la position 0 et le perdant � la position 1

String libelleGagnant, libellePerdant;

if (verdict == Arbitre.GAGNE) 
   { 
   libelleGagnant = PanneauResultat.LIBELLE_GAGNANT;
   libellePerdant = PanneauResultat.LIBELLE_PERDANT;
   }
else /* il y a match nul*/
   libelleGagnant = libellePerdant = "match nul";

this.panneauResultat.remplit( libelleGagnant, this.partieShifumi.coupShifumi[0].pseudoJoueur, 
                              libellePerdant, this.partieShifumi.coupShifumi[1].pseudoJoueur, 
                              this.partieShifumi.coupShifumi[0].miseJouee, 
                              this.partieShifumi.coupShifumi[1].miseJouee, 
                              this.partieShifumi.banque.montant);

this.panneauResultat.boutonRejouer.addActionListener(this);
}

void desInit()
{
this.partieShifumi.coupShifumi[0] = this.partieShifumi.coupShifumi[1] = null;
this.panneauResultat.boutonRejouer.removeActionListener(this);

this.panneauResultat.vide(); //re-initialise le panneauR�sultat sauf en ce qui concerne la banque

}

@Override
public void actionPerformed(ActionEvent e)
{

this.desInit();
this.ecouteurCoupJoue0.init(); 
this.ecouteurCoupJoue1.init();
}

}
