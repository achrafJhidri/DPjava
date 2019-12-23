package jhidri.maladroit.Controlleurs;

import jhidri.maladroit.Model.FabriqueCoupShifumi;
import jhidri.maladroit.Model.PartieShifumi;
import jhidri.maladroit.Model.jeu.CoupShifumi;
import jhidri.maladroit.Vue.BoutonChoixCoup;
import jhidri.maladroit.Vue.FormulaireCoupJoueur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;



/**
 * r�ponse � la requ�te "coup jou� de la part d'un des deux joueurs"
 * 
 * c'est-�-dire d�s qu'un joueurs clique un bouton repr�sentant un coup possible de shifumi,
 * 
 * cet �couteur cr�e le coup correspondant d�fini par le n� du joueur, le pseudo, la mise et le coup jou� et renseigne l'objet partieShifumi
 * dd
 * */
public class EcouteurCoupJoue implements ActionListener
{
FormulaireCoupJoueur formulaireCoupJoueur;
PartieShifumi partieShifumi;
FabriqueCoupShifumi fabriqueCoupShifumi[];
EcouteurArbitre ecouteurRejouer;

public EcouteurCoupJoue(FormulaireCoupJoueur formulaireCoupJoueur,
        PartieShifumi partieShifumi, FabriqueCoupShifumi[] fabriqueCoupShifumi,
        EcouteurArbitre ecouteurRejouer)
{
super();
this.formulaireCoupJoueur = formulaireCoupJoueur;
this.partieShifumi = partieShifumi;
this.fabriqueCoupShifumi = fabriqueCoupShifumi;
this.ecouteurRejouer = ecouteurRejouer;
}

public void init()
{

this.formulaireCoupJoueur.init(); // initialise � 0 la mise du joueur correspondant
 
for (BoutonChoixCoup bouton : this.formulaireCoupJoueur.boutons)
    bouton.addActionListener(this);
}

public void desInit()
{
for (BoutonChoixCoup bouton : this.formulaireCoupJoueur.boutons) bouton.removeActionListener(this);
}


@Override
public void actionPerformed(ActionEvent e)
{
try
    {
    BoutonChoixCoup boutonChoixCoup = (BoutonChoixCoup)e.getSource();
    
    int i = boutonChoixCoup.i; // i indique quel coup a �t� jou� : pierre, feuille, ciseaux, etc.
    
    // cr�e le coup jou�
    
    CoupShifumi coupShifumi = fabriqueCoupShifumi[i].creeCoupShifumi( this.formulaireCoupJoueur.getPseudo() ,
                                                                     this.formulaireCoupJoueur.getMiseJouee(),
                                                                     this.partieShifumi.mediateur);
    
    // renseigne la partie gr�ce au n� du joueur contenu dans le formulaire
    
    this.partieShifumi.coupShifumi[formulaireCoupJoueur.numeroJoueur] = coupShifumi;
    
    this.desInit(); // on d�sactive cet �couteur
    
    int autreJoueur = (formulaireCoupJoueur.numeroJoueur+1)%2;
    
    if (this.partieShifumi.coupShifumi[autreJoueur] != null) // l'autre joueur avait d�j� jou� avant celui-ci
       this.ecouteurRejouer.init();                             // on active l'�couteur du bouton Rejouer
    }
catch (NumberFormatException e1)
    {
    javax.swing.JOptionPane.showMessageDialog(formulaireCoupJoueur, "mise jou�e invalide", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
    }
   
}

}
