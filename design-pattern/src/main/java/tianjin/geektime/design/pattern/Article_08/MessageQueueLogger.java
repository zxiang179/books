package tianjin.geektime.design.pattern.Article_08;

/**
 * Created by tianjin on 2020/12/26.
 */
public class MessageQueueLogger extends Logger {

    private Writer messageQueue;

    public MessageQueueLogger(String name, boolean enable, Level minPermittedLevel, String filePath) {
        super(name, enable, minPermittedLevel);
        this.messageQueue = new Writer(filePath);
    }

    @Override
    protected void doLog(Level level, String message) {
        messageQueue.write();
    }
}
