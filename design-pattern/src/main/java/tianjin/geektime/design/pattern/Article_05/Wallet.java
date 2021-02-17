package tianjin.geektime.design.pattern.Article_05;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by tianjin on 2020/12/26.
 * id,createTime在创建钱包的时候就确定了，所以不需要提供set方法来做修改，并且设置为private
 * 抽象：如何隐藏方法的具体实现，包括方法命名，不要暴露太多细节
 * 继承：用来表示类之间is-a的关系，便于代码复用
 * 多态：自类可以代替父类 动态语言-duck typing
 */
public class Wallet {

    private AtomicLong IdGenerator = new AtomicLong(0);
    @Getter
    private String id;
    @Getter
    private long createTime;
    @Getter
    private BigDecimal balance;
    @Getter
    private long balanceLastModifiedTime;

    public Wallet() {
        this.id = String.valueOf(IdGenerator.incrementAndGet());
        this.createTime = System.currentTimeMillis();
        this.balance = BigDecimal.ZERO;
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    public void increaseAmount(BigDecimal increaseAmount) {
        if (increaseAmount.compareTo(BigDecimal.ZERO) < 0) {
            // throw invalid amount exception
        }
        this.balance.add(increaseAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    public void decreaseAmount(BigDecimal decreaseAmount){
        if (decreaseAmount.compareTo(BigDecimal.ZERO) < 0) {
            // throw invalid amount exception
        }
        if(decreaseAmount.compareTo(this.balance)>0){
            // throw insufficient amount exception
        }
        this.balance.subtract(decreaseAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

}
