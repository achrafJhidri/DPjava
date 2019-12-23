package jhidri.maladroit.Vue;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextField;

/**
 * Formulaire du coup de shifumi à jouer
 * 
 * permet la saisie de : pseudo du joueur, mise (au sens d'un pari) et coup joué
 * */
public class FormulaireCoupJoueur extends Panel
{
private static final int LARGEUR_SAISIE = 10; // largeur (en colonnes) d'un champ de saisie
public int numeroJoueur;
Label labelTitre;

public Entree entreePseudo;

public Entree entreeMise;

public BoutonChoixCoup boutons[];

Panel panelTitre, panelPseudo, panelMise, panelBoutons;

/**
 * @param numeroJoueur : relatif à une des cases du tableau contenu dans un objet PartieShifumi, donc 0 ou 1
 * @param labelsBoutons : exemple : {"pierre", "feuille","ciseaux"} ou  encore {"pierre", "feuille","ciseaux","puits"}
 */
public FormulaireCoupJoueur( int numeroJoueur, String[] labelsBoutons)
{
super();
this.numeroJoueur = numeroJoueur;

//-------------------------on installe les 4 panneaux titre, haut (pseudo), centre (mise) et bas (coup joué) -----------------------

this.setLayout(new GridLayout(4,1));        //  grille à 4 lignes et une colonne

this.panelTitre = new Panel();
this.add(this.panelTitre);

this.panelPseudo = new Panel();
this.add(this.panelPseudo);

this.panelMise = new Panel();
this.add(this.panelMise);

this.panelBoutons = new Panel();
this.add(this.panelBoutons);

//----------------------- Remplissage panneau titre ------------------------

this.labelTitre = new Label("Choix Joueur n° " + this.numeroJoueur);
this.panelTitre.add(this.labelTitre);

//------------------------ Remplissage panneau saisie pseudo ---------------

this.entreePseudo = new Entree("Pseudo", LARGEUR_SAISIE, this.panelPseudo);

//------------------------ Remplissage panneau saisie mise -----------------

this.entreeMise = new Entree("Mise jouée",LARGEUR_SAISIE, this.panelMise);

//------------------------ Remplissage panneau boutons choix coup joué -----------------

this.boutons = new BoutonChoixCoup[labelsBoutons.length];

int i;
for (i = 0; i < labelsBoutons.length; ++i) 
    {
    this.boutons[i] = new BoutonChoixCoup(labelsBoutons[i], i);
    this.panelBoutons.add(this.boutons[i]);
    }

}

public void init()
{
this.entreeMise.entree.setText("0");
}

public String getPseudo() { return this.entreePseudo.entree.getText(); }
public double getMiseJouee() { return Double.parseDouble(this.entreeMise.entree.getText().trim()); }
}
