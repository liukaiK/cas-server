**把一下内容加入到HOSTS文件里面**  

`127.0.0.1 cas.unicom.com`   
`127.0.0.1 www.community.com`  
`127.0.0.1 www.smartcity.com`  


获取code  

GET请求  
http://cas.unicom.com:8080/oauth/authorize?response_type=code&client_id=community&redirect_uri=http://www.community.com


获取token  

POST请求  
http://cas.unicom.com:8080/oauth/token  
Content-Type: application/x-www-form-urlencoded
Authorization: Basic Y29tbXVuaXR5OjEyMzQ1Ng==
grant_type=authorization_code&code=4PBTYU&redirect_uri=http://www.community.com
