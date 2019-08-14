<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Talentscamp接口列表</title>
</head>
<body>
   <ul type="square">
   	   <li>注册账号</li>
       <ol>
           <li>URL:  http://52.53.255.225/recurit/register</li>
           <li>method=post </li>
           <li>Parameter:  username/password</li>
           <li>return:  Account对象</li>
       </ol>
       <li>登录</li>
       <ol>
           <li>URL: http://52.53.255.225/recurit/login</li>
           <li>method=post </li>
           <li>Parameter: username/password</li>
       </ol>
       <li>后端管理-UserManager</li>
       <ol>
           <li>URL :  http://52.53.255.225/recurit/mg/user</li>
           <li>method=get </li>
           <li>return: person对象</li>
       </ol>
       <li>后端管理-UserManager-person</li>
       <ol>
           <li>URL : http://52.53.255.225/recurit/mg/se</li>
           <li>method=get </li>
           <li>return: person 列表</li>
       </ol>
       <li>user overview</li>
       <ol>
           <li>URL : http://52.53.255.225/recurit/mg/se/{id}</li>
           <li>method=get </li>
           <li>return: person对象</li>
       </ol>
       <li>后端管理-UserManager-company</li>
       <ol>
           <li>URL : http://52.53.255.225/recurit/mg/co</li>
           <li>method=get </li>
           <li>return: company列表</li>
       </ol>
       <li>company overview</li>
       <ol>
           <li>URL : http://52.53.255.225/recurit/mg/co/{id}</li>
           <li>method=get </li>
           <li>return: company对象</li>
       </ol>
       <li>首页,搜索JOB</li>
       <ol>
           <li>URL : http://52.53.255.225/recurit/job/search</li>
           <li>method=get </li>
           <li>Parameter: title / address, 2个参数为必填项 </li>
       </ol>
       <li>上传头像</li>
       <ol>
           <li>action="/recurit/upload/image" </li>
           <li>method=post </li>
           <li>Parameter: 图片 </li>
       </ol>
       <li>上传文件</li>
       <ol>
           <li>action="/recurit/upload/file" </li>
           <li>method=post </li>
           <li>Parameter: 文件 </li>
       </ol>
       <li>发布职位</li>
       <ol>
           <li>action=/co/job </li>
           <li>method=post </li>
           <li>Parameter: employerName/contactName/contactPhone/location </li>
       </ol>
       <li>更新职位</li>
       <ol>
           <li>action=/co/job </li>
           <li>method=put </li>
           <li>Parameter: employerName/contactName/contactPhone/location </li>
       </ol>
       <li>发布职位明细</li>
       <ol>
           <li>action=/co/job/{jobId} </li>
           <li>method=post </li>
           <li>Parameter: type/overTime/category/minSalary/maxSalary/hires/emergencyLevel/shiftStartTime/qualification </li>
       </ol>
       <li>更新职位明细</li>
       <ol>
           <li>action=/co/job/{jobId} </li>
           <li>method=put </li>
           <li>Parameter: type/overTime/category/minSalary/maxSalary/hires/emergencyLevel/shiftStartTime/qualification </li>
       </ol>
   </ul>
   
</body>
</html>