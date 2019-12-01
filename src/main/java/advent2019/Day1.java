package advent2019;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day1 {

    public int getFuels() throws IOException {
        List<String> result = Files.readAllLines(Paths.get(System.getProperty("user.dir") +
                "/src/main/resources/advent/day1.txt"));
        return result.stream().map(Integer::valueOf).mapToInt(this::calculateFuel).sum();
    }

    public int getFuelsWithFuels() throws IOException {
        List<String> result = Files.readAllLines(Paths.get(System.getProperty("user.dir") +
                "/src/main/resources/advent/day1.txt"));
        return result.stream().map(Integer::valueOf).mapToInt(this::calculateFuelWithFuel).sum();
    }

    public int calculateFuel(int mass){
        return (mass/3)-2;
    }

    public int calculateFuelWithFuel(int mass){
        int fuel = calculateFuel(mass);
        if(fuel > 0)
            return fuel + calculateFuelWithFuel(fuel);
        return 0;

    }


    @Test
    public void testFuel1(){
        assertEquals(2, calculateFuel(12));
        assertEquals(2, calculateFuel(14));
        assertEquals(654, calculateFuel(1969));
        assertEquals(33583, calculateFuel(100756));
    }

    @Test
    public void testFuels() throws IOException {
        assertEquals(3394689, getFuels());
    }

    @Test
    public void testFuelWithFuel() throws IOException {
        assertEquals(2, calculateFuelWithFuel(12));
        assertEquals(2, calculateFuelWithFuel(14));
        assertEquals(966, calculateFuelWithFuel(1969));
        assertEquals(50346, calculateFuelWithFuel(100756));
    }

    @Test
    public void testFuelsWithFuels() throws IOException {
        assertEquals(5089160, getFuelsWithFuels());
    }
}
