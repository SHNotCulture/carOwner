package com.carOwner.service.impl;


import com.carOwner.entity.Common;
import com.carOwner.service.APILicenseService;
import com.carOwner.util.MD5;
import com.carOwner.util.StringUtil3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author jin
 * @Data 2019/3/14 14:46
 **/
@Service
public class APILicenseServiceImpl implements APILicenseService {

    @Override
    public Boolean theThirdAPILicense(String ID,String key) {
        Boolean status = false;


            String date1 = StringUtil3.monthHOUR(-1);
            String date2 = StringUtil3.monthHOUR(0);
            String KEY1 = MD5.MD5Encode(Common.key + date1);
            String KEY2 = MD5.MD5Encode(Common.key + date2);
            System.out.println("KEY:"+KEY1);
            if (key.equals(KEY1) || key.equals(KEY2)) {
                status = true;
            }

        return status;
    }

}
