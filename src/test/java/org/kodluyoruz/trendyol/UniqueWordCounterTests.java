package org.kodluyoruz.trendyol;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class UniqueWordCounterTests {

    @Test
    public void getUniqueWordCount_WhenInputIsNull_ShouldThrowIllegalArgumentException() {
        // Arrange
        UniqueWordCounter sut = new UniqueWordCounter();

        // Act
        Throwable throwable = catchThrowable(() -> sut.getUniqueWordCount(null));

        // Assert
        assertThat(throwable ).isInstanceOf(IllegalArgumentException.class).hasMessage("Phrase must not be null.");
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

}
