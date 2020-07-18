package com.project.xghk416.command;

import cc.moecraft.icq.command.CommandProperties;
import cc.moecraft.icq.command.interfaces.EverywhereCommand;
import cc.moecraft.icq.event.events.message.EventMessage;
import cc.moecraft.icq.sender.message.MessageBuilder;
import cc.moecraft.icq.sender.message.components.ComponentImage;
import cc.moecraft.icq.user.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.xghk416.pojo.dao.ArkOperatorBaseDao;
import com.project.xghk416.pojo.po.ArkOperatorBasePo;
import com.project.xghk416.service.serviceImpl.ArkRobotServiceImpl;
import com.project.xghk416.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class OpResumeCommand implements EverywhereCommand {

    @Override
    public String run(EventMessage eventMessage, User user, String s, ArrayList<String> arrayList) {
        ArkRobotServiceImpl arkRobotService= SpringUtils.getBean(ArkRobotServiceImpl.class);
        String rankType = "default";
        String baseUrl = "https://xghk416.oss-cn-beijing.aliyuncs.com/BiliSpy/arkWiki/op/";
        List<String> commands = Arrays.asList(eventMessage.message.split("\\s+"));
//        System.out.println(commands);
        if (commands.size()==3){
            if (arkRobotService.judgeHasOperator(commands.get(1))){
                return new MessageBuilder()
                        .add("没找到该干员")
                        .toString();
            }
            if (judgeRankType(commands.get(2))){
                rankType = commands.get(2);
            }
        }else if (commands.size()==2){
            if (arkRobotService.judgeHasOperator(commands.get(1))){
                return new MessageBuilder()
                        .add("没找到该干员")
                        .toString();
            }
        }else {
            return new MessageBuilder()
                    .add("指令不完整")
                    .toString();
        }

//        https://xghk416.oss-cn-beijing.aliyuncs.com/BiliSpy/arkWiki/op/12F_rank_default.png
        String completeUrl = baseUrl+commands.get(1)+"_rank_"+rankType+".png";
//        System.out.println(completeUrl);
//        System.out.println(eventMessage.message);
        return new MessageBuilder()
                .add(new ComponentImage(completeUrl))
                .toString();
    }

    @Override
    public CommandProperties properties() {
        return new CommandProperties("o");
    }

    public Boolean judgeRankType(String type){
//        System.out.println(type);
        boolean result = false;
        boolean isNum = type.matches("[0-9]*");
//        System.out.println(isNum);
        if (isNum) {
            if (Integer.parseInt(type) > 0 && Integer.parseInt(type) <= 3) {
                result = true;
            }
        }
        return result;
    }
}
