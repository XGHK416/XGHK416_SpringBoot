package com.project.xghk416;

import cc.moecraft.icq.PicqBotX;
import cc.moecraft.icq.PicqConfig;
import com.project.xghk416.Listener.AddGroupListener;
import com.project.xghk416.Listener.DefaultMessageListener;
import com.project.xghk416.command.OpHelpCommand;
import com.project.xghk416.command.OpResumeCommand;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.project.xghk416.pojo.dao") //扫描的mapper
@SpringBootApplication
public class Xghk416Application {

    public static void main(String[] args) {
        PicqConfig config = new PicqConfig(8088);
        PicqBotX bot = new PicqBotX(config);
        bot.addAccount("小白金","127.0.0.1",31091);
        bot.getEventManager().registerListeners(new AddGroupListener(),new DefaultMessageListener());
        bot.enableCommandManager("ap");
        bot.getCommandManager().registerCommands(new OpResumeCommand(),new OpHelpCommand());
        bot.startBot();
        SpringApplication.run(Xghk416Application.class, args);
    }

}
