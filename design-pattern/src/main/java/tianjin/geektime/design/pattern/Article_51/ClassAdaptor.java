package tianjin.geektime.design.pattern.Article_51;

/**
 * Created by tianjin on 2021/2/19.
 */
public class ClassAdaptor {

    private interface ITarget{
        void f1();
        void f2();
        void f3();
    }

    private static class Adaptee{
        void fa(){};
        void fb(){};
        void fc(){};
    }

    private static class Adaptor extends Adaptee implements ITarget{

        @Override
        public void f1() {
            super.fa();
        }

        @Override
        public void f2() {
            super.fb();
        }

        @Override
        public void f3() {
            super.fc();
        }
    }

}
