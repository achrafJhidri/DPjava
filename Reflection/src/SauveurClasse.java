import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


class SauveurClasse {


    static void sauve(Object objet, String fileName) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        File file = new File("");
        String absolutePath = file.getAbsolutePath()+File.separatorChar+"docs";
        FileWriter output = new FileWriter(absolutePath+File.separatorChar+fileName+".txt");

        Class <?> c = objet.getClass();
        String className = c.toString().split(" ")[1]; // class A => get A


        output.write("Donnée pour construire "+className+" \n");
        output.append(className).append("\n");

        int i = 1 ;
        for(Field field : c.getDeclaredFields()){
            String fieldName = getClassSimpleName(field);// get the java.lang.reflect.Field  => returns Field
            String camelCaseFieldName = toCamelCase(fieldName); // turn field to Field
            String line = fieldName+" = " ;
            Object obj = c.getMethod("get"+camelCaseFieldName,null).invoke(objet);
            if ( field.getType().isPrimitive() )
                 output.append( line+obj+"\n");
            else
            {
                String childFileName ="my"+field.getType().getName()+i++;
                sauve(obj,childFileName);
                output.append(line+childFileName);
            }

        }

        output.close();
    }

    private static String toCamelCase(String fieldName) {
        return fieldName.toUpperCase().charAt(0)+fieldName.substring(1);
    }

    private static String getClassSimpleName(Field field) {
        int lastIndexOfPoint =  field.toString().lastIndexOf('.');
        return field.toString().substring(lastIndexOfPoint+1);
    }
}
