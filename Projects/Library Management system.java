import java.util.ArrayList;
import java.util.Scanner;
class Book{
    int id;
    String title;
    String author;
    boolean isAvailable;
    Member borrowedBy;
    
    public Book(int id, String title, String author, boolean isAvailable){
        this.id=id;
        this.title=title;
        this.author=author;
        this.isAvailable=isAvailable;
        this.borrowedBy = null;
    }
    
    public void displayInfo(){
        System.out.println("Book Id : " + id + " Book Title : " + title + " Book Author : " + author + " Book's Availlablity : " + isAvailable);
        if(!isAvailable && borrowedBy != null ){
            System.out.print(" , Borrowed By : " + borrowedBy.name);
        }
        System.out.println();
    }
}

class Member{
    int memberId;
    String name;
    
    public Member(int memberId, String name){
        this.memberId=memberId;
        this.name=name;
    }
    
    public void displayInfo(){
        System.out.println("Member's Id : " + memberId + " Member's Name : " + name);
    }
}

class Library{
    ArrayList<Book> books;
    ArrayList<Member> members;
    
    public Library(){
        books = new ArrayList<>();
        members = new ArrayList<> ();
    }
    
    public void addBook(Book book){
        for(Book b : books){
            if(b.id == book.id){
                System.out.println("❌  Book ID already exists. Please use a unique ID. ");
                return;
            }
        }
        books.add(book);
        System.out.println("Book added : " + book.title);
    }
    
    public void addMember(Member member){
        for(Member m : members){
            if(m.memberId == member.memberId){
                System.out.println("❌  Member ID already exists. please use a unique ID.");
                return;
            }
        }
        members.add(member);
        System.out.println("Member Added : " + member.name);
    }
    
    public void showAllBooks(){
        System.out.println("\n==== Book List ====");
        for(Book book : books){
            book.displayInfo();
        }
    }
    
    public void showAllMembers(){
        System.out.println("\n==== Member List ====");
        for(Member member : members){
            member.displayInfo();
        }
    }
    
    public void borrowBook(Scanner sc){
        System.out.print("Enter Book Id to Borrow.");
        int bookId = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter Id who is Borrowing : ");
        int memberId = sc.nextInt();
        sc.nextLine();
        
        Book targetBook = null;
        Member targetMember = null;
        
        for(Book book : books){
            if(book.id == bookId){
                targetBook = book;
                break;
            }
        }
        
        for(Member member : members){
            if(member.memberId == memberId){
                targetMember = member;
                break;
            }
        }
        
        if(targetBook == null){
            System.out.println("Book Id not found. ");
            return;
        }
        
        if(targetMember == null) {
            System.out.println("Member Id not found.");
            return;
        }
        
        if(targetBook.isAvailable) {
            targetBook.isAvailable = false;
            targetBook.borrowedBy = targetMember;
            System.out.println("Book borrowed by : " + targetMember.name);
        }else{
            System.out.println("Book is already borrowed by : " + targetBook.borrowedBy.name);
        }
    }
    
    public void returnBook(Scanner sc){
        System.out.print("Enter Book Id to Return : ");
        int bookId = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter Member Id who is returning : ");
        int memberId = sc.nextInt();
        sc.nextLine();
        
        Book targetBook = null;
        
        for(Book book : books){
            if(book.id == bookId){
                targetBook = book;
                break;
            }
        }
        
        if(targetBook == null) {
            System.out.println("Book ID not found.");
            return;
        }
        
        if(targetBook.isAvailable || targetBook.borrowedBy == null) {
            System.out.println("Book is not currently borrowed.");
            return;
        }
        
        if(targetBook.borrowedBy.memberId  != memberId){
            System.out.print("This member did not borrow the book.");
            return;
        }
        
        targetBook.isAvailable = true;
        System.out.println("Book return by " + targetBook.borrowedBy. name);
        targetBook.borrowedBy = null;
    }
    
    
    
    public void searchBook(Scanner sc){
        System.out.print("Enter a keyword to search (in title or author) : " );
        String keyword = sc.nextLine().toLowerCase();
        
        boolean found = false;
        
        for(Book book : books){
            if(book.title.toLowerCase().contains(keyword) || book.author.toLowerCase().contains(keyword)){
                book.displayInfo();
                found = true;
            }
        }
        if(!found){
            System.out.print("noo matching book found");
        }
    }
}
class Main {
    public static void main(String[] args) {
        System.out.println("==== Library Management System ====");
        Scanner sc = new Scanner(System.in);
        Library l1 = new Library();
        
        while(true){
            
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Show All Books");
            System.out.println("2. Show All Members");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Add Book");
            System.out.println("6. Add Member");
            System.out.println("7. Search Book by Title/Author");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice){
                case 1: 
                    l1.showAllBooks();
                    break;
                case 2:
                    l1.showAllMembers();
                    break;
                case 3:
                    l1.borrowBook(sc);
                    break;
                case 4:
                    l1.returnBook(sc);
                    break;
                case 5:
                    System.out.println("Enter Book Details ");
        
                    System.out.print("Book Id : ");
                    int id = sc.nextInt();
                    sc.nextLine();
        
                    System.out.print("Book Title : ");
                    String title = sc.nextLine();
        
                    System.out.print("Book Author : ");
                    String author = sc.nextLine();
        
                    System.out.print("Availablity of book (true/false) : ");
                    boolean isAvailable = sc.nextBoolean();
                    sc.nextLine();
                    
                    Book newBook = new Book(id, title, author, isAvailable);
                    l1.addBook(newBook);
                    break;
                case 6:
                    System.out.println("Enter Member Details ");
        
                    System.out.print("Enter Member Id : ");
                    int memberId = sc.nextInt();
                    sc.nextLine();
        
                    System.out.print("Enter Member Name : ");
                    String name = sc.nextLine();
                    Member newMember = new Member(memberId, name);
                    l1.addMember(newMember);
                    break;
                case 7:
                    l1.searchBook(sc);
                    break;
                case 8:
                    System.out.println("Exiting Liabrary System. Goodby!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please Try Again.");
            }
            
        }
    }
}