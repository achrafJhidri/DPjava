package jhidri;

import java.awt.*;
import java.awt.event.*;


/**
 * Composant responsable de la création  interactive d'un segment. Dans cette version deux modes de création sont disponibles.
 * Le 1er mode consiste à désigner successivement, en cliquant à chaque fois le bouton gauche de souris, 
 * les deux extrémités du segment.
 * Le 2ème mode consiste à désigner la 1ère extrémité du segment en enfonçant le bouton gauche 
 * puis à désigner la 2ème extrémité en relâchant le bouton gauche. 
 * L'utilisateur doit donc déplacer la souris avec le bouton gauche enfoncé (dragging the mouse = littéralement : en traînant la souris)
 * à chaque instant de ce déplacement, l'appli trace le segment  
 * 
 * */
public class CadreCreationSegment extends Frame implements MouseListener, MouseMotionListener
{

public MonCanvas canvas; // pour dessiner dessus
public Segment segment;     // le segment à créer

/* les composants graphiques de l'appli */

public TextField résultat, opérationEnCours; Label labelPrésentation, labelRésultat, labelGuide;
public ComposantCoordonnées composantCoordonnées;
public Panel panelNord, panelSud, panelSudHaut, panelSudBas; 


/* les contrôleurs d'état : il en faut autant que d'états dans le diagramme + le contrôleur courant */
    public StateController currentController ;
    public FirstPointController firstState;
    public SecondPointController secondState;
    public FinalController lastState;

/* à compléter ...*/

    /**
     * @param event
     * @throws HeadlessException
     */
    public CadreCreationSegment(String event) throws HeadlessException
    {
    super(event);
    Outils.place(this, 0.25, 0.25, 0.6, 0.6); // positionne et dimensionne la fenêtre this
    
    /* placement des composants GUI */
    
    
    this.setBackground(Color.LIGHT_GRAY);
    this.add(new Label(" "), BorderLayout.WEST);
    this.add(new Label(" "), BorderLayout.EAST);
    this.panelNord = new Panel(); this.add(this.panelNord,BorderLayout.NORTH);
    this.labelPrésentation = new Label("Création interactive d'un segment");this.panelNord.add(this.labelPrésentation);
    
    /* à présent le composant pour afficher les coordonnées du pointeur de souris */
    
    this.composantCoordonnées = new ComposantCoordonnées("pointeur de souris");
    this.panelNord.add(this.composantCoordonnées);
    
    this.canvas = new MonCanvas(this);this.add(this.canvas,BorderLayout.CENTER);
    this.canvas.setBackground(Color.WHITE);
    
    /* installation du panneau sud */
    
    this.panelSud = new Panel();  this.add(this.panelSud,BorderLayout.SOUTH);
    this.panelSud.setLayout(new GridLayout(3,1));
    //this.panelSudHaut = new Panel(); this.panelSud.add(this.panelSudHaut);
 
    this.labelGuide = new Label("opération en cours :");this.panelSud.add(this.labelGuide);
    this.opérationEnCours = new TextField("Enfoncez bouton gauche pour fixer 1er point",100); this.opérationEnCours.setEditable(false);
    this.panelSud.add(this.opérationEnCours);
    this.panelSudBas = new Panel(); this.panelSud.add(this.panelSudBas);
    this.labelRésultat = new Label("segment créé");this.panelSudBas.add(this.labelRésultat);
    this.résultat = new TextField("",16); this.résultat.setEditable(false);this.panelSudBas.add(this.résultat);
    
    /* installation du diagramme de transition d'états */
    
    installeContrôleurs();
    
    this.canvas.addMouseListener(this);
    this.canvas.addMouseMotionListener(this);
    
    /* crée le segment dégénéré [(0,0) (0,0)] */
    this.segment = new Segment();
    segment=new Segment();

    /* les 3 instructions suivantes constituent un exemple qui ne doit plus figurer dans l'appli définitive */

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    
    /* installation du diagramme de transition d'états : c-à-d met en place les contrôleurs et les relie entre eux */
    private void installeContrôleurs()
    {

    /* création des contrôleurs avec leur liens "successeurs" */
    
        firstState = new FirstPointController(this,null,null);
        secondState = new SecondPointController(this,null,firstState);
        lastState = new FinalController(this,firstState,null);
    
    /* installation des liens "prédécesseur" */

        firstState.nextState=secondState;
        secondState.nextState=lastState;


        currentController=firstState;
    } //installeContrôleurs

    

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
    
    
    /* -------------------- Il est inutile de gérer les événements suivants -------------------------- */
    
    
    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent event) {/* rien à faire */}
    
    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseEntered(MouseEvent event){/* rien à faire */}
    
    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseExited(MouseEvent event){/* rien à faire */}


    public void reset() {

        canvas.getBufferStrategy().getDrawGraphics().setColor(Color.white);
    }
}
