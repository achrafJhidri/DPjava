package jhidri;

import java.awt.event.MouseEvent;

public class FinalController extends StateController{
    public FinalController(CadreCreationSegment ui, StateController next, StateController previous) {
        super(ui, next, previous);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

    }



    @Override
    public void mousePressed(MouseEvent event) {
        if(event.getButton() == MouseEvent.BUTTON3){
            userInterface.segment = new Segment();
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {

        if(event.getButton() == MouseEvent.BUTTON3){
           userInterface.canvas.clear();
           userInterface.opérationEnCours.setText("Enfoncez bouton gauche pour fixer 1er point");
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
