package examples;

import java.util.Scanner;

class ChatBot {
    void respond(String message) {
        message = message.toLowerCase();

        if (message.contains("hello") || message.contains("hi")) {
            System.out.println("Bot: Hello! How can I help you?");
        } else if (message.contains("how are you")) {
            System.out.println("Bot: I'm good, How are you");
            
        }else if (message.contains("name")) {
            System.out.println("Bot: My name is Jarvis.");
         }else if (message.contains("time")) {
            System.out.println("Bot: I don't wear a watch, but it must be ggog time.");
        } else if (message.contains("bye")) {
            System.out.println("Bot: Goodbye! Have a nice day!");
        }else if (message.contains("role")) {
            System.out.println("Bot: My role is to help you.");
        } else {
            System.out.println("Bot: Sorry, I didn't understand that.");
        }
    }
}

public class ChatBotApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChatBot bot = new ChatBot();

        System.out.println("You can start chatting with the bot (type 'exit' to stop):");

        while (true) {
            System.out.print("You: ");
            String userInput = sc.nextLine();

            if (userInput.toLowerCase().equals("exit")) {
                System.out.println("Bot: Chat ended. See you again!");
                break;
            }


            bot.respond(userInput);
           
        }
        sc.close();
    }
}

