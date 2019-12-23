package jhidri;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.nio.Buffer;


/**
 * représente "la feuille de papier" sur laquelle les dessins sont effectués
 */
public class MonCanvas extends Canvas {
    CadreCreationSegment cadre;
    BufferStrategy buffer;

    /**
     * @param cadre
     */
    public MonCanvas(CadreCreationSegment cadre) {
        this.cadre = cadre;
        setIgnoreRepaint(true);
        createBufferStrategy(1);
        buffer = this.getBufferStrategy();
    }

    /* (non-Javadoc)
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */

    public void paint() {
// à définir
// l'instruction suivante n'est qu'un exemple à remplacer par le code adéquat

        buffer.getDrawGraphics().setColor(Color.black);
        buffer.getDrawGraphics().drawLine(cadre.segment.A.x, cadre.segment.A.y, cadre.segment.B.x, cadre.segment.B.y);
    }

    public void clear() {
        buffer.getDrawGraphics().clearRect(0, 0, getBounds().width, getBounds().height);
    }


}
