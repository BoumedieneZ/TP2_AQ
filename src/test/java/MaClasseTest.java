import org.example.MaClasse;
import org.example.MonInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class MaClasseTest {
    @Test
    void monTest() {
        // Arrange
        MonInterface maMock = mock(MonInterface.class);

        when(maMock.maMethode()).thenReturn("mock");
        MaClasse maClasse = new MaClasse(maMock);

        // Act
        String resultat = maClasse.maMethode();
        // Assert
        assertEquals("mock", resultat);
    }
}