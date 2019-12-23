package jhidri;

import java.awt.*;
import java.awt.event.*;


/**
 * Composant responsable de la cr�ation  interactive d'un segment. Dans cette version deux modes de cr�ation sont disponibles.
 * Le 1er mode consiste � d�signer successivement, en cliquant � chaque fois le bouton gauche de souris, 
 * les deux extr�mit�s du segment.
 * Le 2�me mode consiste � d�signer la 1�re extr�mit� du segment en enfon�ant le bouton gauche 
 * puis � d�signer la 2�me extr�mit� en rel�chant le bouton gauche. 
 * L'utilisateur doit donc d�placer la souris avec le bouton gauche enfonc� (dragging the mouse = litt�ralement : en tra�nant la souris)
 * � chaque instant de ce d�placement, l'appli trace le segment  
 * 
 * */
public class CadreCreationSegment extends Frame implements MouseListener, MouseMotionListener
{

public MonCanvas canvas; // pour dessiner dessus
public Segment segment;     // le segment � cr�er

/* les composants graphiques de l'appli */

public TextField r�sultat, op�rationEnCours; Label labelPr�sentation, labelR�sultat, labelGuide;
public ComposantCoordonn�es composantCoordonn�es;
public Panel panelNord, panelSud, panelSudHaut, panelSudBas; 


/* les contr�leurs d'�tat : il en faut autant que d'�tats dans le diagramme + le contr�leur courant */
    public StateController currentController ;
    public FirstPointController firstState;
    public SecondPointController secondState;
    public FinalController lastState;

/* � compl�ter ...*/

    /**
     * @param event
     * @throws HeadlessException
     */
    public CadreCreationSegment(String event) throws HeadlessException
    {
    super(event);
    Outils.place(this, 0.25, 0.25, 0.6, 0.6); // positionne et dimensionne la fen�tre this
    
    /* placement des composants GUI */
    
    
    this.setBackground(Color.LIGHT_GRAY);
    this.add(new Label(" "), BorderLayout.WEST);
    this.add(new Label(" "), BorderLayout.EAST);
    this.panelNord = new Panel(); this.add(this.panelNord,BorderLayout.NORTH);
    this.labelPr�sentation = new Label("Cr�ation interactive d'un segment");this.panelNord.add(this.labelPr�sentation);
    
    /* � pr�sent le composant pour afficher les coordonn�es du pointeur de souris */
    
    this.composantCoordonn�es = new ComposantCoordonn�es("pointeur de souris");
    this.panelNord.add(this.composantCoordonn�es);
    
    this.canvas = new MonCanvas(this);this.add(this.canvas,BorderLayout.CENTER);
    this.canvas.setBackground(Color.WHITE);
    
    /* installation du panneau sud */
    
    this.panelSud = new Panel();  this.add(this.panelSud,BorderLayout.SOUTH);
    this.panelSud.setLayout(new GridLayout(3,1));
    //this.panelSudHaut = new Panel(); this.panelSud.add(this.panelSudHaut);
 
    this.labelGuide = new Label("op�ration en cours :");this.panelSud.add(this.labelGuide);
    this.op�rationEnCours = new TextField("Enfoncez bouton gauche pour fixer 1er point",100); this.op�rationEnCours.setEditable(false);
    this.panelSud.add(this.op�rationEnCours);
    this.panelSudBas = new Panel(); this.panelSud.add(this.panelSudBas);
    this.labelR�sultat = new Label("segment cr��");this.panelSudBas.add(this.labelR�sultat);
    this.r�sultat = new TextField("",16); this.r�sultat.setEditable(false);this.panelSudBas.add(this.r�sultat);
    
    /* installation du diagramme de transition d'�tats */
    
    installeContr�leurs();
    
    this.canvas.addMouseListener(this);
    this.canvas.addMouseMotionListener(this);
    
    /* cr�e le segment d�g�n�r� [(0,0) (0,0)] */
    this.segment = new Segment();
    segment=new Segment();

    /* les 3 instructions suivantes constituent un exemple qui ne doit plus figurer dans l'appli d�finitive */

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    
    /* installation du diagramme de transition d'�tats : c-�-d met en place les contr�leurs et les relie entre eux */
    private void installeContr�leurs()
    {

    /* cr�ation des contr�leurs avec leur liens "successeurs" */
    
        firstState = new FirstPointController(this,null,null);
        secondState = new SecondPointController(this,null,firstState);
        lastState = new FinalController(this,firstState,null);
    
    /* installation des liens "pr�d�cesseur" */

        firstState.nextState=secondState;
        secondState.nextState=lastState;


        currentController=firstState;
    } //installeContr�leurs

    

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseDragged(MouseEvent event)
    {

        currentController.mouseDragged(event);
    }
    
    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseMoved(MouseEvent event)
    {

        currentController.mouseMoved(event);
    }
    
    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(MouseEvent event)
    {

        currentController.mousePressed(event);
    }
    
    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseReleased(MouseEvent event)
    {

        currentController.mouseReleased(event);
    }
    
    
    /* -------------------- Il est inutile de g�rer les �v�nements suivants -------------------------- */
    
    
    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent event) {/* rien � faire */}
    
    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseEntered(MouseEvent event){/* rien � faire */}
    
    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseExited(MouseEvent event){/* rien � faire */}


    public void reset() {

        canvas.getBufferStrategy().getDrawGraphics().setColor(Color.white);
    }
}
