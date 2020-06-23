package com.cloneproject.carrotmarket.controller;

import com.cloneproject.carrotmarket.component.GenerationCertNumber;
import com.cloneproject.carrotmarket.controller.dto.UserSaveRequestDto;
import com.cloneproject.carrotmarket.domain.user.User;
import com.cloneproject.carrotmarket.domain.user.UserRepository;
import com.cloneproject.carrotmarket.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@Api()
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @Resource
    private UserRepository userTableRepository;

    @Resource
    private GenerationCertNumber generationCertNumber;

    @ApiOperation(value = "userList", notes = "회원 전체 List 조회")
    @GetMapping("/userList")
    public String userSearchAll(){
        try {
            logger.trace("Trace Level 테스트");
            logger.debug("DEBUG Level 테스트");
            logger.info("INFO Level 테스트");
            logger.warn("Warn Level 테스트");
            logger.error("ERROR Level 테스트");


            logger.info("####### userSearchAll test ############");
            return "hello"; //userService.usersAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{email}")
    public Optional userSearchId(@ApiParam(value = "사용자의 email 주소", required = true) @PathVariable("email") String email){
        try {
            return userService.userEmail(email);
        }catch ( Exception e){
            e.printStackTrace();
        }
        return null;
    }

    // 닉네임 중복 검증

    // 이메일 중복 검증


    // 회원 가입
    @ApiOperation(value = "joinUser", notes = "회원 가입정보")
    @PostMapping("/userReg")
    public Map joinUser(@RequestBody UserSaveRequestDto userSaveRequestDto){
        logger.info("======== User Reg =========");
        logger.info("user info : "+userSaveRequestDto.toString());

        /*
        * 필수값 및 중복 체크 로직은?
        *
        * */

        Map map = new HashMap();
        String resultFlag = "E";
        String resultMsg = "Error";

        try {
            if ( userTableRepository.existsByEmail(userSaveRequestDto.getEmail())){
                resultFlag = "D";
                resultMsg = "Email_Dup";
                map.put("result_code", resultFlag);
                map.put("result_msg", resultMsg);

                return map;
            }

            if ( userTableRepository.existsByNickName(userSaveRequestDto.getNickName())){
                resultFlag = "D";
                resultMsg = "NickName_Dup";
                map.put("result_code", resultFlag);
                map.put("result_msg", resultMsg);

                return map;
            }

            // 이메일 인증 키
            userSaveRequestDto.genAuthKey(generationCertNumber.executeGenerate());

            map.put("user", userService.join(userSaveRequestDto));

            resultFlag = "S";
            resultMsg = "Success";
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("result_code", resultFlag);
        map.put("result_msg", resultMsg);

        return map;
    }

    @ApiOperation(value = "userInfoChange",notes = "회원정보 수정")
    @PutMapping("/infoCh")
    public ResponseEntity<User> userInfochange(@RequestBody User user){
        logger.info("======== User change info =========");
        logger.info("user info : "+user.toString());

        try {

            User updated_user = userService.userMod(user);

            if(updated_user == null)
                return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

            return new ResponseEntity<User>(updated_user,HttpStatus.OK);

        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }

    }


}
