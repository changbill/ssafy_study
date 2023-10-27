package com.ssafy.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.user.model.dto.User;
import com.ssafy.user.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api-user")
@Api(tags = "유저 컨트롤러")
public class UserRestController {
    
    //UserService 라고 하는 친구를 주입
    @Autowired
    private UserService userService;
    
    // 전체 유저 가져와
    @GetMapping("users")
    @ApiOperation(value = "유저 조회", notes = "유저들 불러와")
    public List<User> userList() {
        return userService.getUserList();
    }
    

    @PostMapping("signup")
    public ResponseEntity<Integer> signup(User user) {        
        int result = userService.signup(user);
        
        // result가 0이면 등록 X
        // result가 1이면 등록 O
        
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }
    
    // ID, PW가 맞는 지 확인만 해서
    // 프론트로 넘겨주겠다.
    // value=~~, produce=~~ => header 한글로 나오게 하는 코드
    @PostMapping(value="login" , produces="text/plain;charset=UTF-8")
    @ApiResponse(code = 200, message = "성공")
    public ResponseEntity<?> login(String id, String pass, @ApiIgnore HttpSession session) {
        User tmp = userService.login(id,pass);
        //로그인 실패 (잘못했어)
        if(tmp == null)
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED); // 권한이 없다.
        
        session.setAttribute("loginUser", tmp.getName());
        return new ResponseEntity<String>(tmp.getName(), HttpStatus.OK);
    }
    
    @GetMapping("logout")
    public ResponseEntity<String> logout(@ApiIgnore HttpSession session) {
//        session.removeAttribute("loginUser");
        session.invalidate();
        
        return new ResponseEntity<String>("Logout", HttpStatus.OK);
        
    }
    
    
    
}