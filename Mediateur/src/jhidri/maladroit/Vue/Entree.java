package jhidri.maladroit.Vue;

import java.awt.Container;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

/**
 * Permet la saisie d'un texte sur une ligne
 * */
public class Entree extends Panel
{
public Label labelEntree;
public TextField entree;

/**
 * @param label : libell� du composant texte de saisie
 * @param largeur : largeur (en colonnes) du champ de saisie
 * @param container : container sur lequel sera coll� ce composant
 */
public Entree(String label, int largeur, Container container)
{
this.labelEntree = new Label(label);
this.add(this.labelEntree);
this.entree = new TextField(largeur);
this.add(this.entree);
container.add(this);
}

}
