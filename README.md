# SpringBoot

## springboot-demo

### ConvertionService_and_PropertyEditor_and_HttpMessageConverter

- 自定义ConvertionService
- 自定义PropertyEditor
- 自定义HttpMessageConverter 
- 对比@ModelAttribute 和 @ RequestParam 区别

### Formatter_and_CustomJsonDeserializer_JsonSerializer

- APPLICATION_FORM_URLENCODED_VALUE 因为通过RequestParamMethodArgumentResolver（@RequestParam）或ServletModelAttributeMethodProcessor（@ModelAttribute）通过调用ConvertionService来做类型转换，Formatter也是Converter，所以使用Formatter转换。 

- APPLICATION_JSON_VALUE 通过RequestResponseBodyMethodProcessor来处理，RequestResponseBodyMethodProcessor使用HttpMessageConverter转换HttpMessageConverter中需要用到json序列化器。所以使用自定义Deserializer。
- 因为输出都加了@ResponseBody 所以都通过Serializer来序列化。

### RestTemplate
自定义HttpClient （自定义HttpComponentsClientHttpRequestFactory），构造RestTemplate
- 使用连接池
-  关闭自动重试
- 自定义keepalive策略（CustomConnectionKeepAliveStrategy，自带的策略是没有keepalive头信息，就连接永久有效，改为连接默认30秒有效）

## spring-kafka-demo

事务发送、死信队列、手动确认等



# SringCloud

## SpringCloud-Demo

### config-server

- 基于git 的配置中心

###  **eureka-server**

- eureka配置
- eureka集群配置

### eureka-waiter-service

- 服务提供者

### feign-customer-service

- 服务消费
- feign 负载均衡
- Hystrix 熔断

### hystrix-dashboard-demo

### zuul-gateway

- zuul配置