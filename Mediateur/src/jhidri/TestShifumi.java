package jhidri;



import jhidri.maladroit.Controlleurs.EcouteurArbitre;
import jhidri.maladroit.Controlleurs.EcouteurCoupJoue;
import jhidri.maladroit.Model.*;
import jhidri.maladroit.Model.jeu.Mediateur;
import jhidri.maladroit.Vue.BoutonChoixCoup;
import outilsvues.EcouteurTerminaison;

public class TestShifumi
{

public static void main(String[] args)
{



PartieShifumi partieShifumi = new PartieShifumi();



    FabriqueCoupShifumi fabriqueCoupShifumi[] = new FabriqueCoupShifumi[] {
            new FabriqueCoupShifumiPierre(partieShifumi.mediateur),
            new FabriqueCoupShifumiFeuille(partieShifumi.mediateur),
            new FabriqueCoupShifumiCiseaux(partieShifumi.mediateur),
            new FabriqueCoupShifumiPuit(partieShifumi.mediateur)
    };



String labelsBoutons [] = new String[fabriqueCoupShifumi.length];

int i;
for (i = 0; i < fabriqueCoupShifumi.length; ++i) labelsBoutons[i] = fabriqueCoupShifumi[i].toString(); //{"Pierre", "Feuille","Ciseaux"};

BoutonChoixCoup.CadreShifumi cadreShifumi = new BoutonChoixCoup.CadreShifumi("jeu de shifumi classique. Version � am�liorer � l'aide du DP Mediator", labelsBoutons);

EcouteurTerminaison ecouteurTerminaison = new EcouteurTerminaison(cadreShifumi);

cadreShifumi.setVisible(true);

EcouteurArbitre ecouteurRejouer = new EcouteurArbitre(cadreShifumi.panneauResultat,partieShifumi,null, null);
EcouteurCoupJoue ecouteurCoupJoue0 = new EcouteurCoupJoue(cadreShifumi.formulaireCoupJoueur0, partieShifumi, fabriqueCoupShifumi, ecouteurRejouer);
EcouteurCoupJoue ecouteurCoupJoue1 = new EcouteurCoupJoue(cadreShifumi.formulaireCoupJoueur1, partieShifumi, fabriqueCoupShifumi, ecouteurRejouer);
ecouteurRejouer.ecouteurCoupJoue0 = ecouteurCoupJoue0;
ecouteurRejouer.ecouteurCoupJoue1 = ecouteurCoupJoue1;
ecouteurCoupJoue0.init();
ecouteurCoupJoue1.init();
}

}
