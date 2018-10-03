
## Feign

REST SERVICE CLIENT
 - openFeign spring cloud
 - simplicity of restTemplate build ,
 - integration with RIBON - client side Load balancing
 - @EnableFeignClients and Feign proxy to talk with other webservice
 
 ## Ribbon Load Balancing
 
 - can make use of proxy feign to talk with different instances of service
 - @RibbonClient 
 
 ## Zipkin + Sleuth
 
 Centralize logs from all services, sleuth provides id for logs which can be use to identify from where there comes from; 
 Approaches: 
 - we can use elastic search to search by all logs, 
 - here ZipkinDistribiutedServer with his tools 
 
 ## RabbitMQ 
 Use to queue all logs messages and Zipkin checks queue and collect on server all logs