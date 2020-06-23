package com.cloneproject.carrotmarket.service;

import com.cloneproject.carrotmarket.component.MailSenderCustom;
import com.cloneproject.carrotmarket.controller.dto.UserSaveRequestDto;
import com.cloneproject.carrotmarket.domain.user.User;
import com.cloneproject.carrotmarket.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final MailSenderCustom mailSenderCustom;

    private final UserRepository userTableRepository;

    @Transactional
    @Override
    public List<User> usersAll()  throws Exception {
        logger.trace("Trace Level 테스트"); logger.debug("DEBUG Level 테스트"); logger.info("INFO Level 테스트"); logger.warn("Warn Level 테스트"); logger.error("ERROR Level 테스트");


        return userTableRepository.findAll();
    }

    @Transactional
    @Override
    public Optional userEmail(String email) throws Exception {
        return userTableRepository.findByEmail(email);
    }

    @Transactional
    @Override
    public User join(UserSaveRequestDto userSaveRequestDto) throws Exception {

        Map<String,Object> sendInfo = new HashMap<>();
        User user = userTableRepository.save(userSaveRequestDto.toEntity());

        sendInfo.put("subject", "[당근마켓] 회원 가입 인증 메일");
        sendInfo.put("msg", new StringBuilder().append("<h3>안녕하세요.^^ "+ user.getNickName() + "님.</h3>")
                                               .append("<h3>당근 마켓 회원 가입 인증 메일 입니다.</h3>")
                                               .append("<h3>회원 가입 인증 번호 입니다</h3>")
                                               .append("<div style=\"background-color: lightgray; width: fit-content;\">")
                                               .append("<p style=\"align-items: center ;  font-size: 25px; color: red;\">"+user.getAuthKey()+"</p>")
                                               .append("</div>")
                                               .append("<h3>인증 번호를 복사하거나,</h3>")
                                               .append("<h3><a href=\"www.naver.com\">여기를 눌러 회원가입을 완료 하세요.</a></h3>")
                                               .toString());

        // sendInfo.put("fromAddress","");
        sendInfo.put("toAddress",user.getEmail());
        sendInfo.put("fromName","carrot-market");

        mailSenderCustom.sendEmailSimple(sendInfo);

        return user;
    }

    @Transactional
    @Override
    public User userConfirm(User user) throws Exception {


        return user;
    }

    @Transactional
    @Override
    public User userMod(User user) throws Exception {

        User origin_user = userTableRepository.findByNickName(user.getNickName());

        if( origin_user == null)
            return null;

        if( !origin_user.equals(user) )
            return null;

        if( user.getEtc() != null)
            //origin_user.setEtc(user.getEtc());

        userTableRepository.save(origin_user);

        return origin_user;
    }

    @Transactional
    @Override
    public String userDel(String userId) throws Exception {
        return null;
    }
}
