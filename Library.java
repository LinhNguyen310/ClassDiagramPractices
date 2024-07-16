// steps:
    // 1. clarify the scope: how much you want to cover
    // 2. Identify the key entities
    // 3. Identify the relationships between the entities
// library
// book: title, authro, ISBN, year, status
// user: name, email, phone, lsit of books they have borrowed - borrow the book, return the book
// library: list of books, list of users, list of staffs 

// ** IMPROVEMENT ** //
enum BookStatus {
    AVAILABLE,
    UNAVAILABLE
}

class Book {
    private String title;
    private String author;
    private String ISBN;
    private int year;
    private String status;

    // constructor
    public Book(String title, String author, String ISBN, int year, String status){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.year = year;
        this.status = status;
    }

    // getter and setter
    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public boolean isAvailable(){
        return this.status.equals(BookStatus.AVAILABLE);
    }
}

class User {
    private String name;
    private String email;
    private String phone;
    private List<Book> borrowedBooks;

    // constructor
    public User(String name, String email, String phone, List<Book> borrowedBooks){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.borrowedBooks = borrowedBooks;
    }

    // getter and setter

    // borrow book function
    public void borrowBook(Book book){
        boolean isAvailable = book.isAvailable();

        if (isAvailable){
            // book is available, can be borrowed
            this.borrowedBooks.add(book);
            book.setStatus(BookStatus.UNAVAILABLE);
        } else {
            throw new IllegalArgumentException("Book is not available.");
        }
    }

    public void returnBook(Book book){
        if (this.borrowedBooks.contains(book)){
            // book is valid
            this.borrowedBooks.remove(book);
            book.setStatus(BookStatus.AVAILABLE);
            System.out.println("Book returned successfully.");
        } else {
            // invalid book
            throw new IllegalArgumentException("Book is not borrowed by this user.");
        }
    }
}

class Library {
    private List<Book> books;
    private List<User> users;
    private String name;
    private String location;

    // constructor
    public Library(List<Book> books, List<User> users, String name, String location){
        this.books = books;
        this.users = users;
        this.name =  name;
        this.location = location;
    }

    // getters and setters methods

    // add book
    public void addBook(Book book){
        if (hasBook(book)){
            throw new IllegalArgumentException("Book already exists in the libray");
        } else {
            // add the book to the library
            this.books.add(book);
            System.out.println("Book has been added successfully.");
        }
    }

    public void removeBook(Book book){
        if (!hasBook(book)){
            // not valid book
            throw new IllegalArgumentException("Book does not exist in the library.");
        } else {
            this.books.remove(book);
            System.out.println("Book has been removed successfully.");
        }
    }

    public boolean hasUser(User user){
        return this.users.contains(user);
    }

    public boolean hasBook(Book book){
        return this.books.contains(book);
    }

    // add and remove users
    public void addUser(User user){
        if (hasUser(user)){
            throw new IllegalArgumentException("User already exists in the library.");
        } else {
            this.users.add(user);
            System.out.println("User has been added successfully.");
        }
    }

    public void removeUser(User user){
        if (!hasUser(user){
            // not valid user
            throw new IllegalArgumentException("User does not exist in the library.");
        } else {
            this.users.remove(user);
            System.out.println("User has been removed successfully.");
        }
    }

}

public class main {
    public static void main (String[] args){
        
        try {// create a library
            Library library = new Library(new ArrayList<>(), new ArrayList<>(), "Library at Toronto", "Toronto");
            // add a book
            Book firstBook = new Book("Summer 2002", "John Doe", "11121", 2002, "available");   
            if (!library.hasBook(firstBook)){
                library.addBook(firstBook);
            }

            // add a user
            User firstUser = new User("Alice", "alice@johndoe.ca", 1010101, new ArrayList<>());

            if (!library.hasUser(firstUser)){
                library.addUser(firstUser);
            }

            // borrow a book for user
            firstUser.borrowBook(firstBook);
            firstUser.returnBook(firstBook);
        } cactch( Exception e){
            e.printStackTrace();
        }
    }
}
