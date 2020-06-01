package com.cloneproject.carrotmarket.controller;

import com.cloneproject.carrotmarket.component.GenerationCertNumber;
import com.cloneproject.carrotmarket.model.User;
import com.cloneproject.carrotmarket.repository.UserTableRepository;
import com.cloneproject.carrotmarket.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.Id;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @Resource
    private UserTableRepository userTableRepository;

    @Resource
    private GenerationCertNumber generationCertNumber;

    @GetMapping("/testUserCreate")
    public String testUserCreate(){
//        userTableRepository.save( User.builder().nickName("test1").email("test1@gmail.com").build());
//        userTableRepository.save( User.builder().nickName("test2").email("test2@gmail.com").build());
//        userTableRepository.save( User.builder().nickName("test3").email("test3@gmail.com").build());
//        userTableRepository.save( User.builder().nickName("test4").email("test4@gmail.com").build());
//        userTableRepository.save( User.builder().nickName("test5").email("test5@gmail.com").build());
//        userTableRepository.save( User.builder().nickName("test6").email("test6@gmail.com").build());
//        userTableRepository.save( User.builder().nickName("test7").email("test7@gmail.com").build());

        return "회원 초기데이터 생성";
    }

    @GetMapping("")
    public List<User> userSearchAll(){
        try {
            logger.info("####### userSearchAll test ############");
            return userService.usersAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{usrId}")
    public Optional userSearchId(@PathVariable("usrId") Long userId){
        try {
            return userService.user(userId);
        }catch ( Exception e){
            e.printStackTrace();
        }
        return null;
    }

    // 닉네임 중복 검증

    // 이메일 중복 검증


    // 회원 가입
    @PostMapping("")
    public Map joinUser(@RequestBody User user){
        logger.info("======== User Reg =========");
        logger.info("user info : "+user.toString());

        /*
        * 필수값 및 중복 체크 로직은?
        *
        * */

        Map map = new HashMap();
        String resultFlag = "E";
        String resultMsg = "Error";

        try {
            if ( userTableRepository.existsByEmail(user.getEmail())){
                resultFlag = "D";
                resultMsg = "Email_Dup";
                map.put("result_code", resultFlag);
                map.put("result_msg", resultMsg);

                return map;
            }

            if ( userTableRepository.existsByNickName(user.getNickName())){
                resultFlag = "D";
                resultMsg = "NickName_Dup";
                map.put("result_code", resultFlag);
                map.put("result_msg", resultMsg);

                return map;
            }

            // 이메일 인증 키
            user.setAuthKey(generationCertNumber.executeGenerate());

            userService.userReg(user);

            resultFlag = "S";
            resultMsg = "Success";
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("return_object", user);
        map.put("result_code", resultFlag);
        map.put("result_msg", resultMsg);

        return map;
    }

    //
}
