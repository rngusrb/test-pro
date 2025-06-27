package thminiproject.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "포인트 관리", url = "${api.url.포인트 관리}")
public interface PointService {
    @RequestMapping(
        method = RequestMethod.POST,
        path = "/points/{id}//usepoint"
    )
    public void usePoint(
        @PathVariable("id") Long userId,
        @RequestBody UsePointCommand usePointCommand
    );
}
