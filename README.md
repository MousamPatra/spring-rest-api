# spring-security
this repo is just for basic reference of spring security

------------------------

1. fop - basic auth	=>	username password based login only
			in the basic auth we simply set a username name and password in properties file and used that for client get request. on request it verify the cred and create a session id.

2. fop - csrf token	=>	using csrf to get post request
			in basic auth we are only allow to get request. for post/put/delete request we need to use csrf token generated with session id.

3. fob - security config	=>	making security filter chain customize
				in this, we are disabling the default security filter chain and CSRF token, and also adding a custom filter chain.

4. fob - userdeatils in code	=>	creating UserDetailsService bean  
				instead of getting userid and password from properties we are using UserDetailsService and used multiple ids access.

5. fob - userdeatils from db	=>	getting userdeatils from db
				instead of hardcoding the ids in code, getting from db. for that configure SecurityFilterChain -> AuthenticationProvider -> UserDetailsService (MyUserDetailsService) -> UserDetails (MyUserDetails) -> UserModel and UserRepo

6. fob - userdeatils from db with encryption	=>	on register saved password with encryption
				for that configure SecurityFilterChain -> AuthenticationProvider -> UserDetailsService (MyUserDetailsService) -> UserDetails (MyUserDetails) -> UsrController("/register") -> UserService -> UserModel and UserRepo

7. fob - jwt token generate	=>	login, generate token on success login

8. fob - jwt			=>	request with jwt, validate and access data