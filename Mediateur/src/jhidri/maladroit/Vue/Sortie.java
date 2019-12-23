package jhidri.maladroit.Vue;

import java.awt.Container;

/**
 * Permet la sortie d'un texte sur une ligne
 * */
public class Sortie extends Entree
{
/**
 * cf. commentaire classe de base
 * */
public Sortie(String label, int largeur, Container container)
{
super(label, largeur, container);
this.entree.setEditable(false);
}

}
