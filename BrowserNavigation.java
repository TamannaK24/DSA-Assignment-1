import java.io.*;

public class BrowserNavigation {
    //stack dedicated for previous pages you've visited everytime you visit a new page
    private BrowserStack<String> backStack;
    //stack dedicate for "next" pages you've visited after going back to a previous page
    //cleared when visitng a new website because it starts a new pathway
    private BrowserStack<String> forwardStack; 
    //queue for history pages, no need to go back or forward
    private BrowserQueue<String> historyQueue;
    private String websiteUrl; 
    private static String SESSION_STORAGE_FILE = "session_data.txt"; 

    //ties together the entire navigation system between brwoser pages
    // initializes a backstack, forwardstack, and histroyqueuee
    public BrowserNavigation() {
        backStack = new BrowserStack<>();
        forwardStack = new BrowserStack<>();
        historyQueue = new BrowserQueue<>();    
        websiteUrl = null; 
    }

    //if website url exists, adds to backstack and returns the website that currently is display
    //adds website to history queue
    public String visitWebsite(String url) {
        if (websiteUrl != null) {
            backStack.push(websiteUrl); 
        }
        websiteUrl = url; 
        historyQueue.enqueue(url);
        forwardStack.cleanList();
        return ("You are currently visiting" + url); 
    }

    //if backstack empty aka no previous pages access, reuturns message
    //if not empty, remove from forward stack and add it back stack, display the current url
    public String goBack() {
        if (backStack.isEmpty()) {
            return ("There are no previous pages to visit.");
        }
        forwardStack.push(websiteUrl);
        websiteUrl = backStack.pop();
        return ("You are currently visiting" + websiteUrl); 
    }

    //checks if there are pages in forwardstack to go forward to
    //if so, removes from backstack, adding to forward stack and dislaying it as current url
    public String goForward() {
        if (forwardStack.isEmpty()) {
            return ("There are no forward pages to visit.");
        }
        backStack.push(websiteUrl);
        websiteUrl = forwardStack.pop();
        return ("You are currently visiting" + websiteUrl);
    }

    //checks if history is there
    //if so, loops through history queue and displays each url
    //uses stringbuilder because memory efficient
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

    //clears history queue
    public String clearHistory() {
        historyQueue.cleanQueue();
        return ("History has been cleared.");
    }

    //try with resources to write to file
    //writes backstack, forwardstack, historyqueue, and websiteurl to file
    //if error, returns error message
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

    //checks if previous file exists
    //try with resources to read from file
    //reads backstack, forwardstack, historyqueue, and websiteurl from file
    //if current website is present from past session, start there
    //if not, just restore the session
    //if error, returns error message
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

    //prints the current state of the browser
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