package com.cloneproject.carrotmarket.controller;

import com.cloneproject.carrotmarket.controller.dto.UserSaveRequestDto;
import com.cloneproject.carrotmarket.service.UserService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Api()
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    // @RequiredArgsConstructor 사용시 private final 통해 의존성 주입이 가능.. @Resource or @ Autowired 사용 하지 않아도됨.
    private final UserService userService;
    //private final UserRepository userTableRepository;
    //private final GenerationCertNumber generationCertNumber;

//    @ApiOperation(value = "userList", notes = "회원 전체 List 조회")
//    @GetMapping("/userList")
//    public String userSearchAll(){
//        try {
//            logger.trace("Trace Level 테스트");
//            logger.debug("DEBUG Level 테스트");
//            logger.info("INFO Level 테스트");
//            logger.warn("Warn Level 테스트");
//            logger.error("ERROR Level 테스트");
//
//
//            logger.info("####### userSearchAll test ############");
//            return "hello"; //userService.usersAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    // 이메일 중복 검증
    @ApiOperation(value = "email", notes = "중복확인(중복인경우 : true, 중복이 아닌경우 : false)")
    @GetMapping("/mailCheck/{email}")
    public boolean userSearchId(@ApiParam(value = "email 계정", required = true) @PathVariable("email") String email){
        try {
            return userService.existsByEmail(email);
        }catch ( Exception e){
            e.printStackTrace();
        }
        return true;
    }

    // 활동명 중복 검증
    @ApiOperation(value = "nickName", notes = "중복확인(중복인경우 : true, 중복이 아닌경우 : false)")
    @GetMapping("/nameCheck/{nickName}")
    public boolean userSearchNickName(@ApiParam(value = "활동명", required = true) @PathVariable("nickName") String nickName){
        try {
            return userService.existsByNickName(nickName);
        }catch ( Exception e){
            e.printStackTrace();
        }
        return true;
    }

    // 인증번호 메일 전송 .. 고민중 어떻게 할지



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
//            if ( userTableRepository.existsByEmail(userSaveRequestDto.getEmail())){
//                resultFlag = "D";
//                resultMsg = "Email_Dup";
//                map.put("result_code", resultFlag);
//                map.put("result_msg", resultMsg);
//
//                return map;
//            }
//
//            if ( userTableRepository.existsByNickName(userSaveRequestDto.getNickName())){
//                resultFlag = "D";
//                resultMsg = "NickName_Dup";
//                map.put("result_code", resultFlag);
//                map.put("result_msg", resultMsg);
//
//                return map;
//            }

            // 이메일 인증 키
            // userSaveRequestDto.genAuthKey(generationCertNumber.executeGenerate());

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
//
//    @ApiOperation(value = "userInfoChange",notes = "회원정보 수정")
//    @PutMapping("/infoCh")
//    public ResponseEntity<User> userInfochange(@RequestBody User user){
//        logger.info("======== User change info =========");
//        logger.info("user info : "+user.toString());
//
//        try {
//
//            User updated_user = userService.userMod(user);
//
//            if(updated_user == null)
//                return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//
//            return new ResponseEntity<User>(updated_user,HttpStatus.OK);
//
//        }catch (Exception e){
//            logger.error(e.getMessage());
//            return new ResponseEntity<User>(HttpStatus.CONFLICT);
//        }
//
//    }


}
