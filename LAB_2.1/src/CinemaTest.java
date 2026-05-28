import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CinemaTest {

    private Cinema cinema;

    @BeforeAll
    static void initAll() {
        System.out.println("🎬 Запуск всех тестов для Cinema. Инициализация общих ресурсов...");
    }

    @BeforeEach
    void setUp() {
        cinema = new Cinema("Начало", 10);
        System.out.println("🎟️ Создан новый кинотеатр для теста. Фильм: Начало, мест: 10");
    }

    @AfterEach
    void tearDown() {
        System.out.println(" Тест завершен. Очистка не требуется, объект будет удален сборщиком мусора.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("🍿 Все тесты Cinema завершены. Освобождение общих ресурсов.");
    }

    @Test
    @DisplayName("Тест: Бронирование места уменьшает количество свободных мест")
    void testBookSeatSuccess() {
        int availableBefore = cinema.getAvailableSeats();
        boolean result = cinema.bookSeat(3);
        assertTrue(result);
        assertEquals(availableBefore - 1, cinema.getAvailableSeats());
        System.out.println(" Выполняется testBookSeatSuccess");
    }

    @Test
    @DisplayName("Тест: Бронирование уже занятого места невозможно")
    void testBookSeatFail() {
        cinema.bookSeat(3);
        boolean result = cinema.bookSeat(3);
        assertFalse(result);
        assertEquals(9, cinema.getAvailableSeats(), "Количество свободных мест не должно измениться");
        System.out.println(" Выполняется testBookSeatFail");
    }

    @Test
    @DisplayName("Тест: Отмена бронирования увеличивает количество свободных мест")
    void testCancelBookingSuccess() {
        cinema.bookSeat(5);
        int availableBeforeCancel = cinema.getAvailableSeats();
        boolean result = cinema.cancelBooking(5);
        assertTrue(result);
        assertEquals(availableBeforeCancel + 1, cinema.getAvailableSeats());
        System.out.println(" Выполняется testCancelBookingSuccess");
    }

    @Test
    @DisplayName("Тест: Отмена бронирования свободного места невозможна")
    void testCancelBookingFail() {
        boolean result = cinema.cancelBooking(7);
        assertFalse(result);
        assertEquals(10, cinema.getAvailableSeats(), "Количество свободных мест не должно измениться");
        System.out.println(" Выполняется testCancelBookingFail");
    }
}