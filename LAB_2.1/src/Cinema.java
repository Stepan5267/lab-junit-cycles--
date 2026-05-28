public class Cinema {
    private String movieTitle;
    private int totalSeats;
    private boolean[] seats;

    public Cinema(String movieTitle, int totalSeats) {
        this.movieTitle = movieTitle;
        this.totalSeats = totalSeats;
        this.seats = new boolean[totalSeats];
    }

    public boolean bookSeat(int seatNumber) {
        if (seatNumber >= 0 && seatNumber < totalSeats && !seats[seatNumber]) {
            seats[seatNumber] = true;
            return true;
        }
        return false;
    }

    public boolean cancelBooking(int seatNumber) {
        if (seatNumber >= 0 && seatNumber < totalSeats && seats[seatNumber]) {
            seats[seatNumber] = false;
            return true;
        }
        return false;
    }

    public int getAvailableSeats() {
        int count = 0;
        for (boolean seat : seats) {
            if (!seat) count++;
        }
        return count;
    }
}