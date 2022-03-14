package com.koreait.cgvproject.controller.user.page;

import com.koreait.cgvproject.dto.MemberDTO;
import com.koreait.cgvproject.entity.Member;
import com.koreait.cgvproject.entity.Point;
import com.koreait.cgvproject.repository.MemberRepository;
import com.koreait.cgvproject.repository.PointRepository;
import com.koreait.cgvproject.service.admin.member.MemberService;
import com.koreait.cgvproject.service.user.login.UserLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserMycgvController {

    private final UserLoginService userLoginService;
    private final HttpSession httpSession;
    private final String ROOT = "user/mycgv";
    private final MemberService memberService;
    @Autowired
    private PointRepository pointRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/user/mycgv")
    public String mycgv(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT+"/mycgv";
    }

    @GetMapping("/user/mycgv/point")
    public String mycgv_cgvPoint(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/point/mycgv-cgvPoint";
    }

    @GetMapping("/user/mycgv/point/mycgv-cgvPoint-pointInfo")
    public String mycgv_cgvPoint_pointInfo(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/point/mycgv-cgvPoint-pointInfo";
    }

    @GetMapping("/user/mycgv/point/mycgv-cgvPoint-pointList")
    public String mycgv_cgvPoint_pointList(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        List<Point> points = pointRepository.findAll();
        model.addAttribute("points", points);
        return ROOT + "/point/mycgv-cgvPoint-pointList";
    }

    @GetMapping("/user/mycgv/event")
    public String mycgv_event(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/event/mycgv-event";
    }

    @GetMapping("/user/mycgv/event/mycgv-event-resultList")
    public String mycgv_event_resultList(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/event/mycgv-event-resultList";
    }

    @GetMapping("/user/popup/mycgv-favoriteTheaters")
    public String mycgv_favoriteTheaters(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/popup/mycgv-favoriteTheaters";
    }

    @GetMapping("/user/mycgv/inquiry/mycgv-lost-list")
    public String mycgv_lost_list(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/inquiry/mycgv-lost-list";
    }

    @GetMapping("/user/mycgv-movielog-expected")
    public String mycgv_movielog_expected(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/movielog/mycgv-movielog-expected";
    }

    @GetMapping("/movies/point/mycgv-movielog-mylist")
    public String mycgv_movielog_mylist(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/movielog/mycgv-movielog-mylist";
    }

    @GetMapping("/user/movielog/mycgv-movielog-watched")
    public String mycgv_movielog_watched(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/movielog/mycgv-movielog-watched";
    }

    @GetMapping("/user/mycgv/mycgv-myinfo")
    public String mycgv_myinfo(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/myinfo/mycgv-myinfo";
    }

    @PostMapping("/user/mycgv/myinfo/mycgv-myinfo-edit")
    public String putProfile( @ModelAttribute MemberDTO memberDTO, Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        memberService.update(member.getIdx(), memberDTO);

        return ROOT + "/myinfo/mycgv-myinfo-edit-myinfo";
    }

    @PostMapping("/user/mycgv/myinfo/mycgv-myinfo-edit-myinfo")
    public String postProfile(@RequestParam(required = false) String userid, @RequestParam(required = false) String userpw){
        if(userLoginService.login(userid,userpw)) {
            return "redirect:/user/mycgv/myinfo/mycgv-myinfo-edit-myinfo";
        }
        return "redirect:/user/mycgv/mycgv-myinfo"; //다시 로그인
    }
    @GetMapping("/user/mycgv/myinfo/mycgv-myinfo-edit-myinfo")
    public String mycgv_myinfo_edit_myinfo(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/myinfo/mycgv-myinfo-edit-myinfo";
    }

    @GetMapping("/user/mycgv/myinfo/mycgv-myinfo-edit-myinfo-myprofile")
    public String mycgv_myinfo_edit_myinfo_myprofile(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/myinfo/mycgv-myinfo-edit-myinfo-myprofile";
    }

    @GetMapping("/user/mycgv/myinfo/mycgv-myinfo-leavecgv")
    public String mycgv_myinfo_leavecgv(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        memberService.delete(member.getIdx());
        return "redirect:/user/logout";
    }

    @GetMapping("/user/mycgv/mycgv-popcorn-store")
    public String mycgv_popcorn_store(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/popcorn-store/mycgv-popcorn-store";
    }

    @GetMapping("/user/mycgv/popcorn-store/mycgv-popcorn-store-paymentList")
    public String mycgv_popcorn_store_paymentList(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/popcorn-store/mycgv-popcorn-store-paymentList";
    }

    @GetMapping("/user/popup/mycgv-popupedit-profile")
    public String mycgv_popupedit_profile(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/popup/mycgv-popupedit-profile";
    }

    @GetMapping("/user/mycgv/inquiry/mycgv-qna-list")
    public String mycgv_qna_list(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/inquiry/mycgv-qna-list";
    }

    @GetMapping("/user/mycgv/mycgv-reserve")
    public String mycgv_reserve(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/reserve/mycgv-reserve";
    }

    @GetMapping("/user/vip-lounge")
    public String vip_lounge(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/vip/vip-lounge";
    }

    @GetMapping("/user/mycgv/popcorn-store/mycgv-popcorn-store-paymentDetail")
    public String mycgv_popcorn_store_paymentDetail(Model model){
        Member member = memberService.getMember((String)httpSession.getAttribute("userid"));
        model.addAttribute("member", member);
        return ROOT + "/popcorn-store/mycgv-popcorn-store-paymentDetail";
    }

}
