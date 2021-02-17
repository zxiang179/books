package tianjin.geektime.design.pattern.Article_12;

/**
 * Created by tianjin on 2021/1/2.
 * 钱包系统的设计
     * 把整个钱包系统的业务划分为两个部分，其中一部分单纯跟应用内的虚拟钱包账户打交道，另一部分跟银行账户打交道。
     * 支付功能设计两个账户的余额加减操作：一个账户减余额，另一个账户加余额
     * 在交易流水的设计上，可以将两个账户的ID放在同一条交易流水中，一方面是为了实现业务需要，
     * 另一方面可以通过数据库本身的原子性(分库分表无法通过简单的方式保证原子性)保证数据的一致性。
     * 对于支付转账操作，可以先记录交易流水，并将当前流水状态记为"待执行"，待两边操作都完成后，将交易流水标记为"成功",或失败。
 * 充值、提现、支付这些业务交易类型，是否应该让虚拟钱包系统感知？
     * 不需要，虚拟钱包不应该感知这些，钱包的操作只是余额的加加减减，不涉及复杂业务概念，职责单一，功能通用，不需要耦合太多的业务概念。
 * 在充血模型中，将业务逻辑移动到Domain中，Service类变得很薄，为什么还需要保留Serivce类？
     * 1. Service类负责和repository打交道
     * 2. Service类负责跨领域模型的业务聚合
     * 3. Service类负责一些非功能性的与三方系统交互的工作，如调用其他rpc接口
 * 在基于充血模型的DDD开发模式中，Service层被改造成了充血模型，但是Controller层和Repository层还是贫血模型，是否有必要进行充血领域建模？
     * Controller层主要负责接口的暴露，Repository层主要负责与数据库打交道，这两层包含的业务逻辑不多，没必要做充血建模。
     * Repository层的Entity生命周期有限；Controller的VO只是单纯作为DTO
 *
 */
public class Article_12 {
}