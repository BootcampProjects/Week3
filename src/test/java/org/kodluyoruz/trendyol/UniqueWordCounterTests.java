package org.kodluyoruz.trendyol;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class UniqueWordCounterTests {

    private static Stream<Arguments> provideSameWords() {
        return Stream.of(
                Arguments.of("test Test TEST teSt TesT"),
                Arguments.of("test, Test. TEST teSt, TesT,, tEST."),
                Arguments.of("unit Unit. UNIT,. uniT UNit... unIT,.,., UniT,,.")
        );
    }

    @Test
    public void getUniqueWordCount_WhenInputIsNull_ShouldThrowIllegalArgumentException() {
        // Arrange
        UniqueWordCounter sut = new UniqueWordCounter();

        // Act
        Throwable throwable = catchThrowable(() -> sut.getUniqueWordCount(null));

        // Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Phrase must not be null.");
    }

    @Test
    public void getUniqueWordCount_WhenInputIsEmpty_ShouldReturn0() {
        // Arrange
        UniqueWordCounter sut = new UniqueWordCounter();

        // Act
        int result = sut.getUniqueWordCount("  ");

        // Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void getUniqueWordCount_WhenInputIsOnly1Word_ShouldReturn1() {
        // Arrange
        UniqueWordCounter sut = new UniqueWordCounter();

        // Act
        int result = sut.getUniqueWordCount("test");

        // Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getUniqueWordCount_WhenInputIsDifferent2Words_ShouldReturn2() {
        // Arrange
        UniqueWordCounter sut = new UniqueWordCounter();

        // Act
        int result = sut.getUniqueWordCount("test different");

        // Assert
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void getUniqueWordCount_WhenInputIsSame2Words_ShouldReturn1() {
        // Arrange
        UniqueWordCounter sut = new UniqueWordCounter();

        // Act
        int result = sut.getUniqueWordCount("test test");

        // Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getUniqueWordCount_WhenInputIsSame2WordsWithUppercase_ShouldReturn1() {
        // Arrange
        UniqueWordCounter sut = new UniqueWordCounter();

        // Act
        int result = sut.getUniqueWordCount("test Test");

        // Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getUniqueWordCount_WhenInputIsSame2WordsIncludePunctuationWithDotOrComma_ShouldReturn1() {
        // Arrange
        UniqueWordCounter sut = new UniqueWordCounter();

        // Act
        int result = sut.getUniqueWordCount("test, test.");

        // Assert
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource("provideSameWords")
    public void getUniqueWordCount_WhenInputIsSameWords_ShouldReturn1(String words) {
        // Arrange
        UniqueWordCounter sut = new UniqueWordCounter();

        // Act
        int result = sut.getUniqueWordCount(words);

        // Assert
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/WordsData.csv")
    public void getUniqueWordCount_WhenInputIsWords_ShouldReturnCalculatedFine(String words, int expectedResult) {
        // Arrange
        UniqueWordCounter sut = new UniqueWordCounter();

        // Act
        int result = sut.getUniqueWordCount(words);

        // Assert
        assertThat(result).isEqualTo(expectedResult);
    }

}
