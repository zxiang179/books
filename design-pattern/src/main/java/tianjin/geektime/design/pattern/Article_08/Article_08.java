package tianjin.geektime.design.pattern.Article_08;

/**
 * Created by tianjin on 2020/12/26.
 * 接口和抽象类的区别是什么？
     * 抽象类不允许被实例化，只能被继承，继承能够解决代码复用的问题，避免在子类中重复编写相同的代码。
     * 抽象类可以包含属性和方法，方法可以包含代码实现，也可以不包含代码实现(abstract)
     * 子类继承抽象类必须实现抽象类中的所有抽象方法
     * 接口不能包含属性
     * 接口只能申明方法，不能包含代码实现
     * 类实现接口的时候，必须实现接口中申明的所有方法
     * 抽象类是is-a的关系，接口是has-a的关系，表示具有某些功能，也可以叫协议
 * 什么时候用接口？
     * 抽象类更多的是为了代码复用，接口更侧重于解耦。接口是对行为的一种抽象，相当于一组协议或者契约。
 * 什么时候用抽象类还是接口？
     * 表示is-a关系，为了解决代码复用的问题，使用抽象类。
     * 表示has-a关系，为了解决抽象而非代码复用的问题，我们就使用接口。
     * 从类的继承层次来看，抽象类是一种自下而上的设计思路。先有子类的代码重复，然后再抽象成上层的父类(抽象类)。
     * 而接口相反，是一种自上而下的设计思路，先设计接口，再考虑具体的实现。
 * 抽象类和接口存在的意义？
 */
public class Article_08 {


}
