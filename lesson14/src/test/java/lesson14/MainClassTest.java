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
    

    public static Stream<Arguments> dataForTest() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(false, new int[] {1, 1, 1, 1, 5}));
        out.add(Arguments.arguments(true, new int[] {1, 4, 1, 4, 6}));
        out.add(Arguments.arguments(true, new int[] {4, 6, 7, 1, 9, 0, 3}));
        out.add(Arguments.arguments(false, new int[] {4, 4, 2, 6}));
        return out.stream();
    }

    @MethodSource("dataForTest")
    @ParameterizedTest
    void checkArrOneAndFourTest(boolean result, int[] arr) {
        Assertions.assertEquals(result, mc.checkArrOneAndFour(arr));
    }


}