package tianjin.geektime.design.pattern.Article_12.pinxue;

import java.math.BigDecimal;

/**
 * Created by tianjin on 2021/1/2.
 * 基于贫血模型的开发模型
 */
public class VirtualWalletController {

    private VirtualWalletService service;
    // 查询余额
    public BigDecimal getBalance(Long walletId){return null;}
    // 出账
    public void debit(Long walletId,BigDecimal amount){}
    // 入账
    public void credit(Long walletId,BigDecimal amount){}
    // 转账
    public void transfer(Long fromWalletId,Long toWalletId,BigDecimal amount){}

}
