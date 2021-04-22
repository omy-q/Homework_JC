package lesson14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainClassTest {

    private MainClass mc;

    @BeforeEach
    public void init() {
        mc = new MainClass();
    }

    public static Stream<Arguments> dataForTestBoolean() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(false, new int[] {1, 1, 1, 1, 5}));
        out.add(Arguments.arguments(true, new int[] {1, 4, 1, 4, 6}));
        out.add(Arguments.arguments(true, new int[] {4, 6, 7, 1, 9, 0, 3}));
        out.add(Arguments.arguments(false, new int[] {4, 4, 2, 6}));
        return out.stream();
    }

    public static Stream<Arguments> dataForTestArrays() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {0, 3}, new int[] {1, 5, 2, 4, 0, 3}));
        out.add(Arguments.arguments(new int[] {3, 0, 8, 5}, new int[] {6, 2, 4, 3, 0, 8, 5}));
        out.add(Arguments.arguments(new int[] {1, 2}, new int[] {4, 5, 4, 4, 1, 2}));
        out.add(Arguments.arguments(new int[] {1}, new int[] {6, 3, 8, 4, 4, 1}));
        return out.stream();
    }

    public static Stream<Arguments> dataForTestThrows() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {1, 1, 1, 1, 5}));
        out.add(Arguments.arguments(new int[] {1, 4}));
        out.add(Arguments.arguments(new int[] {6, 7, 1, 9, 0, 3}));
        out.add(Arguments.arguments(new int[] {5, 0, 1}));
        return out.stream();
    }

    @MethodSource("dataForTestArrays")
    @ParameterizedTest
    void arrayAfterFourTestValue(int[] resultArr, int[] arr) {
        Assertions.assertArrayEquals(resultArr, mc.arrayAfterFour(arr));
    }

    @MethodSource("dataForTestThrows")
    @ParameterizedTest
    void arrayAfterFourTestTrow(int[] arr) {
        Assertions.assertThrows(RuntimeException.class, () -> mc.arrayAfterFour(arr));}

    @MethodSource("dataForTestBoolean")
    @ParameterizedTest
    void checkArrOneAndFourTest(boolean result, int[] arr) {
        Assertions.assertEquals(result, mc.checkArrOneAndFour(arr));
    }


}