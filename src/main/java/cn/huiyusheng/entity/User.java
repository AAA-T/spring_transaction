package cn.huiyusheng.entity;

/**
 * @author 悔余生
 * @ClassName:User
 * @Description:TODO
 * @Date 2020/12/7 上午10:28
 * @Version V1.0
 **/
public class User {
    private Integer id; // 编号
    private String realname;    // 姓名
    private Integer cardno;     //卡号
    private Double balance;     //金额

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getCardno() {
        return cardno;
    }

    public void setCardno(Integer cardno) {
        this.cardno = cardno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", cardno=" + cardno +
                ", balance=" + balance +
                '}';
    }
}
