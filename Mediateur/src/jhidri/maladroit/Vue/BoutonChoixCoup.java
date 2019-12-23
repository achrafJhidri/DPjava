package jhidri.maladroit.Vue;

import outilsvues.Outils;

import java.awt.*;

/**
 * Bouton de choix de coup au shifumi
 * 
 * */
public class BoutonChoixCoup extends Button
{
public int i;  // indice du tableau dans lequel sera placé le bouton, indique aussi le choix : pierre, feuille, ciseaux, etc.


/**
 * @param label : libellé du bouton
 * @param i : indice du tableau dans lequel sera placé le bouton
 * @throws HeadlessException
 */
public BoutonChoixCoup(String label, int i) throws HeadlessException
{
super(label);
this.i = i;
}


    /**
     * vue g?n?rale du jeu de Shifumi ? deux joueurs
     *
     * */
    public static class CadreShifumi extends Frame
    {
    public FormulaireCoupJoueur formulaireCoupJoueur0;
    public FormulaireCoupJoueur formulaireCoupJoueur1;
    public PanneauResultat panneauResultat;

    Panel haut/*, bas*/;

    public CadreShifumi(String title, String labelsBoutons[]) throws HeadlessException
    {
    super(title);
    double Ox, Oy, largeur,hauteur;

    Ox = Oy = 1/3.0;
    largeur = hauteur = 0.5;
    Outils.place(this, Ox, Oy, largeur, hauteur);

    this.setLayout(new GridLayout(2,1));
    this.haut = new Panel();
    this.add(this.haut);

    /*this.bas = new Panel();
    this.add(this.bas);*/

    this.formulaireCoupJoueur0 = new FormulaireCoupJoueur(0, labelsBoutons);
    this.haut.add(this.formulaireCoupJoueur0);
    this.formulaireCoupJoueur1 = new FormulaireCoupJoueur(1, labelsBoutons);
    this.haut.add(this.formulaireCoupJoueur1);

    this.panneauResultat = new PanneauResultat();
    this./*bas.*/add(this.panneauResultat);

    }



    }
}
