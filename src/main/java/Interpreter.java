import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;

public class Interpreter extends Reader {

    private Reader reader;

    Interpreter() {
        this.reader = new StringReader("begin");
    }

    @Override
    public int read(char cbuf[], int off, int len) throws IOException {
        int result = reader.read(cbuf, off, len);
        if(result >= 0) return result;
        else reader = askInput();
        return reader.read(cbuf, off, len);
    }

    private Reader askInput() {
        System.out.print(">>> ");
        Scanner s = new Scanner(System.in);
        return new StringReader(s.next());
    }

    @Override
    public void close() throws IOException {
    }
}
