package cor;

import tools.GroupeInvalideException;
import verbs.Verbe;
import tools.GroupVerbException;

public interface Createur {
    /**
     *
     * @param infinitif : exemple manger
     * @return
     * @throws GroupVerbException
     */
    Verbe parse(String infinitif) throws GroupVerbException, GroupeInvalideException;
}
