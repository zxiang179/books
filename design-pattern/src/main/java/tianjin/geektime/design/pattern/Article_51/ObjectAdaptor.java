package tianjin.geektime.design.pattern.Article_51;

/**
 * Created by tianjin on 2021/2/19.
 */
public class ObjectAdaptor {

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

    private static class Adaptor implements ITarget{

        private Adaptee adaptee;

        public Adaptor(Adaptee adaptee){
            this.adaptee = adaptee;
        }

        @Override
        public void f1() {
            adaptee.fa();
        }

        @Override
        public void f2() {
            adaptee.fb();
        }

        @Override
        public void f3() {
            adaptee.fc();
        }
    }

}
