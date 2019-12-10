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



## spring-kafka-demo

事务发送、死信队列、手动确认等



# SringCloud

## SpringCloud-Demo

###  **eureka-server** 

- eureka配置
- eureka集群配置

### zuul-gateway

- zuul配置