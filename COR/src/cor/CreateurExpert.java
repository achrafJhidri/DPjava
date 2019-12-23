package cor;

import tools.GroupeInvalideException;
import verbs.Verbe;
import tools.GroupVerbException;



public abstract class CreateurExpert implements Createur{
    protected CreateurExpert next ;


    protected CreateurExpert(CreateurExpert next ){
        this.next = next ;
    }

    @Override
    public Verbe parse(String infinitif)  {

           try {
               return parse2(infinitif);
           }
           catch (GroupVerbException e  )
           {
                  if (this.next != null)
                    return this.next.parse(infinitif);
                  else
                    throw new GroupVerbException("groupe du verbe invalide");
           }
    }



    protected abstract Verbe parse2(String v ) ;




}
