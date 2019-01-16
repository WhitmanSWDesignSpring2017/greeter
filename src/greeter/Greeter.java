/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greeter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * From Horstmann's "A Crash Course from C++ to Java",
 * modified to solve exercises 1, 3, 11, 14, 17, and 21.
 * See also the in-class lab "Hello world!":
 *   https://canvas.instructure.com/courses/1505731/assignments/10425429
 * @author Janet Davis
 */
public class Greeter {
    
    /**
     * Creates a new Greeter.
     * @param aName The name of the entity to greet.
     */
    public Greeter(String aName) 
    {
        name = aName;
    }
    
    /**
     * Changes the name of the entity to greet.
     * @param aName A new name.
     */
    public void setName(String aName)
    {
        name = aName;
    }
    
    /**
     * Produces a greeting message using the entity's name.
     * @return A greeting.
     */
    public String sayHello()
    {
        return "Hello, " + name + "!";
    }
    
    /**
     * Produces a farewell message using the entity's name.
     * @return A farewell.
     */
    public String sayGoodbye()
    {
        return "Goodbye, " + name + "!";
    }
    
    /**
     * Swaps entity names with another Greeter.
     * @param other Another greeter.
     */
    public void swapNames(Greeter other)
    {
        String temp = this.name;
        this.name = other.name;
        other.name = temp;
    }
    
    private String name;

    /**
     * Greets entities named on the command line. 
     * If none are given, requests a name from the user.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        if (args.length > 0)
        {
            if (args[0].equals("null")) {
                Greeter greeter = null;
                System.out.println(greeter.sayHello());
            }
            for (int i = 0; i < args.length; i++)
            {
                Greeter greeter = new Greeter(args[i]);
                System.out.println(greeter.sayHello());
            }
        }
        else
        {
            BufferedReader console = new BufferedReader(
                new InputStreamReader(System.in));
            System.out.print("What's your name? ");
            String input;
            try {
                input = console.readLine();
            } catch (IOException ex) {
                input = null;
            }
            Greeter greeter = new Greeter(input);
            System.out.println(greeter.sayHello());
        }
    }   
}
