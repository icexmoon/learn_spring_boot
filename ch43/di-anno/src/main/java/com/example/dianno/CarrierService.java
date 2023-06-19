package com.example.dianno;

import com.example.dianno.entity.Carrier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-anno
 * @Package : com.example.dianno
 * @ClassName : .java
 * @createTime : 2023/6/18 20:00
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class CarrierService {
//    @Autowired
    private Carrier defaultCar;

    public Carrier getDefaultCarrier() {
        return defaultCar;
    }

    public void setDefaultCar(final Carrier defaultCar){
        this.defaultCar = defaultCar;
    }
}
