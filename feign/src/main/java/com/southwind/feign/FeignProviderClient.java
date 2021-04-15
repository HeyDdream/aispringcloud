package com.southwind.feign;

import com.southwind.entity.Student;
import com.southwind.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
//fallback表示如果服务系统有问题，就会走FeignError这个类，实现服务降级
@FeignClient(value = "provider",fallback = FeignError.class)  //这里表示FeignProviderClient是调用哪个服务，使用服务名来确定
public interface FeignProviderClient {

    @GetMapping("/student/findAll")
    public Collection<Student> findAll();

    @GetMapping("/student/index")
    public String index();
}
