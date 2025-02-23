import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BrowserNavigation browser = new BrowserNavigation();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Browser Navigation System!");
        System.out.println("Options: \n1. Visit Website \n2. Go Back \n3. Go Forward \n4. Show History \n5. Clear History \n6. Close Browser (Save Session) \n7. Restore Last Session \n8. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice (1-8): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter URL: ");
                    String url = scanner.nextLine();
                    System.out.println(browser.visitWebsite(url));
                    break;
                
                case 2:
                    System.out.println(browser.goBack());
                    break;
                    
                case 3:
                    System.out.println(browser.goForward()); 
                    break;
                    
                case 4:
                    System.out.println(browser.showHistory());
                    break;
                    
                case 5:
                    System.out.println(browser.clearHistory());
                    break;
                    
                case 6:
                    System.out.println(browser.closeBrowser());
                    break;
                    
                case 7:
                    System.out.println(browser.restoreLastSession());
                    break;
                    
                case 8:
                    System.out.println("Exiting the browser...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 8.");
            }
        }
    }
}