package jhidri;


import java.awt.event.MouseEvent;

public class FirstPointController extends StateController {
    public FirstPointController(CadreCreationSegment ui, StateController next, StateController previous) {
        super(ui, next, previous);
    }



    @Override
    public void mouseDragged(MouseEvent event) {

        userInterface.canvas.clear();
        userInterface.segment.setB(event.getX(),event.getY());
        userInterface.canvas.paint();

    }



    @Override
    public void mousePressed(MouseEvent event) {
        if(event.getButton() == MouseEvent.BUTTON1){
            userInterface.segment.setA(event.getX(),event.getY());
        }


    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if(event.getButton() == MouseEvent.BUTTON1){
            userInterface.opérationEnCours.setText("Enfoncez bouton gauche pour fixer 2ème point. Enfoncez bouton droit souris pour retour");
            userInterface.currentController=this.nextState;
        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {


    }

    @Override
    public void mouseEntered(MouseEvent event) {

    }

    @Override
    public void mouseExited(MouseEvent event) {

    }
}
