package com.company;

// Q: What is a package?
    // 9 million Java developers --> class/interface name conflicts will happen
    // need a mechanism to allow use of classes wth the same name in the same project or even class
    // way of grouping related classes and interfaces together
    // manage name spaces and offers more access protection

// importing package
// type in actual package name

// using same types in the same class -> need to type actual package name for one

// Q: Why use packages?
    // determine that classes are related
    // easy to know where to find classes and interfaces that can provide functions provided by the package
    // package creates a new namespace --> avoid name conflicts
    // classes within a package have unrestricted access to one another --> restrict access for classes outside the package

//import javafx.scene.Node;
import org.w3c.dom.Node;
//
public class Main {

    public static void main(String[] args) {
//	    javafx.scene.Node node = null;
//      org.w3c.dom.Node anotherNode = null;

        // we can't use both Nodes here when importing both Nodes
            // import one Node
            // specify package name as type for the other

        Node node = null;
        javafx.scene.Node anotherNode = null; // fully qualified
    }
}
