package tianjin.geektime.design.pattern.Article_51;

/**
 * Created by tianjin on 2021/2/20.
 */
public class ImperfectInterface {

    private static class CD {
        public static void staticFunc() {
        }

        public void uglyNamedFunc() {
        }

        public void tooManyParamsFunc() {
        }

        public void lowPerformanceFunc() {
        }
    }

    private interface ITarget{
        void f1();
        void f2();
        void f3();
        void f4();
    }

    private class CDAdaptor extends CD implements ITarget{

        @Override
        public void f1() {
            // ???
            super.lowPerformanceFunc();
        }

        @Override
        public void f2() {
            super.uglyNamedFunc();
        }

        @Override
        public void f3() {
            super.tooManyParamsFunc();
        }

        @Override
        public void f4() {
            super.lowPerformanceFunc();
        }
    }

}
