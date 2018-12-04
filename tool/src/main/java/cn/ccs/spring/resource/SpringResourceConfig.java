package cn.ccs.spring.resource;

import cn.ccs.spring.lazy.LazyBeans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by chaichuanshi on 2016/10/27.
 */

@Configurable
@EnableAspectJAutoProxy
@ComponentScan(value = {"cn.ccs.spring.resource"},lazyInit = true)
public class SpringResourceConfig {


}
