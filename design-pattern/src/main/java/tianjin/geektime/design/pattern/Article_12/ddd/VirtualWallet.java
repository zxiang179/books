package tianjin.geektime.design.pattern.Article_12.ddd;

import java.math.BigDecimal;

/**
 * Created by tianjin on 2021/1/2.
 * VirtualWalletBo => VirtualWallet
 */
public class VirtualWallet {

    private Long walletId;
    private Long createTime = System.currentTimeMillis();
    private BigDecimal balance = BigDecimal.ZERO;

    public VirtualWallet(Long id){
        this.walletId = id;
    }

    public BigDecimal getBalance(){
        return this.balance;
    }

    public void debit(BigDecimal amount){
        if(this.balance.compareTo(amount)<0){
            throw new RuntimeException("insufficient");
        }
        this.balance.subtract(amount);
    }

    public void credit(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO)<0){
            throw new RuntimeException("invalid amount");
        }
        this.balance.add(amount);
    }

}
