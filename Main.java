import java.util.Scanner;

// main method
public class Main {
    public static void main(String[] args) {
        // creating new browser navigation object and scanner object
        BrowserNavigation browser = new BrowserNavigation();
        Scanner scanner = new Scanner(System.in);
        
        // welcome message and options
        System.out.println("Welcome to the Browser Navigation System!");
        System.out.println("options:");
        System.out.println("1. visit website");
        System.out.println("2. go back");
        System.out.println("3. go forward");
        System.out.println("4. show history");
        System.out.println("5. clear history");
        System.out.println("6. close browser (save session)");
        System.out.println("7. restore last session");
        System.out.println("8. exit");

        //inifnite loop unless broken by user selecting close brwoser or exit
        while (true) {
            System.out.print("\nenter your choice (1-8): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("enter URL: ");
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
                    System.out.println("exiting the browser...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("invalid choice! please enter a number between 1 and 8.");
            }
        }
    }
}