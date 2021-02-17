package tianjin.geektime.design.pattern.Article_08;

/**
 * Created by tianjin on 2020/12/26.
 */
public abstract class Logger {

    private String name;
    private boolean enable;
    private Level minPermittedLevel;

    public Logger(String name, boolean enable, Level minPermittedLevel) {
        this.name = name;
        this.enable = enable;
        this.minPermittedLevel = minPermittedLevel;
    }

    public void log(Level level, String message) {
        boolean loggable = this.enable && (minPermittedLevel.value <= level.value);
        if (loggable) {
            doLog(level, message);
        }
    }

    protected abstract void doLog(Level level, String message);

    static class Level {
        int value;
    }

}
