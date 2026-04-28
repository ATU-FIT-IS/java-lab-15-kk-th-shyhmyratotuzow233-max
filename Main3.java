import java.util.*;

// Author класы
class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Book класы
class Book {
    private String title;
    private Author author;
    private boolean isAvailable;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Кітап алынды: " + title);
        } else {
            System.out.println("Бұл кітап бос емес!");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("Кітап қайтарылды: " + title);
    }
}

// User класы
class User {
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void borrow(Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            borrowedBooks.add(book);
        } else {
            System.out.println("Алу мүмкін емес!");
        }
    }

    public void giveBack(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
        } else {
            System.out.println("Сізде бұл кітап жоқ!");
        }
    }
}

// Негізгі класс
public class Main {
    static List<Book> library = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Авторлар
        Author a1 = new Author("Abai");
        Author a2 = new Author("Mukhtar Auezov");

        // Кітаптар
        library.add(new Book("Kara Sozder", a1));
        library.add(new Book("Abai Zholy", a2));

        User user = new User("Student");

        while (true) {
            System.out.println("\n1. Кітаптарды көру");
            System.out.println("2. Кітап алу");
            System.out.println("3. Кітап қайтару");
            System.out.println("4. Іздеу");
            System.out.println("0. Шығу");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                for (int i = 0; i < library.size(); i++) {
                    Book b = library.get(i);
                    System.out.println(i + ". " + b.getTitle() + " - " + b.getAuthor().getName() +
                            (b.isAvailable() ? " (бар)" : " (жоқ)"));
                }
            } else if (choice == 2) {
                System.out.print("Индекс енгіз: ");
                int i = sc.nextInt();
                user.borrow(library.get(i));
            } else if (choice == 3) {
                System.out.print("Индекс енгіз: ");
                int i = sc.nextInt();
                user.giveBack(library.get(i));
            } else if (choice == 4) {
                System.out.print("Атауын жаз: ");
                String name = sc.nextLine();
                for (Book b : library) {
                    if (b.getTitle().toLowerCase().contains(name.toLowerCase())) {
                        System.out.println("Табылды: " + b.getTitle());
                    }
                }
            } else if (choice == 0) {
                break;
            }
        }

        sc.close();
    }
}
