package com.carOwner.action;


import com.carOwner.entity.*;
import com.carOwner.entity.theThirdAPI.CarMember;
import com.carOwner.entity.theThirdAPI.CarStatus;
import com.carOwner.entity.theThirdAPI.MemberInfo;
import com.carOwner.enums.ActionRspEnum;
import com.carOwner.exception.ActionRspException;
import com.carOwner.service.*;
import com.carOwner.service.impl.DepositCouponRecServiceImpl;
import com.carOwner.util.*;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static com.carOwner.util.DateUtil.sdfDateTimeFormat_II;


/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 10:152018-4-28
 * @Modified By:
 */
@RestController
public class mainAction {
        private  static final Logger logger=LoggerFactory.getLogger(mainAction.class);
        @Autowired
        private APILicenseService apiLicenseService;
        @Autowired
        private MemberService memberService;
        @Autowired
        private CarStatusService carStatusService;
        @Autowired
        private DepositCouponRecService depositCouponRecService;
        @Autowired
        private CarService carService;


    public static void main(String[] args) {


/*            DepositCouponRecServiceImpl depositCouponRecService1 = new DepositCouponRecServiceImpl();
            TDepositCouponRec tDepositCouponRec=new TDepositCouponRec();
            //tDepositCouponRec.setId(1);
            tDepositCouponRec.setParkId(114);
            tDepositCouponRec.setCarPlate("粤CS114XXX");
            tDepositCouponRec.setOrderId("xxxxxxxx11111");
            tDepositCouponRec.setChannelNo("qqqqqqqqqq2222");
            tDepositCouponRec.setCouponType(20);
            tDepositCouponRec.setCouponValue(1.1);
            tDepositCouponRec.setValidTime("2019-06-13");
            depositCouponRecService1.UpdateDepositCouponRec(tDepositCouponRec);
            System.out.println("操作成功");*/
            //Result= depositCouponRecService.UpdateDepositCouponRec(tDepositCouponRec);
            String key = MD5.MD5Encode(Common.key + StringUtil3.monthHOUR(-1));
            Map map = new HashMap();
            map.put("key", key);
            map.put("ID", Common.ID);
            map.put("parkId", "114");
            map.put("service", "acceptCoupon");
            //第三方权益信息接收API
            //map.put("data", "{\"carPlate\":\"粤CS0005\",\"parkId\":\"114\",\"orderId\":\"xxxxwqeqwew1111\",\"channelNo\":\"aaaa22\",\"couponType\":\"20\",\"couponValue\":\"1.1\",\"validTime\":\"2019-06-13\"}");
            //查询车主实时状态API
            //map.put("data", "{\"carPlate\":\"粤CS0006\"}");
            //车主实时状态接收API
            //map.put("data", "{\"carPlate\":\"粤CS0007\",\"parkId\":\"114\",\"inTime\":\"2019-04-01 11:35:21\",\"outTime\":\"2019-07-03 11:35:21\",\"orderId\":\"qweewre324324324\",\"status\":\"1\"}");
            String result = HttpUtil.doPost("http://localhost:8085/mainAction", map);
            System.out.println(result);


    }

    /**
     * 第三方API主入口
     * @param actionReq
     * @param bindingResult
     * @return
     * @throws Exception
     */

        @PostMapping(value = "/mainAction")
        public Callable mainAction(@Valid final ActionReq actionReq, final BindingResult bindingResult) throws Exception {
            logger.info(Thread.currentThread().getName()+"进入mainAction方法");
            Callable callable=new Callable() {
                boolean license = apiLicenseService.theThirdAPILicense(actionReq.getID(),actionReq.getKey());
                @Override
                public ActionRsp call() throws Exception {
                    //实例化返回车易泊数据实体类
                    String Result = null;
                    String globalParkId = actionReq.getParkId().toString();
                    String globalCarPlate = JsonUtil.json2Map(actionReq.getData().toString()).get("carPlate").toString();
                    logger.info(Thread.currentThread().getName()+"进入call方法");
                    //try{
                        logger.info(actionReq.toString());
                        /**
                         * 验证访问数据格式是否正确
                         */
                        if(bindingResult.hasErrors()){
                            /*actionRsp.setCode(3);
                            actionRsp.setMessage(bindingResult.getFieldError().getDefaultMessage());*/
                            logger.info("the format is error,time is"+ DateUtil.getCurrDateTime());
                            throw  new ActionRspException(ActionRspEnum.FORMAT_ERROR);
                        }else if (!license){
                            throw  new ActionRspException(ActionRspEnum.LICENSE_ERROR);
                        }
                        else
                        {

                            switch (actionReq.getService()){
                                //根据车牌号查询车主实时状态
                                case "getMemberInfo":
                                    Result=memberService.getMemberInfo(globalParkId,globalCarPlate);
                                    break;

                                //接受到进出场流水的时候，调用该API，及时更改车主状态
                                case "acceptCarStatus":
                                    TCarStatus tCarStatus = new TCarStatus();
                                    tCarStatus.setCarPlate(globalCarPlate);
                                    tCarStatus.setParkId(actionReq.getParkId());
                                    tCarStatus.setInTime(JsonUtil.json2Map(actionReq.getData().toString()).get("inTime").toString());
                                    tCarStatus.setOutTime(JsonUtil.json2Map(actionReq.getData().toString()).get("outTime").toString());
                                    tCarStatus.setStatus(Integer.valueOf(JsonUtil.json2Map(actionReq.getData().toString()).get("status").toString()));
                                    CarMember carMember = memberService.getCarMember(globalParkId,globalCarPlate);
                                    if (carMember==null){
                                        carStatusService.createCarAndMemberInfo(globalCarPlate,Integer.valueOf(globalParkId));
                                    }
                                    carMember = memberService.getCarMember(globalParkId,globalCarPlate);
                                    tCarStatus.setMemberId(carMember.getId());
                                    tCarStatus.setMemberName(carMember.getName());
                                    TCar tCar1 = new TCar();
                                    tCar1.setCarPlate(globalCarPlate);
                                    tCar1.setParkId(actionReq.getParkId());
                                    TCar tCar = carService.getCar(tCar1).get(0);
                                    tCarStatus.setCarId(tCar.getId());
                                    tCarStatus.setOrderId(JsonUtil.json2Map(actionReq.getData().toString()).get("orderId").toString());
                                    tCarStatus.setUpdateTime(DateUtil.getCurDateTime());
                                    Result=carStatusService.ThirdApiUpdateCarStatus(tCarStatus);



                                    break;

                                //接受第三方优惠
                                case "acceptCoupon":
                                    //TDepositCouponRec tDepositCouponRec = new TDepositCouponRec();
                                    MemberInfo memberInfo1 = JsonUtil.jsonToBean(memberService.getMemberInfo(globalParkId,globalCarPlate), MemberInfo.class);
                                    TDepositCouponRec tDepositCouponRec1=JsonUtil.jsonToBean(actionReq.getData().toString(), TDepositCouponRec.class);
                                    tDepositCouponRec1.setParkId(actionReq.getParkId());
                                    tDepositCouponRec1.setCouponLimit(1);
                                    tDepositCouponRec1.setMemberId(memberInfo1.getId());
                                    tDepositCouponRec1.setMemberName(memberInfo1.getName());
                                    TCar tCar2 = new TCar();
                                    tCar2.setCarPlate(globalCarPlate);
                                    tCar2.setParkId(actionReq.getParkId());
                                    List<TCar> tCarList = carService.getCar(tCar2);
                                    if (tCarList.size()<0){
                                        carStatusService.createCarAndMemberInfo(globalCarPlate,Integer.valueOf(globalParkId));
                                    }
                                    TCar tCar3 = carService.getCar(tCar2).get(0);
                                    tDepositCouponRec1.setCarId(tCar3.getId());
                                    tDepositCouponRec1.setValidTime(DateUtil.getCurDateTime());
                                    tDepositCouponRec1.setStatus(1);
                                    tDepositCouponRec1.setCreateTime(DateUtil.getCurDateTime());
                                    tDepositCouponRec1.setUpdateTime(DateUtil.getCurDateTime());
/*                                    tDepositCouponRec.setCarPlate(JsonUtil.json2Map(actionReq.getData().toString()).get("carPlate").toString());
                                    tDepositCouponRec.setOrderId(JsonUtil.json2Map(actionReq.getData().toString()).get("orderId").toString());
                                    tDepositCouponRec.setChannelNo(JsonUtil.json2Map(actionReq.getData().toString()).get("channelNo").toString());
                                    tDepositCouponRec.setCouponType((Integer) JsonUtil.json2Map(actionReq.getData().toString()).get("couponType"));
                                    tDepositCouponRec.setCouponValue((Double) JsonUtil.json2Map(actionReq.getData().toString()).get("couponValue"));
                                    tDepositCouponRec.setValidTime(JsonUtil.json2Map(actionReq.getData().toString()).get("validTime").toString());*/
                                    Result= depositCouponRecService.UpdateDepositCouponRec(tDepositCouponRec1);
                                    break;

                                default:
                                    logger.info("can not find this Service,ServiceName:"+actionReq.getService()+" time is"+ DateUtil.getCurrDateTime());
                                    break;
                                    //throw  new ActionRspException(ActionRspEnum.FIND_ERROR);
                            }
                        }
                   /* }
                    catch (Exception e){
                        logger.info("error:"+e.toString()+"time is "+e.toString());

                        //throw  new ActionRspException(ActionRspEnum.UNKONW_ERROR);
                    }*/
                    //String result=JsonUtil.beanToJson(actionRsp);
                    logger.info(Thread.currentThread().getName()+"从parkOrderService方法返回");
                     //response = new HttpServletResponse();
                   /* response.setHeader("Access-Control-Allow-Origin","*");
                    response.setHeader("Content-type", "text/html;charset=UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(result);*/
                    return ActionRspUtil.Success(Result);
                }
            };
            return  callable;
    }

}
