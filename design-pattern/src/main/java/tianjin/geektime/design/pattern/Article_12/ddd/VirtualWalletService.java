package tianjin.geektime.design.pattern.Article_12.ddd;

import tianjin.geektime.design.pattern.Article_12.pinxue.VirtualWallet;

import java.math.BigDecimal;

/**
 * Created by tianjin on 2021/1/2.
 */
public class VirtualWalletService {

    // DI
    private VirtualWalletRepository walletRepo;
    private VirtualWalletTransactionRepository transactionRepo;

    public VirtualWallet getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        return convert(walletEntity);
    }

    public BigDecimal getBalance(Long walletId){
        return walletRepo.getBalance(walletId);
    }

    public void debit(Long walletId,BigDecimal amount){
        // 通过walletRepo查询到对应的walletEntity
        // 通过walletEntity获取余额
        // 通过walletRepo更新余额(subtract)
        // 其中更新操作不需要在Service层做，只需要调用wallet.debit(amount)方法
    }

    public void credit(Long walletId,BigDecimal amount){
        // 通过walletRepo查询到对应的walletEntity
        // 通过walletEntity获取余额
        // 通过walletRepo更新余额(add)
        // 其中更新操作不需要在Service层做，只需要调用wallet.credit(amount)方法
    }

    public void transfer(Long fromWalletId,Long toWalletId,BigDecimal amount){
        // 创建transaction entity
        // from账户减少
        // to账户增加
        // 更新transaction状态

    }


    private class VirtualWalletRepository {
        public VirtualWalletEntity getWalletEntity(Long walletId) {
            return new VirtualWalletEntity();
        }
        public BigDecimal getBalance(Long walletId){
            return walletRepo.getBalance(walletId);
        }
    }

    private class VirtualWalletTransactionRepository {
    }

    private class VirtualWalletEntity {

    }

    public VirtualWallet convert(VirtualWalletEntity entity) {
        return new VirtualWallet();
    }
}
