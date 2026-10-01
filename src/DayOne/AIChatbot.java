package DayOne;
import java.util.Scanner;
public class AIChatbot {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("          AI CHATBOT");
        System.out.println("======================================");
        System.out.println("Hello! I am your Java AI Chatbot.");
        System.out.println("Type 'bye' to exit.");
        System.out.println();

        while (true) {

            System.out.print("You: ");
            String input = sc.nextLine().toLowerCase().trim();

            // Exit
            if (input.equals("bye")
                    || input.equals("exit")
                    || input.equals("quit")) {

                System.out.println("Bot: Goodbye! Have a great day.");
                break;
            }

            String response = getResponse(input);

            System.out.println("Bot: " + response);
            System.out.println();
        }

        sc.close();
    }

    // Rule-based response system
    public static String getResponse(String input) {

        // Greeting
        if (input.contains("hello")
                || input.contains("hi")
                || input.contains("hey")) {

            return "Hello! How can I help you?";
        }

        // Name
        if (input.contains("your name")) {

            return "My name is Java AI Chatbot.";
        }

        // How are you
        if (input.contains("how are you")) {

            return "I am doing great! Thanks for asking.";
        }

        // Java
        if (input.contains("java")) {

            return "Java is a popular object-oriented programming language.";
        }

        // Internship
        if (input.contains("internship")) {

            return "An internship helps students gain practical experience.";
        }

        // Programming
        if (input.contains("programming")
                || input.contains("coding")) {

            return "Programming is the process of creating instructions for computers.";
        }

        // OOP
        if (input.contains("oop")
                || input.contains("object oriented")) {

            return "OOP stands for Object-Oriented Programming. Its main concepts include Encapsulation, Inheritance, Polymorphism and Abstraction.";
        }

        // DSA
        if (input.contains("dsa")
                || input.contains("data structure")) {

            return "DSA stands for Data Structures and Algorithms. It helps us solve programming problems efficiently.";
        }

        // College
        if (input.contains("college")) {

            return "College is a great place to learn technical and professional skills.";
        }

        // Help
        if (input.contains("help")) {

            return "You can ask me about Java, programming, OOP, DSA or internships.";
        }

        // Thank you
        if (input.contains("thank")
                || input.contains("thanks")) {

            return "You're welcome!";
        }

        // Good morning
        if (input.contains("good morning")) {

            return "Good morning! Have a productive day.";
        }

        // Good night
        if (input.contains("good night")) {

            return "Good night! See you again.";
        }

        // Unknown question
        return "Sorry, I don't understand that yet. Try asking about Java, DSA, OOP or programming.";
    }
}