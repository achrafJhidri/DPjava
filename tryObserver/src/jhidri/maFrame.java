package jhidri;


import jhidri.Femme;
import jhidri.Observateur;
import jhidri.Observu;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class maFrame extends Frame implements Observateur {

    public maFrame(String title,int x,int y){
        super(title);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(x,y,dimension.getWidth()/3,dimension.getHeight()/2);

        setResizable(false);

        setLayout(new GridLayout(20,1));


        addLine();


        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void addLine() {
        Panel p = new Panel();

        p.setLayout(new GridLayout(1,3));
        p.add(new Label("prenom"));
        p.add(new Label("date de naissance"));
        p.add(new Label("sexe"));
        add(p);
    }

    private void setBounds(int x, int y, double v, double v1) {
        setBounds(x,y,(int) v,(int) v1);
    }

    private void addLine(Personne personne) {
        Panel p = new Panel();

        p.setLayout(new GridLayout(1,3));
        p.add(new Label(personne.getPrenom()));
        p.add(new Label((""+personne.getAnneeNaissance())));
        p.add(new Label(personne.getSexe() ));
        add(p);
    }

    @Override
    public void update(Observu observable, Object o) {
        Personne p = (Personne) o;
        if(1900  <= p.getAnneeNaissance() && p.getAnneeNaissance() <= 1999 )
        {
            addLine(p);

            setVisible(true);
        }
    }


}
