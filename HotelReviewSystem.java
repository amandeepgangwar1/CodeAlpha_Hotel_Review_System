import java.util.ArrayList;
import java.util.Scanner;

public class HotelReviewSystem {
    private ArrayList<Hotel> hotels;
    private ArrayList<Review> reviews;

    public HotelReviewSystem() {
        hotels = new ArrayList<>();
        reviews = new ArrayList<>();
    }

    public void addHotel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        System.out.print("Enter hotel address: ");
        String hotelAddress = scanner.nextLine();
        Hotel hotel = new Hotel(hotelName, hotelAddress);
        hotels.add(hotel);
    }

    public void addReview() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        Hotel hotel = getHotel(hotelName);
        if (hotel != null) {
            System.out.print("Enter reviewer name: ");
            String reviewerName = scanner.nextLine();
            System.out.print("Enter rating (1-5): ");
            int rating = scanner.nextInt();
            System.out.print("Enter review text: ");
            String reviewText = scanner.next();
            Review review = new Review(reviewerName, rating, reviewText);
            reviews.add(review);
            hotel.addReview(review);
        } else {
            System.out.println("Hotel not found.");
        }
    }

    public void displayHotelReviews() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        Hotel hotel = getHotel(hotelName);
        if (hotel != null) {
            System.out.println("Reviews for " + hotel.getName() + ":");
            for (Review review : hotel.getReviews()) {
                System.out.println("Rating: " + review.getRating() + "/5");
                System.out.println("Review: " + review.getReviewText());
                System.out.println("Reviewer: " + review.getReviewerName());
                System.out.println();
            }
        } else {
            System.out.println("Hotel not found.");
        }
    }

    private Hotel getHotel(String hotelName) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(hotelName)) {
                return hotel;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HotelReviewSystem system = new HotelReviewSystem();

        while (true) {
            System.out.println("1. Add hotel");
            System.out.println("2. Add review");
            System.out.println("3. Display hotel reviews");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.addHotel();
                    break;
                case 2:
                    system.addReview();
                    break;
                case 3:
                    system.displayHotelReviews();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

class Hotel {
    private String name;
    private String address;
    private ArrayList<Review> reviews;

    public Hotel(String name, String address) {
        this.name = name;
        this.address = address;
        reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }
}

class Review {
    private String reviewerName;
    private int rating;
    private String reviewText;

    public Review(String reviewerName, int rating, String reviewText) {
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public int getRating() {
        return rating;
    }

    public String getReviewText() {
        return reviewText;
    }
}