package DesignPatterns.BehavioralPatterns.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * MEDIATOR PATTERN
 * <p>
 * Intent:
 * Mediator is a behavioral design pattern that lets you reduce chaotic dependencies
 * between objects. The pattern restricts direct communications between the objects
 * and forces them to collaborate only via a mediator object.
 * <p>
 * Problem it solves:
 * As an application evolves, you might have many objects communicating with each other
 * directly. This creates a complex web of dependencies (tight coupling), making the code
 * hard to maintain, test, and reuse.
 * <p>
 * How it works:
 * - Mediator Interface: Declares methods for communication with components. (e.g., ChatMediator)
 * - Concrete Mediator: Encapsulates the relations between various components. It keeps
 * references to all components it manages and coordinates their communication. (e.g., ChatRoom)
 * - Components (Colleagues): Various classes that contain business logic. Each component has
 * a reference to its mediator. Instead of calling other components directly, they send
 * messages to the mediator, which routes them appropriately. (e.g., User, ChatUser)
 * <p>
 * Benefits:
 * - Single Responsibility Principle: Extracts the communication logic into a single place.
 * - Open/Closed Principle: You can introduce new mediators without changing the actual components.
 * - Reduces Coupling: Replaces many-to-many relationships between components with one-to-many
 * relationships between the mediator and the components.
 */

// 1. Mediator Interface
interface ChatMediator {
    void sendMessage(String msg, User user);

    void addUser(User user);
}

// 2. Concrete Mediator
class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User user) {
        // Send message to all users EXCEPT the one who sent it
        for (User u : this.users) {
            if (u != user) {
                u.receive(msg);
            }
        }
    }
}

// 3. Component (Colleague)
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }

    public abstract void send(String msg);

    public abstract void receive(String msg);
}

// 4. Concrete Component
class ChatUser extends User {

    public ChatUser(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(this.name + " -> Sending Message: " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + " <- Received Message: " + msg);
    }
}

public class MediatorPatternExampleOne {
    public static void main(String[] args) {
        System.out.println("--- Mediator Pattern: Chat Room Example ---");

        // Create the Mediator
        ChatMediator chatMediator = new ChatRoom();

        // Create Components (Users)
        User user1 = new ChatUser(chatMediator, "Alice");
        User user2 = new ChatUser(chatMediator, "Bob");
        User user3 = new ChatUser(chatMediator, "Charlie");
        User user4 = new ChatUser(chatMediator, "Dave");

        // Register Users to the Mediator
        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user3);
        chatMediator.addUser(user4);

        // Users communicate via the Mediator, NOT directly with each other
        user1.send("Hi Everyone!");
        System.out.println("--------------------");
        user3.send("Hey Alice, how are you?");
    }
}
