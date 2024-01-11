/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javateaching.layoutmanagers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 
 */
public class ConstructorDemo {

    public ConstructorDemo(String msg)
    {
        System.out.println("I've been constructed with "+msg);
    }

    public ConstructorDemo()
    {
        this("a default value");
    }

    public static void main(String[] args)
    {
        //ConstructorDemo z = new ConstructorDemo();
        //ConstructorDemo x = new ConstructorDemo(" an elephant in a bun");
        File file = new File("test.txt");
        // original FileReader only code
        try
        {
            BufferedReader bufInput1 =
                       new BufferedReader(new FileReader(file));
            String str = bufInput1.readLine();
            while (str != null)
            {
                //students.add(new Student(str));
                ConstructorDemo c = new ConstructorDemo(str);
                str = bufInput1.readLine();
               
            }
            bufInput1.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        /*
        try {
            InputStreamReader reader =
                    new InputStreamReader(new FileInputStream("myfile.txt"), "UTF-8");
            BufferedReader bufInput1 = new BufferedReader(reader);
        } catch (FileNotFoundException ex) {
           // do nothing
        } catch (UnsupportedEncodingException ex)
        {
            // do nothing
        }
         */
    }

}
