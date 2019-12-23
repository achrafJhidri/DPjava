package exo_shifumi_mediator.vues;

import jhidri.maladroit.Vue.BoutonChoixCoup;

public class TestCadreShifumi
{

public TestCadreShifumi()
{
// TODO Auto-generated constructor stub
}

public static void main(String[] args)
{
String labelsBoutons [] = new String[]{"Pierre", "Feuille","Ciseaux"};
BoutonChoixCoup.CadreShifumi cadreShifumi = new BoutonChoixCoup.CadreShifumi("jeu de shifumi classique", labelsBoutons);
cadreShifumi.formulaireCoupJoueur0.init();
cadreShifumi.formulaireCoupJoueur1.init();
cadreShifumi.setVisible(true);

}

}
