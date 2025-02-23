import java.util.Iterator;
import java.io.*;

public class BrowserNavigation implements Iterable<String> {
    //stack dedicated for previous pages you've visited everytime you visit a new page
    private BrowserStack<String> backStack;
    //stack dedicate for "next" pages you've visited after going back to a previous page
    //cleared when visitng a new website because it starts a new pathway
    private BrowserStack<String> forwardStack; 
    //queue for history pages, no need to go back or forward
    private BrowserQueue<String> historyQueue;
    private String websiteUrl; 
    private static String SESSION_STORAGE_FILE = "session_data.txt"; 

    public BrowserNavigation() {
        backStack = new BrowserStack<>();
        forwardStack = new BrowserStack<>();
        historyQueue = new BrowserQueue<>();    
        websiteUrl = null; 
    }

    public String visitWebsite(String url) {
        if (websiteUrl != null) {
            backStack.push(websiteUrl); 
        }
        websiteUrl = url; 
        historyQueue.enqueue(url);
        forwardStack.cleanList();
        return ("You are currently visiting" + url); 
    }

    public String goBack() {
        if (backStack.isEmpty()) {
            return ("There are no previous pages to visit.");
        }
        forwardStack.push(websiteUrl);
        websiteUrl = backStack.pop();
        return ("You are currently visiting" + websiteUrl); 
    }

    public String goingForward() {
        if (forwardStack.isEmpty()) {
            return ("There are no forward pages to visit.");
        }
        backStack.push(websiteUrl);
        websiteUrl = forwardStack.pop();
        return ("You are currently visiting" + websiteUrl);
    }

    public String showHistory() {
        if (historyQueue.isEmpty()) {
            return ("There is no history to show.");
        }
        StringBuilder history = new StringBuilder();
        for (String url : historyQueue) {
            history.append(url).append("\n");
        }
        return history.toString();
    }

    public String clearHistory() {
        historyQueue.cleanQueue();
        return ("History has been cleared.");
    }

    public String closeBrowser() {
        try (ObjectOutputStream fileObj = new ObjectOutputStream(new FileOutputStream(SESSION_STORAGE_FILE))) {
            fileObj.writeObject(backStack);      
            fileObj.writeObject(forwardStack);  
            fileObj.writeObject(historyQueue);   
            fileObj.writeObject(websiteUrl);    
            return "Browser session saved successfully.";
        } catch (IOException e) {
            return "Error saving browser session: " + e.getMessage();
        }
    }

    public String restoreLastSession() {
        File fileObj = new File(SESSION_STORAGE_FILE);
        if (!fileObj.exists()) {
            return "No previous session found.";
        }
        try (ObjectInputStream prevFileObj = new ObjectInputStream(new FileInputStream(SESSION_STORAGE_FILE))) {
            backStack = (BrowserStack<String>) prevFileObj.readObject();
            forwardStack = (BrowserStack<String>) prevFileObj.readObject();
            historyQueue = (BrowserQueue<String>) prevFileObj.readObject();
            websiteUrl = (String) prevFileObj.readObject();
            if (websiteUrl != null) {
                return "Previous session restored.You are currently visiting " + websiteUrl;
            } else {
                return "Previous session restored";
            }
        } catch (IOException | ClassNotFoundException e) {
            return "Error restoring session: " + e.getMessage();
        }
    }

    public void printState() {
        if (websiteUrl != null) {
            System.out.println("Current Page: " + websiteUrl);
        } else {
            System.out.println("Current Page: No page");
        }
        System.out.print("Back Stack: ");
        backStack.printStack();
        System.out.print("Forward Stack: ");
        forwardStack.printStack();
        System.out.print("History: ");
        historyQueue.printQueue();
    }
}