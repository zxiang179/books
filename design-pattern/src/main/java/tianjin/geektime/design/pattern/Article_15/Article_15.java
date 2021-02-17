package tianjin.geektime.design.pattern.Article_15;

/**
 * Created by tianjin on 2021/1/16.
 * 如何理解单一职责原则(SRP)?
     * 一个类只负责完成一个职责或功能，也就是说，不要设计大而全的类，要设计粒度小、功能单一的类。
     * 我们可以先写一个粗粒度的类，满足业务需求。随着业务的发展，如果粗粒度的类越来越庞大，代码越来越多，
     * 这个时候，我们就可以将这个粗粒度的类，拆分成几个细粒度的类，这就是所谓的持续重构。
 * 类的职责是否设计的越单一越好？
     * {@link Serialization}经过拆封 {@link Serializer} 类和 {@link Deserializer}类的职责更加单一
     * 但是，我们如果修改了协议的格式，如数据表示 "UEUEUE" => "DUDUDU",或序列化方式从gson改成了xml
     * 那{@link Serializer} 类和 {@link Deserializer}类都需要做相应的修改，代码的内聚性显然没有原来{@link Serialization}高了。
 * 如何判断类的职责是否足够单一？
     * 1. 类中的代码行数函数或者属性过多；
     * 2. 类依赖的其他类过多，或者依赖类的其他类过多；
     * 3. 私有方法过多；
     * 4. 比较难给类起一个合适的名字
     * 5. 类中大量的方法都是集中操作类中的某几个属性
 */
public class Article_15 {
}
