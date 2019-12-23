package jhidri.maladroit.Model;


import jhidri.maladroit.Model.jeu.CoupShifumi;
import jhidri.maladroit.Model.jeu.Mediateur;

/**
 * repr�sente le d�roulement d'une partie de Shifumi
 * 
 * */
public class PartieShifumi
{
public CoupShifumi coupShifumi[];
public Banque banque;
public Mediateur mediateur;
public PartieShifumi()
{
this.coupShifumi = new CoupShifumi[2];
this.banque = new Banque();
this.mediateur = new Mediateur(banque);

}

}
