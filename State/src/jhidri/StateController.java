package jhidri;

import java.awt.event.MouseEvent;

public abstract class StateController {
    public CadreCreationSegment userInterface;
    public StateController nextState;
    public StateController previousState;


    public StateController(CadreCreationSegment ui,StateController next,StateController previous){
        userInterface   = ui ;
        nextState       = next;
        previousState   = previous;
    }

    public abstract void mouseDragged(MouseEvent event);
    public  void mouseMoved(MouseEvent event){
        userInterface.composantCoordonnées.setX(event.getX());
        userInterface.composantCoordonnées.setY(event.getY());
    };
    public abstract void mousePressed(MouseEvent event);
    public abstract void mouseReleased(MouseEvent event) ;
    public abstract void mouseClicked(MouseEvent event);
    public abstract void mouseEntered(MouseEvent event);
    public abstract void mouseExited(MouseEvent event);

}
