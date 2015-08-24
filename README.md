**Spring Boot Rest oAuth Example**
===========================


**Follow this steps to run this application :**

 1. `~/gradlew clean build bootRun`
 
 2. Get code (from browser) : 
   http://localhost:8080/oauth/authorize?response_type=code&client_id=client-with-registered-redirect&redirect_url=http://localhost:8080/callback&scope=read

 3. post access token (from restclinet, ex, chrome rest plugin):POST http://localhost:8080/oauth/token
 Header: 
  Authorization: Basic Y2xpZW50LXdpdGgtcmVnaXN0ZXJlZC1yZWRpcmVjdDpzZWNyZXQxMjM= (Base64 of appname:app_password)
  Payload: grant_type=authorization_code&code=yourCode

 4. get data (from restclinet : chrome plugin) 
 GET http://localhost:8080/students/1
  Header : 
  Authorization: Bearer cd515d9d-56b1-4ef6-ae99-317d8975f292

  Replace the dummy codes with your codes .


----------

----------
 >**Note:**
 
> - Please note that, this code is still under development and with minimal security configuration and may be buggy.
> - Please feel free to commit or let me know if you can do here better code.

 >  > Happy coding with Boot !
 > email : shaon010@gmail.com
