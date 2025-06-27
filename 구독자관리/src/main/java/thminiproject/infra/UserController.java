package thminiproject.infra;
import thminiproject.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/users")
@Transactional
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/users/registeruser",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public User registerUser(HttpServletRequest request, HttpServletResponse response, 
        ) throws Exception {
            System.out.println("##### /user/registerUser  called #####");
            User user = new User();
            user.registerUser();
            userRepository.save(user);
            return user;
    }
    @RequestMapping(value = "/users/booksubscriberequest",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public User bookSubscribeRequest(HttpServletRequest request, HttpServletResponse response, 
        ) throws Exception {
            System.out.println("##### /user/bookSubscribeRequest  called #####");
            User user = new User();
            user.bookSubscribeRequest();
            userRepository.save(user);
            return user;
    }
    @RequestMapping(value = "/users/writereview",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public User writeReview(HttpServletRequest request, HttpServletResponse response, 
        ) throws Exception {
            System.out.println("##### /user/writeReview  called #####");
            User user = new User();
            user.writeReview();
            userRepository.save(user);
            return user;
    }
    @RequestMapping(value = "/users/addbooktowishlist",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public User addBookToWishlist(HttpServletRequest request, HttpServletResponse response, 
        ) throws Exception {
            System.out.println("##### /user/addBookToWishlist  called #####");
            User user = new User();
            user.addBookToWishlist();
            userRepository.save(user);
            return user;
    }
    @RequestMapping(value = "/users/subscribemonthlyplan",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public User subscribeMonthlyPlan(HttpServletRequest request, HttpServletResponse response, 
        ) throws Exception {
            System.out.println("##### /user/subscribeMonthlyPlan  called #####");
            User user = new User();
            user.subscribeMonthlyPlan();
            userRepository.save(user);
            return user;
    }
}
//>>> Clean Arch / Inbound Adaptor
