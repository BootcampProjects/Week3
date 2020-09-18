package org.kodluyoruz.trendyol;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UniqueWordCounterTests {

    @Test
    public void getUniqueWordCount_WhenInputIsOnly1Word_ShouldReturn1() {
        // Arrange
        UniqueWordCounter sut = new UniqueWordCounter();

        // Act
        int result = sut.getUniqueWordCount("test");

        // Assert
        assertThat(result).isEqualTo(1);
    }

}
