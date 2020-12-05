import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("yo");
        List<String> fileStream = Files.readAllLines(Paths.get("input.txt"));
        
                                                                                // FBFBBBFRLL
                                                                                // BFFFBFFRRR
                                                                                // BBFBFFFLLR
                                                                                // FBFFFBFLRR
                                                                                // FBFFBFBLLR
                                                                                // BFBBFBBRLL
                                                                                // BFFFFFFRLR
                                                                                // FBBBBFFLLR
                                                                                // FFBBFFFLRL
                                                                                // FFBFBBFLLR

    }
}
