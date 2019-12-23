package jhidri;

import java.awt.event.MouseEvent;

public class SecondPointController extends StateController {
    public SecondPointController(CadreCreationSegment ui, StateController next, StateController previous) {
        super(ui, next, previous);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

    }


    @Override
    public void mousePressed(MouseEvent event) {
        if(event.getButton() == MouseEvent.BUTTON1){
            userInterface.segment.setB(event.getX(),event.getY());
        }


    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if(event.getButton() == MouseEvent.BUTTON1){
            userInterface.op�rationEnCours.setText("Cr�ation termin�e. Enfoncez bouton droit souris pour retour au d�but");
            userInterface.canvas.paint();
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
