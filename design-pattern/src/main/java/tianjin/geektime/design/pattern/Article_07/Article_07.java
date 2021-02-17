package tianjin.geektime.design.pattern.Article_07;

/**
 * Created by tianjin on 2020/12/26.
 * 哪些代码看似是面向对象，实际是面向过程的
 * 1. 滥用getter和setter方法
 * 不该暴露的属性，不应该提供getter和修改方法
 * 对于集合容器而言，如list，map，要防范集合内部数据被修改的风险
 * 2. 滥用全局变量和全局方法
 * 静态方法将方法与数据分离，破坏了封装特性，是典型的面向过程风格。
 * Constants类，将所有的常量放在一个大而全的Constants类，不是一个很好的设计思路
 * 3. 定义数据和方法分离的类
 * 传统的MVC结构，Controller负责暴露接口，Service负责业务逻辑，Repository负责数据读写。
 * 典型的面向过程的开发模式，贫血模型。
 *
 * 为什么容易写出面向过程风格的代码？
 * 面向过程更符合人的思维方式，先做什么，再做什么。
 *
 */
public class Article_07 {


}
