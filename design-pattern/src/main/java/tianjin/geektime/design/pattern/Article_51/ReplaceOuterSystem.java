package tianjin.geektime.design.pattern.Article_51;

/**
 * Created by tianjin on 2021/2/20.
 */
public class ReplaceOuterSystem {

    // 外部系统A
    private interface IA{
        void fa();
    }

    private static class A implements IA{

        @Override
        public void fa() {
            // 123
        }
    }

    private static class BAdaptor implements IA{

        private A a;

        public BAdaptor(A a){
            this.a = a;
        }

        @Override
        public void fa() {
            // 123
            a.fa();
            // 456
        }
    }

    private static class Demo{
        private IA a;
        public Demo(IA a){
            this.a = a;
        }
        // ..
    }

    public static void main(String[] avgs) {
        Demo demo = new Demo(new A());
        Demo demo1 = new Demo(new BAdaptor(new A()));
    }

}
