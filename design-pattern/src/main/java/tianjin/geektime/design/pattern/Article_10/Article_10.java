package tianjin.geektime.design.pattern.Article_10;

/**
 * Created by tianjin on 2020/12/26.
 * 为什么不推荐使用继承？
     * 继承层次过深，继承关系过于复杂，会影响到代码的可读性和可维护性
 * 组合相比继承有哪些优势？
     * is-a关系，可以通过组合和接口的has-a关系来替代
     * 多态可直接利用接口来实现
     * 代码复用可通过组合和委托来实现
     * 如何判断该使用组合还是继承？
     * 不能改变一个函数的入参类型，而入参又非接口，为了支持多态，只能采用继承来实现。
 * 继承的主要作用
     * 表示is-a关系，支持多态，代码复用
     * 这三个作用可以通过组合、接口、委托三个技术手段来达成。组合还可以解决层次过深，过复杂的继承关系
 */
public class Article_10 {

    public interface Flyable {
        void fly();
    }

    public class FlyAbility implements Flyable{

        @Override
        public void fly() {
            System.out.printf("fly");
        }
    }

    public interface Tweetable {
        void tweet();
    }

    public class TweetAbility implements Tweetable{

        @Override
        public void tweet() {
            System.out.printf("tweet");
        }
    }

    public interface EggLayable {
        void lay();
    }

    public class EggLayAbility implements EggLayable{

        @Override
        public void lay() {

        }
    }

    public class Ostrich implements Tweetable, EggLayable {

        Tweetable tweetable = new TweetAbility();
        EggLayAbility eggLayAbility = new EggLayAbility();

        @Override
        public void tweet() {
            tweetable.tweet();
        }

        @Override
        public void lay() {
            eggLayAbility.lay();
        }
    }

    public class Sparrow implements Flyable, Tweetable, EggLayable {

        @Override
        public void fly() {

        }

        @Override
        public void tweet() {

        }

        @Override
        public void lay() {

        }
    }

}
