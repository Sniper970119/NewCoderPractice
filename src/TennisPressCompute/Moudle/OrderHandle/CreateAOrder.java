package TennisPressCompute.Moudle.OrderHandle;

import java.time.LocalDate;

/**
 * Created by Sniper on 2018/9/4.
 */
public class CreateAOrder {
    // 变量含义同下方法注释
    private String userId;
    private LocalDate localDate;
    private int timeFrom;
    private int timeTo;
    private String place;
    /**
     * @param userId 订单用户名
     * @param localDate 订单预定日期
     * @param timeFrom 订单预定起时间
     * @param timeTo 订单预定支时间
     * @param place 订单预定的场地
     * */
    CreateAOrder(String userId, LocalDate localDate, int timeFrom, int timeTo, String place){
        this.userId = userId;
        this.localDate = localDate;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.place = place;
    }
}
