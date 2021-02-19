package tianjin.geektime.design.pattern.Article_51;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tianjin on 2021/2/19.
 * 适配器模式：将不兼容的接口转换为可兼容的接口，让原本由于接口不兼容而不能一起工作的类可以一起工作
 * 适配器模式分为两种：类适配器和对象适配器
 * 类适配器使用继承关系来实现；对象适配器使用组合关系来实现
 *
 * 选择哪种适配器类型？
 * 推荐类适配器：Adaptee 接口较多，Adaptee 和 ITarget 接口定义大部分相同，建议使用类适配器
 * 推荐对象适配器：Adaptee 接口较多，Adaptee 和 ITarget 接口定义大部分都不相同，建议使用对象适配器
 *
 * 适配器的应用场景？
 * 1. 封装有缺陷的接口设计
 * 2. 统一多个类的接口设计
 *    某个功能依赖多个外部系统，这些外部系统中的接口各部相同，通过适配器模式将这些接口适配为统一的接口定义，之后就可以通过多态聊实现代码的复用逻辑
 * 3. 替换依赖的外部系统
 * 4. 兼容老版本接口
 *    对于一些废弃的接口，不是直接将其删除，而是标记为deprecated，并且将内部的逻辑委托为新的接口实现
 * 5. 适配不同格式数据
 *    Arrays.asList 将数组类型转换为集合容器类型
 */
public class Article_51 {

    public void test(){
        List<String> strings = Arrays.asList("1", "2");
    }

}
