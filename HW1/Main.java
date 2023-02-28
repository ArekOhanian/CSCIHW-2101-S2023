package HW1;

import java.io.ObjectOutput;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start of Main");
        // Create an instance of the Pyramid class and call the Output method (see Pyramid.java for more info)
        Pyramid p=new Pyramid();
        p.Output();
        // Create an instance of the Adlibs class and call the story method (see Adlibs.java for more info)\
        Adlibs s=new Adlibs();
        s.story("Arek", 19, "Green");
        String story = "Hello! my name is " + s.name + ", and I am " + s.age + ", and my favorite color is "+ s.favoriteColor;
        System.out.println(story);
        // Create an instance of the Replace class and call the charReplace method (see Replace.java for more info)

    }
}
