package org.example.controller;

import org.example.dto.Member;
import org.example.service.MemberService;

public abstract class Controller {
    public static Member loginedMember;
    protected static MemberService memberService;

    public static boolean isLogined(){
        return loginedMember != null;
    }
    public abstract void doAction(String cmd, String actionMethodName);
    public abstract void makeTestData();

}
