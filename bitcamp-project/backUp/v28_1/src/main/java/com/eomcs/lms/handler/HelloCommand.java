package com.eomcs.lms.handler;

import com.eomcs.util.Prompt;

public class HelloCommand implements Command {

  public Prompt prompt;

  public HelloCommand(Prompt prompt) {
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    String name = prompt.inputString("이름? ");
    System.out.printf("%s님 반갑습니다.\n", name);
    System.out.println();
  }

}
