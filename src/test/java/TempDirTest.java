import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempDirTest {
    @TempDir
    static Path tempDir;
    @Test
    void writeItemsToFile() throws IOException {

        //Path file = tempDir.resolve();
        System.out.println(tempDir.toAbsolutePath());


    }
    // end::user_guide_parameter_injection[]

    static
            // tag::user_guide_field_injection[]
    class SharedTempDirectoryDemo {

        @TempDir
        Path sharedTempDir;

        @Test
        void writeItemsToFile() throws IOException {
            Path file = sharedTempDir.resolve("test.txt");
            System.out.println(file.toAbsolutePath());


        }

        @Test
        void anotherTestThatUsesTheSameTempDir() {
            Path file = sharedTempDir.resolve("test.txt");
            System.out.println(file.toAbsolutePath());
        }

    }
    // end::user_guide_field_injection[]
}
