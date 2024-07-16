// in a movie theater, there are:   
// A movie: title, rating, duration, and genre
// A theater: number, capacity, and location
// A showtime: time, date, and theater number
// A ticket: price, seat number, and showtime
// A customer: name, age, and ticket
// Seat: number, row, and theater number

class Movie {
    // a movie has:
    // string title
    // list actors 
    // string rating
    // int duration
    // string genre
    private String title;
    private List<String> actors;
    private double rating;
    private int duration;
    private String genre;

    // constructor
    public Movie (String title, List<String> actors, double rating, int duration, String genre) {
        this.title = title;
        this.actors = actors;
        this.rating = rating;
        this.duration = duration;
        this.genre = genre;
    }

    // getters and setters to update the information
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() { 
        return "Movie " + title + " has actors " + actors + " with rating " + rating + " and duration " + duration + " minutes in genre " + genre;
    }
}

class Showtime {
    private String time;
    private String date;
    private int theaterNumber;
    private List<Seats> bookedSeats;
    private int totalSeats;

    // constructor
    public Showtime(Stirng time, String date, int theaterNumber) {
        this.time = time;
        this.date = date;
        this.theaterNumber = theaterNumber;
    }

    // getter and setters

    // other methods
    public boolean isBookedSeat(Seat seat){
        return bookedSeats.contains(seat);
    }

    // book seat action
    public void bookSeat(Seat seat) {
        bookedSeats.add(seat);
    }

    // check if showtime is full
    public boolean isFull() {
        return bookedSeats.size() == totalSeats;
    }

    // remove seat
    public void removeSeat(Seat seat) {
        bookedSeats.remove(seat);
    }
}

class Seat {
    // number
    // status
    // row
    // theater number
    private int seatNumber;
    private String status; // either "booked" or "available"
    private int row;
    private int theaterNumber;

    // constructor
    public Seat(int number, String status, int row, int theaterNumber) {
        this.seatNumber = number;
        this.status = status;
        this.row = row;
        this.theaterNumber = theaterNumber;
    }

    // check if the seat is available
    public boolean isAvailable() {
        return status.equals("available");
    }
}

class Ticket {
    // show time
    // price
    // seat number
    private Showtime showtime; 
    private double price;
    private Seat seat;

    // constructor
    public Ticket(Showtime showtime, double price, Seat seat) {
        this.showtime = showtime;
        this.price = price;
        this.seat = seat;
    }

    // getters and setters
}

class Customer {
    // name
    // Ticket ticket
    private String name;
    private List<Ticket> tickets;

    // constructor 
    public Customer(String name, List<Ticket> tickets) {
        this.name = name;
        this.tickets = tickets;
    }

    // getter and setter
    // add ticket
    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public cancelTicket(Ticket ticket) {
        this.tickets.remove(ticket);
    }
}

class MovieTheater {
    // list of showtime
    // locations
    // lsit of movies

    private List<Showtime> showtimes;
    private String location;
    private List<Movie> movies;

    // constructor
    public MovieTheater(List<Showtime> showtimes, String location, List<Movie> movies) {
        this.showtimes = showtimes;
        this.location = location;
        this.movies = movies;
    }

    //getter and setters

    // ad movie
    public void addMovie ( Movie movie) {
        if (movies.contain(movie)){
            System.out.println("Movie already exists");
        } else {
            // movie does not exist
            movies.add(movie);
            System.out.println("Movie added successfully");
        }
    }
    
    // remove movie from the list
    public void removeMovie(Movie movie) {
        if (movies.contain(movie)){
            movies.remove(movie);
            System.out.println("Movie removed successfully");
        } else {
            System.out.println("Movie does not exist");
        }
    }

    // add and remove showtime

    // book ticket
    public void bookTicket(Customer customer, Seat seat, Showtime showtime) {
        if (showtime.isFull()) {
            System.out.println("Showtime is full");
        } else if (showtime.isBookedSeat(seat)) {
            System.out.println("Seat is already booked");
        } else {
            showtime.bookSeat(seat);
            Ticket ticket = new Ticket(showtime, 10.0, seat);
            customer.addTicket(ticket);
        }
    }

    // cancel ticket
    public void cancelTicket(Customer customer, Ticket ticket) {
        // remove the ticket from customer list
        // rmeove the seat from the ticket showtime
        customer.cancelTicket(ticket);
        Showtime showtime = ticket.getShowtime();
        Seat seat = ticket.getSeat();
        showtime.removeSeat(seat);
    }
}

public class Main {
    public static void main (String[] args) {
        // create a movie theater
        MovieTheater movieTheater = new MovieTheater(new ArrayList<Showtime>(), "New York", new ArrayList<Movie>());
        Movie movie = new Movie("A happy place",  new ArrayList<String>(Arrays.asList("Tome", "Jerrie"), 4.5, 120, "Comedy");
        movieTheater.addMovie(movie);
        Showtime showtime = new Showtime("12:00", "2021-12-12", 1, new ArrayList<Seat>(), 100);
        movieTheater.addShowtime(showtime);
        Customer customer1 = new Customer("Alan", new ArrayList<Ticket>());
        boolean showtimeFull = showtime.isFull();
        if (!showtimeFull) {
            Seat seat = new Seat(1, "available", 1, 1);
            movieTheater.bookTicket(customer1, seat, showtime);
            System.out.println("Showtime is not full, proceed to book ticket"); 

        } else {
            System.out.println("Showtime is full");
        }
    }
}
