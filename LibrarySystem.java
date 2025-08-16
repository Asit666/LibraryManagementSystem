import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    private static String isbn;
    private static String author;
    private static String title;
    private static boolean notgood;
    private static String search;
    private Object b;

    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);
        ArrayList<Books> books = new ArrayList<>();

        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Welcome to the Library Managment System--------->");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Remove book");
            System.out.println("4. Search Book");
            System.out.println("5. Exit");
            System.out.println("--------------------------------------------------");
            
            String opt = A.nextLine();

            
            if (opt.equals("1"))
            {
                
                while (notgood = true) {
                System.out.print("Enter Book Title: ");
                title = A.nextLine().trim();
                    
                if(!title.isEmpty()){
                System.out.print("Enter Book Author: ");
                author = A.nextLine().trim();

                if(!author.isEmpty()){
                System.out.print("Enrter Book ISBN: ");
                isbn = A.nextLine().trim();

                if(!isbn.isEmpty()){
                books.add(new Books( title , author , isbn , true));
                System.out.println("Book added successfully!");break;}else{System.out.println("Try again");notgood = true; continue; }

                }else{System.out.println("Try again");notgood = true; continue; }

                } else{System.out.println("Try again"); notgood = true; continue; }}

            }

            else if (opt.equals("2"))
            {
                if(!books.isEmpty())   
                {
                    System.out.println("--------------------Available books--------------------" );
                    for (Books b : books)
                    {
                        System.out.println(b);
                    }

                }else if (books.isEmpty()){System.out.println("no books is added yet");continue;}       
            
            }

            else if (opt.equals("3"))
            {
                if(!books.isEmpty())
                {
                    System.out.println("Enter the ISBN of the book you want to remove: ");
                    String removeISBN = A.nextLine().trim();
                    for (Books b : books)
                    {
                        if(b.isbn.equals(removeISBN))
                        {
                            books.remove(removeISBN);
                            System.out.println("Book removed successfully!");
                            break;
                        }else if(!b.isbn.equals(removeISBN)) {System.out.println("Book not found");}
                    }
                }else if (books.isEmpty()){System.out.println("no books is added yet" );}
            }

            else if (opt.equals("4"))
            {
                if(!books.isEmpty())
                {
                    System.out.println("Enter the ISBN of the book you want: ");
                    search = A.nextLine().trim();
                    
                        boolean found = false;
                        for (Books b : books) {
                            if (b.isbn.equals(search)) {
                                System.out.println("Book found: " + b);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Book not found, try again----->");
                        }
                    
                }else if (books.isEmpty()){System.out.println("no books is added yet");}
            }
        }

    }
    
}


class Books {
    String title;
    String author;
    String isbn;
    boolean isavailable;

    public Books (String title, String author, String isbn, boolean isavailable)
    {

        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public String toString()
    {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Available: ";
    }
}