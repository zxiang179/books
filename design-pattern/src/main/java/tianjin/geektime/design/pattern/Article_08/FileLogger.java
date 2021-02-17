package tianjin.geektime.design.pattern.Article_08;

/**
 * Created by tianjin on 2020/12/26.
 */
public class FileLogger extends Logger {

    private Writer fileWriter;

    public FileLogger(String name, boolean enable, Level minPermittedLevel, String filePath) {
        super(name, enable, minPermittedLevel);
        this.fileWriter = new Writer(filePath);
    }

    @Override
    protected void doLog(Level level, String message) {
        fileWriter.write();
    }
}
